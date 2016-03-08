package UF1AAD.CarrersBarcelonaSAX;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

/**
 * Created by 48089748z on 27/10/15.
 */
public class ControladorStreetsSAX
{

    private static String rutaStreetsBarcelonaSmall = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.CarrersBarcelonaSAX/StreetsBarcelonaSmall.xml";
    private static String rutaStreetsBarcelona = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.CarrersBarcelonaSAX/StreetsBarcelona.xml";
   // private static File ficheroStreetsBarcelonaSmall = new File(rutaStreetsBarcelonaSmall);

    public static void main(String[] args) throws FileNotFoundException
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        InputStream xmlInput = new FileInputStream(rutaStreetsBarcelona);
        try
        {
            SAXParser saxParser = factory.newSAXParser();
            SaxHandlerStreets handler = new SaxHandlerStreets();
            saxParser.parse(xmlInput, handler);
        }
        catch(IOException one) {}
        catch (ParserConfigurationException two) {}
        catch(SAXException three) {}
    }
}
