package UF3PSP.ServidorFILE;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 48089748z on 08/03/16.
 */
public class Client
{
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("\nTIENES LOS SIGUIENTES ARCHIVOS EN EL SERVIDOR ¿CUAL QUIERES DESCARGAR?");
        System.out.println("1- /home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo1.txt");
        System.out.println("2- /home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo2.txt");
        System.out.println("3- /home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo3.txt");
        System.out.println("4- /home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo4.txt");
        System.out.println("5- /home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ServidorFILE/FilesTest/archivo5.txt");
        String option = in.nextLine();
        try
        {
            Socket clienteSocket = new Socket();
            InetSocketAddress address = new InetSocketAddress("localhost", 5555);
            clienteSocket.connect(address);
            InputStream input = clienteSocket.getInputStream();
            OutputStream output = clienteSocket.getOutputStream();
            output.write(option.getBytes());
            System.out.println("\nENVIADA PETICIÓN PARA DESCARGAR EL ARCHIVO "+option);
            Integer contador = 0;
            byte[] mensaje = new byte[1000000];
            input.read(mensaje);
            for (int x = 0; x < mensaje.length; x++) {
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
            if (msg.equals("OPCIÓN INVALIDA!")){
                System.out.println("\nOPCIÓN INVALIDA!");
            }
            else
            {
                System.out.println("\nArchivo Descargado del Servidor con Exito \n\nContenido del archivo:\n" + msg);
            }

            clienteSocket.close();
            input.close();
            output.close();
        } catch (IOException e) {}
    }
}
