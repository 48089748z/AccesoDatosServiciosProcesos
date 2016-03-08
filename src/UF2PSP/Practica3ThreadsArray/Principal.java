package UF2PSP.Practica3ThreadsArray;

/**
 * Created by 48089748z on 14/10/15.
 */

import java.util.*;

public class Principal
{
    public static int arrayNumeros[] = new int[1000]; //Creamos el array global de 1000 posiciones
    public static Thread[] arrayThreads; //Instanciamos el array de UF2PSP.Threads
    public static int index=0;
    public static int amountOfNumbersPerThread;
    public static boolean numThreadsCorrect=true;
    public static int numThreads;
    public static void main(String[] args)
    {
        while (numThreadsCorrect)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("\nEscriu el Nº de UF2PSP.Threads que vols     (Han de ser numeros Divisibles de 1000)\n");
            int num = in.nextInt();
            if (num%1000==0)
            {
                numThreads=num;
                numThreadsCorrect=false;
            }
            else
            {
                System.out.println("El numero que has escrit no es divisible de 1000!");
            }
        }

        arrayThreads = new Fil[numThreads];
        amountOfNumbersPerThread = 1000/numThreads;

        omplirArrayThreads();


        for (int x=0; x<numThreads; x++)
        {
            for (int y=0; y<amountOfNumbersPerThread; y++)
            {
                arrayThreads[x].run();
                System.out.println("  Thread " + x + " ha afegit el Nº " + index + " al Array de Numeros  \n-----------------------------------------------------------------------------");
                index++;
            }
        }
        //imprimirArrayNumerosPerComprovar();
    }

    private static void omplirArrayThreads()
    {
        for (int x=0; x<numThreads; x++)
        {
            arrayThreads[x]= new Fil();
        }
    }

    public static void afegirNum()
    {
        arrayNumeros[index]=index;
    }

    public static Thread[] getArrayThreads()
    {
        return arrayThreads;
    }

    public static void setArrayThreads(Thread[] arrayThreads)
    {
        Principal.arrayThreads = arrayThreads;
    }

    public static int[] getArrayNumeros()
    {
        return arrayNumeros;
    }

    public static void setArrayNumeros(int[] arrayNumeros)
    {
        Principal.arrayNumeros = arrayNumeros;
    }

    public static int getIndex()
    {
        return index;
    }

    public static void setIndex(int index)
    {
        Principal.index = index;
    }

    public static int getAmountOfNumbersPerThread()
    {
        return amountOfNumbersPerThread;
    }

    public static void setAmountOfNumbersPerThread(int amountOfNumbersPerThread)
    {
        Principal.amountOfNumbersPerThread = amountOfNumbersPerThread;
    }

    private static void imprimirArrayNumerosPerComprovar()
    {
        System.out.println("\n -----     IMPRIMINT ARRAY DE NUMEROS     -----");
        for (int x=0; x<arrayNumeros.length; x++)
        {
            System.out.println(" ---> "+arrayNumeros[x]);
        }
        System.out.println("\n -----     IMPRIMIT ARRAY DE NUMEROS     -----");
    }
}
