package UF3PSP.ExamenUF3PSP.Exercici2i3i4;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerController
{
    private static Saver saver = new Saver();
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket();
            saver.saveInfoInAFile("Creando Server Socket.");
            InetSocketAddress address = new InetSocketAddress("0.0.0.0", 9090); //LE DECIMOS QUE SERA ACCESIBLE EN EL PUERTO 9090
            saver.saveInfoInAFile("Creando InetSocketAddress.");
            serverSocket.bind(address);
            saver.saveInfoInAFile("Haciendo el bind.");
            Socket socket = serverSocket.accept(); //BIND I ACCEPT
            saver.saveInfoInAFile("Haciendo el accept");
            ServerThread thread = new ServerThread(socket);
            saver.saveInfoInAFile("Iniciando el Thread.");
            thread.start(); //INICIAMOS EL THREAD

        } catch (IOException e) {
            saver.saveInfoInAFile("El Controlador ha entrado en el CATCH.");
            e.printStackTrace();}
    }

}
