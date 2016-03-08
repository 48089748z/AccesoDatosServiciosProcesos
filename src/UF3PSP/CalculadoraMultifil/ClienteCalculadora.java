package UF3PSP.CalculadoraMultifil;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 48089748z on 03/02/16.
 */
public class ClienteCalculadora
{
    private static Scanner in = new Scanner(System.in);
    private static String dionisIP = "172.31.83.197";
    private static String uriIP = "localhost";

    public static void main(String[] args)
    {
        System.out.println("\nIntroduce Operación con Numberos y / + - *");
        String mensajeAEnviar = in.nextLine();
        try {
            Socket clienteSocket = new Socket();
            InetSocketAddress address = new InetSocketAddress(uriIP, 5555);
            clienteSocket.connect(address);
            InputStream input = clienteSocket.getInputStream();
            OutputStream output = clienteSocket.getOutputStream();
            output.write(mensajeAEnviar.getBytes());

            Integer contador = 0;
            byte[] mensaje = new byte[10];
            input.read(mensaje);
            for (int x = 0; x < mensaje.length; x++)
            {
                if (mensaje[x] == 0) {
                    break;
                } else {
                    contador++;
                }
            }
            byte[] mensajeLimpio = new byte[contador];
            for (int x = 0; x < mensajeLimpio.length; x++) {
                mensajeLimpio[x] = mensaje[x];
            }
            String msg = new String(mensajeLimpio);
            System.out.println("\nResultado devuelto por el hilo -> " + msg);

            clienteSocket.close();
            input.close();
            output.close();
        } catch (IOException e) {}
    }
}
