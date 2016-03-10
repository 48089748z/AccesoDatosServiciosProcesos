package UF3PSP.ExamenUF3PSP.Exercici1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerThread extends Thread{

    Path filePath = Paths.get("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ExamenUF3PSP/Exercici1/web.html"); //PATH DEL FITXER HTML
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
            os.write(getFileBytes(filePath)); //ESCRIBIM EL FITXER
            socket.close();
            is.close();
            os.close();
        } catch (IOException e){}
    }
    private static byte[] getFileBytes(Path filePath) //METODE PER CONVERTIR UN FILE A ARRAY DE BYTES MITJANÇANT EL SEU PATH
    {
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {return null;}
    }
}
