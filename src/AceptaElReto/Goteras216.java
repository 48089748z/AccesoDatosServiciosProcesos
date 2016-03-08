package AceptaElReto;

import java.util.Scanner;

/**
 * Created by 48089748z on 02/02/16.
 */
public class Goteras216
{
    private static String[]results;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String numero = sc.nextLine();
        String[] array = new String[Integer.parseInt(numero)];

        results = new String[Integer.parseInt(numero)];
        for (int x=0; x<array.length; x++)
        {
            array[x] = sc.nextLine();
            results[x] =  calc(array[x]);
        }
        print();
    }
    public static String calc(String x)
    {
        int numero = Integer.parseInt(x);
        long horas=0;
        long minutos=0;
        long segundos;

        String horasS;
        String minutosS;
        String segundosS;

        while(true)
        {
            if (numero>=3600)
            {
                horas++;
                numero = numero - 3600;
            }
            else if(numero>=60)
            {
                minutos++;
                numero = numero - 60;
            }
            else
            {
                segundos = numero;
                break;
            }
        }

        if (horas<10)
        {
           horasS = "0"+horas;
        }
        else
        {
            horasS = String.valueOf(horas);
        }
        if (minutos<10)
        {
            minutosS = "0"+minutos;
        }
        else
        {
            minutosS = String.valueOf(minutos);
        }
        if (segundos<10)
        {
            segundosS = "0"+segundos;
        }
        else
        {
            segundosS = String.valueOf(segundos);
        }
        return horasS+":"+minutosS+":"+segundosS;

    }

    public static void print()
    {
        for (int x=0; x<results.length; x++)
        {
            System.out.println(results[x]);
        }
    }
}
