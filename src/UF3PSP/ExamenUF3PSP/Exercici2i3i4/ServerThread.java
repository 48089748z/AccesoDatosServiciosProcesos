package UF3PSP.ExamenUF3PSP.Exercici2i3i4;
import java.io.*;
import java.net.Socket;
public class ServerThread extends Thread
{
    private static Saver saver = new Saver();
    Socket socket;
    public ServerThread(Socket socket) {this.socket = socket;}
    @Override
    public void run()
    {
        try
        {
            InputStream is = socket.getInputStream();
            saver.saveInfoInAFile("Cogiendo el InputStream del Socket.");
            OutputStream os = socket.getOutputStream();
            saver.saveInfoInAFile("Cogiendo el OutPutStream del Socket.");
            String toWrite = "HOLA ME LLAMO ORIOL\nRemote Socket Address: "+socket.getRemoteSocketAddress().toString()+"\nLocal Socket Address: "+socket.getLocalSocketAddress().toString();
            saver.saveInfoInAFile("Escribiendo en el navegador.");
            System.out.println(socket.getRemoteSocketAddress().toString());
            System.out.println(socket.getLocalSocketAddress().toString());
            byte[] mensaje = new byte[1000000];
            is.read(mensaje);

            String comprobar = new String(mensaje);
            if (comprobar.contains("POST"))
            {
                saver.saveInfoInAFile("Es una Petición POST");
                socket.close();
                is.close();
                os.close();
            }
            else
            {
                saver.saveInfoInAFile("Es una Petición GET");
                os.write(toWrite.getBytes());
                socket.close();
                is.close();
                os.close();
                saver.saveInfoInAFile("Cerrando Sockets, Input y Output.");
            }


        } catch (IOException e){
            saver.saveInfoInAFile("El Thread ha entrado en el CATCH.");
            e.printStackTrace();
        }
    }

}
