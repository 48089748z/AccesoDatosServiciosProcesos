package UF3PSP.CalculadoraMultifil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by 48089748z on 04/02/16.
 */
public class FilOperacions extends Thread
{
    private static Socket listener;
    private static String infoToSave;
    public FilOperacions (Socket listener)
    {
       this.listener=listener;
    }
    public void run()
    {
        try
        {
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

            String resultado = calcular(msg);
            System.out.println("\nResultado de la operación: "+resultado);
            output.write(calcular(msg).getBytes());

            infoToSave = "\n\nFECHA: "+new Date().toString()+"\nIP: "+listener.getInetAddress().toString()+"/"+listener.getLocalPort()+"\nOPERACIÓN: "+msg+"\nRESULTADO: "+resultado;
            listener.close();
            input.close();
            output.close();
            saveInfoInAFile();
        }
        catch (IOException e){}
    }
    public static void saveInfoInAFile()
    {
        try
        {
            File info = new File("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/CalculadoraMultifil/log.odt");
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

    public static String calcular(String msg)
    {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result = "Ha fallado el calculo.";
        try {result = engine.eval(msg).toString();}
        catch (ScriptException e) {}
        return result;
    }
}
