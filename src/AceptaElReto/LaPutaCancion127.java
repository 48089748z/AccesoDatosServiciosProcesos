package AceptaElReto;

import java.util.Scanner;

public class LaPutaCancion127
{
    private String test1 = "Anastasio Ignacio Felipe Borja Daniel Cesar F 2 3"; //ANASTASIO DANIEL
    private String test2 = "Javier Ramiro Luis Rosa Carmen Paola Josefa F 0 3"; //NADIE TIENE CAMA
    private String test3 = "Petra Santiago Pepi F 2 20"; //PETRA PEPI
    private String test4 = "Merche Juanjo Miriam Pilar Marina Ovidio Rafael Eustaquio F 4 7"; //MERCHE MIRIAM PILAR MARINA
    private String test5 = "Merche Juanjo Miriam Pilar Marina F 5 3";

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String numero = sc.nextLine();
        String[] array = new String[Integer.parseInt(numero)];
        String[] results = new String[Integer.parseInt(numero)];

        for (int x=0; x<array.length; x++)
        {
            array[x] = sc.nextLine();
            results[x] = calc(array[x]);
        }
        print(results);
    }
    public static String calc(String linea)
    {
        Integer camas;
        Integer songTimes;
        String [] merda = linea.split(" ");
        camas = Integer.parseInt(merda[merda.length-2]);
        if (camas==0)
        {
            return"NADIE TIENE CAMA";
        }
        else if (camas>=merda.length-3)
        {
            return "TODOS TIENEN CAMA";
        }
        else
        {
            songTimes = Integer.parseInt(merda[merda.length -1]);
            String [] peregrinos = new String[merda.length-3];
            for (int x=0; x<peregrinos.length; x++)
            {
                peregrinos[x] = merda[x];
            }
            Integer posicio = 0;
            for (int x=0; x<peregrinos.length-camas; x++)
            {
                Integer contador =0;
                while (true)
                {
                    if (posicio == peregrinos.length-1)
                    {
                        posicio=0;
                    }else {
                        posicio++;
                        if (peregrinos[posicio].equals(""))
                        {


                        } else
                        {
                            contador++;
                            if (songTimes == contador)
                            {
                                peregrinos[posicio] = "";

                                break;
                            }
                        }
                    }
                }
            }
            String nombres="";
            for (int x=0; x<peregrinos.length; x++)
            {
                if (!peregrinos[x].equals(""))
                {
                    nombres= nombres+peregrinos[x]+" ";
                }
            }
            return nombres;
        }
    }
    public static void print(String[] results)
    {
        for (int x=0; x<results.length; x++)
        {
            System.out.println(results[x]);
        }
    }
}