package UF1AAD.CarrersBarcelonaSAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by 48089748z on 29/10/15.
 */
public class SaxHandlerStreets extends DefaultHandler
{
    private int contadorCarrers;
    boolean esCalle = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        if (qName.equalsIgnoreCase("nom_oficial"))
        {
            contadorCarrers++;
            esCalle = true;
            System.out.println(contadorCarrers);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        if (esCalle)
        {
            System.out.println(new String(ch, start, length));
            esCalle = false;
        }
    }
}
