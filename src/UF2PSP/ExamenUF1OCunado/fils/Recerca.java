package UF2PSP.ExamenUF1OCunado.fils;

import java.util.ArrayList;

public class Recerca extends Thread
{
    private ArrayList<Double> resultats;
    public Recerca(){}
    public void run()
    {
        resultats = new ArrayList<>();
        resultats.add(mainLog.getLog()); //Añadimos al ArrayList de resultados el Math.log del numero correspondiente.
    }
    public void imprimir() //Impresor de resultados, esto tan solo imprime un Arraylist.
    {
        for (Double resultat : resultats)
        {
            System.out.println("   " + resultat + "\n-----------------------------------------------------------------------------");
        }
    }
}
