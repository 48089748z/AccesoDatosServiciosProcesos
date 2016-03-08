package AceptaElReto;

import java.util.Scanner;

/**
 * Created by 48089748z on 02/02/16.
 */
public class HolaMundo116
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        print(Integer.parseInt(sc.nextLine()));
    }

    public static void print(Integer numero)
    {
        for (int x=0; x<numero; x++)
        {
            System.out.println("Hola mundo.");
        }
    }
}

