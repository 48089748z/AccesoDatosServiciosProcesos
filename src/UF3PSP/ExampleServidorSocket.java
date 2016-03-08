package UF3PSP.Calculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Created by 48089748z on 27/01/16.
 */
public class ExampleServidorSocket
{
    private String myIp = "172.31.83.33";
    public static void main(String[] args)
    {
        try
        {
            ServerSocket servidorSocket = new ServerSocket();
            InetSocketAddress address = new InetSocketAddress("localhost",5555);
            System.out.println("\nServidor escuchando...");
            servidorSocket.bind(address);
            Socket listener = servidorSocket.accept();
            InputStream input = listener.getInputStream();
            OutputStream output = listener.getOutputStream();
            byte[] mensaje = new byte[20];
            input.read(mensaje);
            System.out.println("\nMensaje -> \n"+new String(mensaje));
            listener.close();
            servidorSocket.close();
            input.close();
            output.close();
        }
        catch (IOException e) {}
    }
}
