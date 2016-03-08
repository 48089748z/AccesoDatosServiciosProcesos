package UF1AAD.CarrersBarcelonaJAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by 48089748z on 27/10/15.
 */
public class ControladorStreetsJAXB
{

    private static String rutaStreetsBarcelonaSmall = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.CarrersBarcelonaJAXB/StreetsBarcelonaSmall.xml";
    private static String rutaStreetsBarcelona = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.CarrersBarcelonaJAXB/StreetsBarcelona.xml";
    private static File ficheroStreetsBarcelonaSmall = new File(rutaStreetsBarcelonaSmall);

    public static void main(String[] args)
    {
        showStreets();
        addStreets();
    }

    public static void saveNewStreetsOnXml(ROWSETType RST)
    {
        try
        {

            JAXBContext context = JAXBContext.newInstance(ROWSETType.class);
            Marshaller MS = context.createMarshaller();
            MS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            MS.marshal(RST, ficheroStreetsBarcelonaSmall);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }


    }
    public static void addStreets()
    {
        try
        {
            ROWType street1 = new ROWType();
            street1.setNOMOFICIAL("Calle inventada");
            street1.setNOMCURT("ceia");
            street1.setCODICARRER("5489234890234");

            JAXBContext context = JAXBContext.newInstance(ROWSETType.class);
            Unmarshaller UMS = context.createUnmarshaller();
            ROWSETType RST = (ROWSETType) UMS.unmarshal(ficheroStreetsBarcelonaSmall);
            RST.getROW().add(street1);
            System.out.println("\nNº of Streets: " + RST.getROW().size());

            saveNewStreetsOnXml(RST);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }

    }

    public static void showStreets()
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(ROWSETType.class);
            Unmarshaller UMS = context.createUnmarshaller();
            ROWSETType RST = (ROWSETType) UMS.unmarshal(ficheroStreetsBarcelonaSmall);

            System.out.println("\nNº of Streets: " + RST.getROW().size());
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
