package UF3PSP.Calculadora;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 * Created by 48089748z on 03/02/16.
 */
public class ClienteCalculadora
{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("\nIntroduce Operación con Numberos y / + - *");
        String mensajeAEnviar = in.nextLine();
        try
        {
            Socket clienteSocket = new Socket();
            InetSocketAddress address = new InetSocketAddress("localhost", 5555);
            clienteSocket.connect(address);
            InputStream input = clienteSocket.getInputStream();
            OutputStream output = clienteSocket.getOutputStream();
            output.write(mensajeAEnviar.getBytes());

            Integer contador=0;
            byte[] mensaje = new byte[1000];
            input.read(mensaje);
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
            System.out.println("\nResultado devuelto por el servidor -> "+msg);

            clienteSocket.close();
            input.close();
            output.close();
        }
        catch (IOException e) {}
    }
}
