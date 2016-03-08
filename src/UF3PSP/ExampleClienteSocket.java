package UF3PSP.Calculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
/**
 * Created by 48089748z on 27/01/16.
 */
public class ExampleClienteSocket
{
    private String myIp = "172.31.83.33";
    public static void main(String[] args)
    {
        try
        {
            Socket clienteSocket = new Socket();
            InetSocketAddress address = new InetSocketAddress("localhost", 5555);
            clienteSocket.connect(address);
            InputStream input = clienteSocket.getInputStream();
            OutputStream output = clienteSocket.getOutputStream();
            String mensaje = "Este mensaje ha sido enviando desde la clase ExampleClienteSocket ha la clase ExampleServidorSocket.";
            output.write(mensaje.getBytes());
            clienteSocket.close();
            input.close();
            output.close();
        }
        catch (IOException e) {}
    }
}
