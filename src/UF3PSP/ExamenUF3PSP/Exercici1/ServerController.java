package UF3PSP.ExamenUF3PSP.Exercici1;
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
            InetSocketAddress address = new InetSocketAddress("0.0.0.0", 9090); //LE DECIMOS QUE SERA ACCESIBLE EN EL PUERTO 9090
            serverSocket.bind(address);
            Socket socket = serverSocket.accept(); //BIND I ACCEPT
            ServerThread thread = new ServerThread(socket);
            thread.start(); //INICIAMOS EL THREAD

        } catch (IOException e) {e.printStackTrace();}
    }
}
