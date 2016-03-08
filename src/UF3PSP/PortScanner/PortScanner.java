package UF3PSP.PortScanner;

/**
 * Created by 48089748z on 04/02/16.
 */
import java.net.Socket;
public class PortScanner
{
    private static String IP = "localhost";

    public static void main(String[]args)
    {
        System.out.println("\nLISTA DE PUERTOS ABIERTOS EN '"+ IP.toUpperCase()+"'\n");
        for (Integer x=0; x<50000; x++) {scanPort(x);} //Scanearemos los puertos entre 0 y 50000
    }
    public static void scanPort(Integer port)
    {
        try
        {
            Socket socket = new Socket(IP, port);
            System.out.println(port);
            socket.close();
        }
        catch (Exception one) {}
    }
}
