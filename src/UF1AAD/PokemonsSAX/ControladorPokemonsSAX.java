package UF1AAD.PokemonsSAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.Scanner;

/**
 * Created by 48089748z on 13/10/15.
 */
public class ControladorPokemonsSAX
{
    private static String rutaXmlPokemons = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.PokemonsJAXB/pokemons.xml"; //Ruta del Fichero xml en mi pc
    private static File ficheroXmlPokemons = new File(rutaXmlPokemons); //Creamos un File con la ruta anterior
    private static boolean stop=false; //Boolean para el bucle del Menu
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) //Main method
    {
        while (stop==false)
        {
            System.out.println("\n----------------------------\n0: Finalizar Programa\n1: Mostrar Pokemons con SAX\n----------------------------");
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
                default:
                {
                    System.out.println("Esa opción no existe");
                }
            }
        }
    }
    public static void showPokemons() //Muestra los pokemons con un SAXParser
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try
        {
            InputStream xmlInput = new FileInputStream(rutaXmlPokemons);
            SAXParser saxParser = factory.newSAXParser();
            SaxHandlerPokemons handler = new SaxHandlerPokemons();
            saxParser.parse(xmlInput, handler);
        }
        catch(IOException one) {}
        catch (ParserConfigurationException two) {}
        catch(SAXException three) {}
    }
}
