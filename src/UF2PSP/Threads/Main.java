package UF2PSP.Threads;

/**
 * Created by 48089748z on 07/10/15.
 */
public class Main
{
    public static void main(String args[]) //El que pasa es que com que s'executen tots alhora a vegades s'imprimeixeixen per pantalla desendreçats
    {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread3()).start();
    }
}
