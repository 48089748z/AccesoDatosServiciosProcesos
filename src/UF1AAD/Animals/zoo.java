package UF1AAD.Animals;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by 48089748z on 29/09/15.
 */
public class zoo
{
    private static String ruta = "//home//48089748z//Escriptori//gabia.ser"; //Ruta del fitxer .ser

    public static void main(String args[]) //Main
    {
        try //Control d'errors del main
        {
            Scanner in = new Scanner(System.in);
            ArrayList arrayAnimals = new ArrayList(); //A mes de guardar els animals a un fitxer .ser també els guardo a un ArrayList
            int index = 0;
            boolean close = false; //Mentre aquesta variable sigui false el menú del meu programa continuará executantse

            while (close == false)
            {
                System.out.println("\nESCOGE UNA OPCION\n0: SALIR\n1:CREAR ANIMAL\n2:ENCERRAR ANIMAL\n3:LIBERAR ANIMAL"); //Menú
                int opcio = in.nextInt();
                switch (opcio)
                {
                    case 1: //Cas 1 : Ens permet escriure el nom del animal i el seu codi, si el codi no es valid el ficara a null, tot aixo es guardara al ArrayList d'animals
                    {
                        System.out.println("Escriu el nom del Animal");
                        String basura = in.nextLine();
                        String nom = in.nextLine();
                        System.out.println("Escriu el codi (EX EW CR EN VU NT LC)");
                        String codi = in.nextLine();
                        if (validar(codi))
                        {
                            arrayAnimals.add(new animal(nom, codi));
                            System.out.println("S'ha creat l'animal " + arrayAnimals.get(index).toString());
                            index++;
                        }
                        else
                        {
                            System.out.println("Codi Invalid, sha ficat a null.");
                            codi = null;
                            arrayAnimals.add(new animal(nom, codi));
                            index++;
                        }
                        break;
                    }
                    case 2: //Cas 2 Si volem tancar el animal dins del fitxer serialitzable, ens permet escollir la id del animal que volem tancar i el guarda dins del fitxer .ser
                    {
                        for (int x = 0; x < arrayAnimals.size(); x++)
                        {
                            if (arrayAnimals.get(x) == null) break;
                            else System.out.println("Animal con ID: " + x + " = " + arrayAnimals.get(x).toString());
                        }
                        System.out.println("Escoje la ID del UF1AAD.Animals.animal que quieres encerrar");
                        int id = in.nextInt();
                        engabiar((animal) arrayAnimals.get(id), ruta);
                        break;
                    }
                    case 3: //Cas 3 Si volem alliberar un animal, el que fara es borrarlo del fitxer serialitzable i del ArrayList on també esta guardat
                    {
                        liberar(in, arrayAnimals);
                        break;
                    }
                    case 0: //Cas 0 Serveix per acabar amb el bucle del menu i per tant finalitzar el programa
                    {
                        close = true;
                        System.out.println("\nTancant el programa");
                        break;
                    }
                    default: //Opcio default, si clickem cualsevol numero que no es una opcio del menu, no fara cap mes accio que indicarnos que aquesta opcio no existeix i ens demanara una altre.
                    {
                        System.out.println("Aquesta opcio no existeix");
                        break;
                    }
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Catch del metode 'main' ");
        }
    }

    private static void liberar(Scanner in, ArrayList arrayAnimals)  //Aixo treu el UF1AAD.Animals.animal seleccionat del ArrayList i del fitxer serialitzable
    {
        try
        {
            for (int x = 0; x < arrayAnimals.size(); x++) //Aquest for ens monstra tota la llista de tots els animals guardats al ArrayList
            {
                System.out.println("Animal con ID numero " + x + ":" + arrayAnimals.get(x).toString());
            }
            System.out.println("Escoje la ID del Animal que quieres liberar");
            int id = in.nextInt();
            System.out.println(arrayAnimals.get(id).toString() + " LIBERADO");
            arrayAnimals.remove(id);
            borrarDelFitxerSerialitzable(ruta); //I tambe el treu del fitxer .ser
        }
        catch (Exception e)
        {
            System.out.println("Catch del metode 'liberar'");
        }
    }

    public static boolean validar(String codi)//EX EW CR EN VU NT LC Aquesta funcio ens valida si el codi que em introduit es valid o no, si no ho es ens el ficara a null
    {
        try
        {
            if (codi.toLowerCase().equals("ex") || codi.toLowerCase().equals("ew") || codi.toLowerCase().equals("cr") || codi.toLowerCase().equals("en") || codi.toLowerCase().equals("vu") || codi.toLowerCase().equals("nt") || codi.toLowerCase().equals("lc")) return true;
            else return false;
        }
        catch (Exception e)
        {
            System.out.println("Catch del metode 'liberar'");
            return false;
        }
    }


    public static void engabiar(animal animal, String ruta) //Aquest metode ens guardara l'animal amb la id que li indiquem a dins del fitxer .ser
    {
        try
        {
            FileOutputStream fileOut = new FileOutputStream(ruta);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(animal);
            out.close();
            fileOut.close();
            System.out.println("Animal guardat a " + ruta);

        }
        catch(IOException i)
        {
            System.out.println("Catch del metode 'engabiar'");
        }
    }


    public static void borrarDelFitxerSerialitzable(String ruta) //Aquest metode borrara l'animal amb la id que li indiquem del fitxer .ser
    {
        animal x = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(ruta);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            x = (animal) in.readObject();
            in.close();
            fileIn.close();
        }
        catch(IOException i)
        {
            System.out.println("Catch (IOException) del metode 'borrarDelFitxerSerialitzable'");
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("Catch (ClassNotFoundException) del metode 'borrarDelFitxerSerialitzable'");
            System.out.println("No funciona la classe UF1AAD.Animals.animal");
        }
        System.out.println("LIBERADO: " + x.toString());
    }
}
