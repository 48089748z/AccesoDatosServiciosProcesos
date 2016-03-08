package UF2PSP.SuperMarket;

import java.util.Date;

/**
 * Created by 48089748z on 04/11/15.
 */
public class Client extends Thread
{
    public static long miliSegonsIniciProces;
    public static long miliSegonsFinalProces;
    public void run()
    {
        Date dataIniciProces = new Date();
        miliSegonsIniciProces = dataIniciProces.getTime();
        int random = 1000 + (int)(Math.random()*6000); //Fem un sleep de entre 1 y 6segons
        try {sleep(random);}
        catch (InterruptedException one) {}
        Date dataFinalProces = new Date();
        miliSegonsFinalProces = dataFinalProces.getTime();
    }
    public static long calcMiliSegonsTranscorreguts()
    {
        return miliSegonsFinalProces - miliSegonsIniciProces;
    }

}
