package UF1AAD.CarrersBarcelonaDOM;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


/**
 * Created by 48089748z on 27/10/15.
 */
public class ControladorStreetsDOM
{
    private static String rutaStreetsBarcelonaSmall = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.CarrersBarcelonaDOM/StreetsBarcelonaSmall.xml";
    private static String rutaStreetsBarcelona = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.CarrersBarcelonaDOM/StreetsBarcelona.xml";
    private static File ficheroStreetsBarcelona = new File(rutaStreetsBarcelona);
    private static File ficheroStreetsBarcelonaSmall = new File(rutaStreetsBarcelonaSmall);
    private static Document doc;

    public static void main(String[] args)
    {
        showStreets();
        addStreets();
    }
    public static void showStreets()
    {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //Hacemos els documentBuilders
        try
        {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(ficheroStreetsBarcelona);
        }
        catch (SAXException one){}
        catch (IOException two) {}
        catch (ParserConfigurationException three) {}
        doc.getDocumentElement().normalize();    //Normalitzamos el archivo

        NodeList streetsList = doc.getElementsByTagName("ROW");


        System.out.println("\nA Barcelona hi han "+streetsList.getLength()+" carrers.");
        System.out.println("\nNom dels carrers\n------------------");
        for (int x=0; x<streetsList.getLength(); x++)
        {
            Element street = (Element) streetsList.item(x);    //(org.w3c.dom) ELEMENT
            System.out.println(street.getElementsByTagName("NOM_OFICIAL").item(0).getTextContent());
            street.getElementsByTagName("NOM_OFICIAL").item(0).setTextContent("Street X");
        }
    }
    public static void addStreets()
    {
        try
        {
            System.out.println("\nHe cambiat el nom dels carrers i els torno a imprimir");
            File outputFile = ficheroStreetsBarcelonaSmall;
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult result = new StreamResult(outputFile);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);

            showStreets();
        }
        catch (TransformerException one){}
    }
}
