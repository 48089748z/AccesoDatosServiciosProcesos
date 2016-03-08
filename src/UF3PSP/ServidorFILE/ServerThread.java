package UF3PSP.ServidorFILE;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by 48089748z on 08/03/16.
 */
public class ServerThread extends Thread
{
    Socket listener;
    private static Path fileToDownload;
    private static InputStream input;
    private static OutputStream output;
    public ServerThread(Socket listener)
    {
        this.listener=listener;
    }

    public void run()
    {
        try
        {
            input = listener.getInputStream();
            output = listener.getOutputStream();
            byte[] mensaje = new byte[100000000];
            input.read(mensaje);
            System.out.println("\nServidor ha recibido el mensaje de la IP " + listener.getInetAddress().toString() + "/" + listener.getLocalPort());
            Integer contador = 0;
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
            System.out.println("\nDEVOLVIENDO ARCHIVO -> " + msg);
            enviarArchivo(msg);
            input.close();
            output.close();
            listener.close();
        }
        catch (IOException one){}
    }
    public static void enviarArchivo(String numero)
    {
        switch(numero)
        {
            case "1":
            {
                fileToDownload = Paths.get("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo1.txt");
                download();
                break;
            }
            case "2":
            {
                fileToDownload = Paths.get("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo2.txt");
                download();
                break;
            }
            case "3":
            {
                fileToDownload = Paths.get("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo3.txt");
                download();
                break;
            }
            case "4":
            {
                fileToDownload = Paths.get("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo4.txt");
                download();
                break;
            }
            case "5":
            {
                fileToDownload = Paths.get("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo5.txt");
                download();
                break;
            }
            default:
            {
                try {output.write("OPCIÓN INVALIDA!".getBytes());}
                catch (IOException e) {}
                finally{break;}

            }
        }
    }
    private static byte[] getFileBytes(Path filePath)
    {

        try
        {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {return null;}
    }
    private static void download()
    {
        try
        {
            output.write(getFileBytes(fileToDownload));
        } catch (IOException e) {}
    }
}
