package UF1AAD.ExamenUF1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by 48089748z on 05/11/15.
 */
public class Exercici3
{
    //OPCIO 1  --->   He fet el llistat recurrent al Exercici 1 per que trobi directoris dins de directoris i mostri el nom de tots els directoris i la data de ultima modificació de tots els archius.
    //OPCIO 2  --->   Estendré la frase del exercici 2
    //OPCIO 3  --->   Trobaré el planeta amb més satelits

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
            int maxSatelits=0;
            int indexPlanetaAmbMesSatelits=0;
            JAXBContext context = JAXBContext.newInstance(SOLARSYSTEMType.class);
            Unmarshaller UMS = context.createUnmarshaller();
            SOLARSYSTEMType RST = (SOLARSYSTEMType) UMS.unmarshal(fileXmlplanets);
            for (int x=0; x<RST.getPLANETS().getPLANET().size(); x++)
            {
                String satelits = "0";
                if (RST.getPLANETS().getPLANET().get(x).getSATELLITES() != null)
                {
                    if (Integer.parseInt(RST.getPLANETS().getPLANET().get(x).getSATELLITES())>maxSatelits)
                    {
                        maxSatelits = Integer.parseInt(RST.getPLANETS().getPLANET().get(x).getSATELLITES());
                        indexPlanetaAmbMesSatelits = x;
                    }
                    satelits = RST.getPLANETS().getPLANET().get(x).getSATELLITES();
                }
                System.out.println("Parlarem amb el planeta que te codi de color <<"+RST.getPLANETS().getPLANET().get(x).getCOLOR()+">>. El planeta <<"+RST.getPLANETS().getPLANET().get(x).getNAME()+">> té una massa de <<"+RST.getPLANETS().getPLANET().get(x).getMASS()+">> cops la massa de la terra i té <<"+satelits+">> llunes");
            }
            System.out.println("\n El planeta amb més Satelits es "+RST.getPLANETS().getPLANET().get(indexPlanetaAmbMesSatelits).getNAME()+" i té "+RST.getPLANETS().getPLANET().get(indexPlanetaAmbMesSatelits).getSATELLITES()+" satelits");
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}