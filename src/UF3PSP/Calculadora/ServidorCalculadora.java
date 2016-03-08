package UF3PSP.Calculadora;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by 48089748z on 03/02/16.
 */
public class ServidorCalculadora
{
    private static String infoToSave;
    public static void main(String[] args)
    {
        try
        {
            ServerSocket servidorSocket = new ServerSocket();
            InetSocketAddress address = new InetSocketAddress("localhost",5555);
            System.out.println("\nServidor Calculadora escuchando...");
            servidorSocket.bind(address);
            Socket listener = servidorSocket.accept();
            InputStream input = listener.getInputStream();
            OutputStream output = listener.getOutputStream();

            byte[] mensaje = new byte[30];
            input.read(mensaje);
            System.out.println("\nServidor ha recibido el mensaje de la IP "+listener.getInetAddress().toString()+"/"+listener.getLocalPort());
            Integer contador = 0;
            for (int x=0; x<mensaje.length; x++)
            {
                if (mensaje[x]==0) {break;}
                else {contador++;}
            }
            byte[] mensajeLimpio = new byte[contador];
            for (int x=0; x<mensajeLimpio.length; x++)
            {
                mensajeLimpio[x] = mensaje[x];
            }
            String msg = new String(mensajeLimpio);
            System.out.println("\nOperación -> "+msg);

            output.write(calcular(msg).getBytes());
            System.out.println("\nResultado de la operación: "+calcular(msg));

            infoToSave = "\n\nFECHA: "+new Date().toString()+"\nIP: "+listener.getInetAddress().toString()+"/"+listener.getLocalPort()+"\nOPERACIÓN: "+msg+"\nRESULTADO: "+calcular(msg);
            listener.close();
            servidorSocket.close();
            input.close();
            output.close();
            saveInfoInAFile();
        }
        catch (IOException e){}
    }
    public static String calcular(String msg)
    {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result = "Ha fallado el calculo.";
        try {result = engine.eval(msg).toString();}
        catch (ScriptException e) {}
        return result;
    }
    public static void saveInfoInAFile()
    {
        try
        {
            File info = new File("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/Calculadora/log.odt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(info, true));
            if (info.exists())
            {
                bw.write(infoToSave);
            }
            else
            {
                info.createNewFile();
                bw.write(infoToSave);
            }
            bw.close();
        } catch (IOException e) {}
    }
}
