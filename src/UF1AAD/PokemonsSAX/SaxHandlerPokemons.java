package UF1AAD.PokemonsSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by 48089748z on 29/10/15.
 */
public class SaxHandlerPokemons extends DefaultHandler
{
    private int contadorPokemons;
    boolean esPokemon = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (qName.equalsIgnoreCase("nombre"))
        {
            contadorPokemons++;
            esPokemon = true;
            System.out.println(contadorPokemons);
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        if (esPokemon)
        {
            System.out.println(new String(ch, start, length));
            esPokemon = false;
        }
    }
}
