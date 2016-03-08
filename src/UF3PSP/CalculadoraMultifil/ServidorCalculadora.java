package UF3PSP.CalculadoraMultifil;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by 48089748z on 03/02/16.
 */
public class ServidorCalculadora
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket servidorSocket = new ServerSocket();
            InetSocketAddress address = new InetSocketAddress("localhost",5555);
            System.out.println("\nServidor Calculadora con Hilos escuchando...");
            servidorSocket.bind(address);
            while (true)
            {
                Socket listener = servidorSocket.accept();
                FilOperacions hilo = new FilOperacions(listener);
                hilo.run();
            }
        }
        catch (IOException e){}
    }
}
