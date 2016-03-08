package UF1AAD.ExamenUF1;

import javax.xml.bind.*;
import java.io.*;

/**
 * Created by 48089748z on 05/11/15.
 */
public class Exercici2
{
    private static String rutaXmlPlanets = "/home/48089748z/IdeaProjects/DadesIServeis/src/UF1AAD.ExamenUF1/planets.xml";
    private static File fileXmlplanets = new File(rutaXmlPlanets);
    public static void main(String[] args)
    {
        start();
    }
    public static void start()
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(SOLARSYSTEMType.class);
            Unmarshaller UMS = context.createUnmarshaller();
            SOLARSYSTEMType RST = (SOLARSYSTEMType) UMS.unmarshal(fileXmlplanets);
            for (int x=0; x<RST.getPLANETS().getPLANET().size(); x++)
            {
                String satelits = "0";
                if (RST.getPLANETS().getPLANET().get(x).getSATELLITES() != null)
                {
                    satelits = RST.getPLANETS().getPLANET().get(x).getSATELLITES();
                }
                System.out.println("El planeta <<"+RST.getPLANETS().getPLANET().get(x).getNAME()+">> té una massa de <<"+RST.getPLANETS().getPLANET().get(x).getMASS()+">> cops la massa de la terra i té <<"+satelits+">> llunes");
            }
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
