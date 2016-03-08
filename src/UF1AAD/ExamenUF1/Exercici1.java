package UF1AAD.ExamenUF1;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by 48089748z on 05/11/15.
 */
public class Exercici1
{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
            System.out.println("Escribe una ruta: ");
            String path = in.next();
            recursivo(path);
    }
    public static void recursivo(String path) //Metodo recursivo para buscar archivos dentro de directorios y mostrar ultima modificación de cada archivo
    {
        try //Control de errores
        {
            File file = new File(path);
            Date fechaUltimaModificación = new Date(file.lastModified());
            if (file.isDirectory())
            {
                File[] lista = file.listFiles(); //Listamos los archivos
                System.out.println(file.getName().toUpperCase()+ " es un directorio");
                for (int x=0; x<lista.length; x++)
                {
                    if (lista[x].isDirectory())
                    {
                        recursivo(lista[x].getAbsolutePath());
                    }
                    else if (lista[x].isFile())
                    {
                        System.out.println(lista[x].getName().toUpperCase()+" es un archivo, Ultima Modificación  --->  "+fechaUltimaModificación);
                    }
                }
            }
            else if (file.isFile())
            {
                System.out.println(file.getName().toUpperCase()+" 1Es un archivo, Ultima Modificación  --->  "+fechaUltimaModificación);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
