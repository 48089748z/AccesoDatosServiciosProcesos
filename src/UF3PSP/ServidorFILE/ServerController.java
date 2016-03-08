package UF3PSP.ServidorFILE;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket servidorSocket = new ServerSocket();
            InetSocketAddress address = new InetSocketAddress("localhost",5555);
            System.out.println("\nServidor para files escuchando");
            servidorSocket.bind(address);
            while (true)
            {
                Socket listener = servidorSocket.accept();
                ServerThread thread = new ServerThread(listener);
                thread.run();
            }
        }
        catch (IOException e){}
    }
}
