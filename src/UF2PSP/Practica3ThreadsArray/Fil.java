package UF2PSP.Practica3ThreadsArray;

/**
 * Created by 48089748z on 14/10/15.
 */
public class Fil extends Thread
{
    public static int ordre=0;
    public void run()
    {
        Principal.afegirNum();
        System.out.print("Ejecució numero: "+ordre+" --->");
        ordre++;
    }
}
