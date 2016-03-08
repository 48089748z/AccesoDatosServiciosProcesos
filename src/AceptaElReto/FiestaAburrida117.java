package AceptaElReto;

import java.util.Scanner;

/**
 * Created by 48089748z on 02/02/16.
 */
public class FiestaAburrida117
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        String numero = sc.nextLine();
        String[] vs = new String[Integer.parseInt(numero)];

        for (int x=0; x<vs.length; x++)
        {
            vs[x] = modifcarCadena(sc.nextLine());
        }

        for (int x=0; x<vs.length; x++)
        {
            System.out.println(vs[x]);
        }
    }

    public static String modifcarCadena(String cadena)
    {
        String x = cadena.substring(4,cadena.length());
        return "Hola, "+x+".";

    }
}
