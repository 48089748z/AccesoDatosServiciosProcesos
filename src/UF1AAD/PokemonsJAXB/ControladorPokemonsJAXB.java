package UF1AAD.PokemonsJAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by 48089748z on 13/10/15.
 */
public class ControladorPokemonsJAXB
{
    private static String rutaXmlPokemons = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.PokemonsJAXB/pokemons.xml"; //Ruta del Fichero xml en mi pc
    private static File ficheroXmlPokemons = new File(rutaXmlPokemons); //Creamos un File con la ruta anterior
    private static boolean stop=false; //Boolean para el bucle del Menu
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) //Main method
    {
        while (stop==false)
        {
            System.out.println("\n----------------------------\n0: Finalizar Programa\n1: Mostrar Pokemons con JAXB\n2: Añadir Pokemon\n----------------------------");
            int option = in.nextInt();
            switch (option)
            {
                case 0: //Cierra el programa
                {
                    stop=true;
                    System.out.println("Programa Cerrado");
                    break;
                }
                case 1: //Nos muestra los pokemons
                {
                    showPokemons();
                    break;
                }
                case 2: //Añade pokemons a la List y al XML
                {
                    addPokemon();
                    break;
                }
                default:
                {
                    System.out.println("Esa opción no existe");
                }
            }
        }
    }
    public static void showPokemons() //Muestra los pokemons con un UNMARSHALLER
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Pokedex.class);
            Unmarshaller UMS = context.createUnmarshaller();
            Pokedex RST = (Pokedex) UMS.unmarshal(ficheroXmlPokemons);

            System.out.println("\n----------------------------\nNº de UF1AAD.PokemonsJAXB: " + RST.getPokemon().size());
            for (int x=0; x<RST.getPokemon().size(); x++)
            {
                System.out.println("Pokemon "+x+"   --->   "+RST.getPokemon().get(x).getNombre().getValue());
            }
            System.out.println("\n----------------------------");
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
    public static void addPokemon() //Pide los datos del Pokemon que queremos añadir y lo mete en la List luego llama al metodo que hace el MARSHALL y lo guarda en el XML
    {
        try
        {
            System.out.println("Escribe el nombre del Pokemon");
            String name = in.next();

            System.out.println("Escribe el tipo del Pokemon");
            String type = in.next();

            System.out.println("Escribe los puntos de vida del Pokemon");
            BigInteger pv = in.nextBigInteger();

            System.out.println("Escribe el Ataque 1 del Pokemon");
            String attack = in.next();

            Pokemon pokemonToAdd = new Pokemon();
            Nombre nameOfPokemonToAdd = new Nombre();
            nameOfPokemonToAdd.setClasse(type);
            nameOfPokemonToAdd.setValue(name);
            pokemonToAdd.setNombre(nameOfPokemonToAdd);
            pokemonToAdd.setPV(pv);
            pokemonToAdd.setAtaque1(attack);
            System.out.println("\n"+pokemonToAdd.getNombre().getValue()+" Añadido");

            JAXBContext context = JAXBContext.newInstance(Pokedex.class);
            Unmarshaller UMS = context.createUnmarshaller();
            Pokedex RST = (Pokedex) UMS.unmarshal(ficheroXmlPokemons);
            RST.getPokemon().add(pokemonToAdd);

            saveNewPokemonOnXml(RST);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
    public static void saveNewPokemonOnXml(Pokedex RST) //MARSHALLER para guardar los updates en el XML
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Pokedex.class);
            Marshaller MS = context.createMarshaller();
            MS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            MS.marshal(RST, ficheroXmlPokemons);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
