package UF2PSP.PracticaProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 48089748z on 07/10/15.
 */
public class Executa
{
    static String sortida = null;
    static String comando = "cmd /c d:suma.exe 10 2";
    public Executa (String comando)
    {
        this.comando = comando;
        executarComanda(comando);
    }

    public static void executarComanda (String comando)
    {
        try
        {
            //Ejecucion basica del comando
            Process proceso = Runtime.getRuntime().exec(comando);

            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);

            if ((sortida = stdInput.readLine()) != null)
            {
                System.out.println("Comanda correctament executada");
                while ((sortida = stdInput.readLine()) != null)
                {
                    System.out.println(sortida);
                }
            }
        } catch (IOException e)
        {
            System.out.println("ERROR: " + e);
            e.printStackTrace();
        }
    }
}
