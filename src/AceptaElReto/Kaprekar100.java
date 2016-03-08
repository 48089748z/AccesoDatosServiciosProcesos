package AceptaElReto;
import java.util.*;

/**
 * Created by 48089748z on 28/01/16.
 */
public class Kaprekar100
{
    private static Integer contador=0;
    private static Integer timesLeft=-1;
    private static int[] numeros;

    public static void main(String[] args)
    {

        while (timesLeft!=0)
        {
            Scanner in = new Scanner(System.in);
            Integer cifra = in.nextInt();
            if (timesLeft==-1)
            {
                numeros = new int[cifra];
                timesLeft = cifra;
            }
            else
            {
                contador=0;
                Scanner ins = new Scanner(System.in);
                ordenador(ins.nextInt());
                timesLeft--;

            }
        }
    }

    public static void ordenador(Integer cifra)
    {
        contador++;
        if (cifra!=6174)
        {
            Integer[] order = new Integer[4];
            Character primera = cifra.toString().charAt(0);
            Character segunda = cifra.toString().charAt(1);
            Character tercera = cifra.toString().charAt(2);
            Character cuarta = cifra.toString().charAt(3);

            order[0] = Integer.parseInt(String.valueOf(primera));
            order[1] = Integer.parseInt(String.valueOf(segunda));
            order[2] = Integer.parseInt(String.valueOf(tercera));
            order[3] = Integer.parseInt(String.valueOf(cuarta));

            Arrays.sort(order); //Ordenados ascendentemente.
            String numeroAscendente = "";
            String numeroDescente = order[3].toString() + order[2].toString() + order[1].toString() + order[0].toString();
            for (int x = 0; x < order.length; x++)
            {
                numeroAscendente = numeroAscendente + String.valueOf(order[x]);
            }
            Integer numeroA = Integer.parseInt(numeroAscendente);
            Integer numeroB = Integer.parseInt(numeroDescente);
            Integer resultado = numeroB - numeroA;

            System.out.println(contador);
            ordenador(resultado);
        }
    }
}
