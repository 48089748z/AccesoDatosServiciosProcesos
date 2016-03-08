package UF3PSP.ServidorWEB;
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
            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress address = new InetSocketAddress("0.0.0.0", 5555);
            serverSocket.bind(address);
            Socket socket = serverSocket.accept();
            ServerThread thread = new ServerThread(socket);
            thread.start();

        } catch (IOException e) {}
    }
}
