package UF1AAD.WeatherDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
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
 * Created by 48089748z on 03/11/15.
 */
public class ControladorWeatherDOM
{
    private static String rutaForecast = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.WeatherDOM/forecast.xml";
    private static String rutaNewFile = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.WeatherDOM/Newforecast.xml";
    private static File forecast = new File(rutaForecast);
    private static File newForecast = new File(rutaNewFile);
    private static Document doc;

    public static void main(String[] args)
    {
        showForecast();
        //QUAN UTILITZAR DOM SAX I JAXB

        //JAXB Quan necesitem crear objectes i no nomes agafar informació sinó també afegirne de nova, per a documents XML simples.
        //DOM Quan necesitem no nomes agafar informació sinó també afegirne de nova, pero sense crear objectes, per a documents XML mes extensos i complicats.
        //SAX Quan només necesitem agafar informació d'els documents XML.
    }
    public static void showForecast() //Mostrar resum de la informació
    {
        try
        {
            File inputFile = forecast;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList cityList = doc.getElementsByTagName("location");
            Element ciutat = (Element) cityList.item(0);

            System.out.println("\nForecast de la Ciutat de " +ciutat.getElementsByTagName("name").item(0).getTextContent());
            NodeList timeList = doc.getElementsByTagName("time");
            for (int x=0; x<timeList.getLength(); x++)
            {
                Element time = (Element) timeList.item(x);    //(org.w3c.dom) ELEMENT
                System.out.println("\n-----------------------------------------------------------------------------\n|  DATA:               " + time.getAttributes().getNamedItem("from").getNodeValue()+"  TO  "+time.getAttributes().getNamedItem("to").getNodeValue());
                System.out.println("|  GRAUS:              "+time.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("value").getNodeValue()+"º  "+time.getElementsByTagName("temperature").item(0).getAttributes().getNamedItem("unit").getNodeValue());
                System.out.println("|  ESTAT DEL TEMPS:    "+translateToSpanish(time.getElementsByTagName("clouds").item(0).getAttributes().getNamedItem("value").getNodeValue()));
                System.out.println("|  HUMITAT:            "+time.getElementsByTagName("humidity").item(0).getAttributes().getNamedItem("value").getNodeValue()+"%");
                double mps = Double.parseDouble(time.getElementsByTagName("windSpeed").item(0).getAttributes().getNamedItem("mps").getNodeValue().toString());
                double kph = mps*3.6;
                System.out.println("|  VELOCITAT VENT MPS:  "+mps);
                System.out.println("|  VELOCITAT VENT KMH:  "+kph);

                NodeList nodoWindSpeed = doc.getElementsByTagName("windSpeed");
                Element windSpeed = (Element) nodoWindSpeed.item(x);
                windSpeed.setAttribute("kph", String.valueOf(kph));
            }
            addKmHOnNewXml();
        }
        catch (ParserConfigurationException one){}
        catch (IOException two){}
        catch (SAXException three){}
    }
    public static void addKmHOnNewXml()
    {
        try
        {
            if (!newForecast.exists()) { newForecast.createNewFile(); }
            File outputFile = newForecast;
            Transformer trans = TransformerFactory.newInstance().newTransformer();
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult result = new StreamResult(outputFile);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            showForecast();
        }
        catch (TransformerException one){}
        catch (IOException two){}
    }
    public static String translateToSpanish (String englishText)
    {
        switch (englishText)
        {
            case "scattered clouds": return "Nubes locas";
            case "broken clouds": return "Nubes Rotas";
            case "light rain": return "Lluvia Ligera";
            case "overcast clouds": return "Cielo Encapotado";
            case "few clouds": return "Pocas Nubes";
            case "clear sky": return "Cielo Despejado";
            default: return "No puedo traducirlo";
        }
    }
}
