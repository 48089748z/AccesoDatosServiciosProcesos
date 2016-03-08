package UF3PSP.ServidorWEB;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerThread extends Thread{

    Path filePath = Paths.get("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/web.html");
    Socket socket;
    public ServerThread(Socket socket) {this.socket = socket;}
    @Override
    public void run()
    {
        try
        {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            byte[] mensaje = new byte[100000000];
            is.read(mensaje);
            System.out.println(socket.getInetAddress().toString());
            os.write(getFileBytes(filePath));
            socket.close();
            is.close();
            os.close();
        } catch (IOException e){}
    }
    private static byte[] getFileBytes(Path filePath)
    {
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {return null;}
    }
}
