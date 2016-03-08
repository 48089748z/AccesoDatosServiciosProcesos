package UF2PSP.PracticaProcesos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by 48089748z on 07/10/15.
 */
public class ComunicacioProcessos
{
    static String sortida = null;
    public static Scanner in = new Scanner(System.in);

    public static void main(String args[]) //El main lo lee y lo imprime
    {
        executarComanda("/home/48089748z/Baixades/NOBORRAR/alea");

    }
    public static void executarComanda (String comando) //Este metodo ejecuta cualquier comando que le pase
    {
        try
        {
            while (true)
            {
                System.out.println("\nEscribe lo que quieras 'fin' para exit");
                String cadena = in.nextLine();
                if (cadena.toLowerCase().equals("fin"))
                {
                    System.out.println("\nFinalizando ejecuciones");
                    break;
                }
                else
                {
                    Process p = Runtime.getRuntime().exec(comando);
                    InputStreamReader entrada = new InputStreamReader(p.getInputStream());
                    BufferedReader stdInput = new BufferedReader(entrada);

                    if ((sortida = stdInput.readLine()) != null)
                    {
                        System.out.println("Comando ejecutado sin errores");
                        while ((sortida = stdInput.readLine()) != null)
                        {
                            System.out.println(sortida);
                        }
                    }
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}
