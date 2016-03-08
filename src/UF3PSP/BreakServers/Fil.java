package UF3PSP.BreakServers;

import java.io.*;
import java.net.Socket;


/**
 * Created by 48089748z on 10/02/16.
 */
public class Fil extends Thread
{
    private static Socket clienteSocket;
    private static String mensajeAEnviar;
    public Fil (Socket clienteSocket, String mensajeAEnviar)
    {
        this.clienteSocket=clienteSocket;
        this.mensajeAEnviar=mensajeAEnviar;
    }
   public void run()
   {
       while (true)
       {
           try
           {
               OutputStream output = clienteSocket.getOutputStream();
               output.write(mensajeAEnviar.getBytes());
               System.out.println("ENVIADO: "+mensajeAEnviar);
           }   catch (IOException e) {}
       }
   }
}
