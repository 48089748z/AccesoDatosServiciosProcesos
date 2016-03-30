package UF4AAD;
import org.xmldb.api.base.XMLDBException;
import javax.xml.xquery.XQException;
/**
 * Created by 48089748z on 29/03/16.
 */
public class Controller
{
    private static final ExistsDAO existsDAO = new ExistsDAO();

    //AMB AQUEST ExistsDAO NOMES CAL CAMBIAR LES PREFERENCIES PER QUE FUNCIONI AMB QUALSEVOL ALTRE USUARI I COLECCIÓ
    private static final String IP = "172.31.101.225";
    private static final String PORT = "8080";
    private static final String URI = "xmldb:exist://"+IP+":"+ PORT +"/exist/xmlrpc";

    private static String adminUsername = "admin";
    private static String adminPassword = "dionis";

    private static String mainCollection ="/db";
    private static String yourCollection = "uriDAO";

    private static String filePath = "/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3AAD/ExamenUF3/mondial.xml";
    private static String XPathQuery = "/mondial/country/name";

    //EL CODI DEL MAIN NO CAL TOCARLO I EL DEL ExistsDAO TAMPOC
    public static void main(String[] args)
    {
        try
        {
            //CLASE PARA CREAR COLLECCION
            existsDAO.createCollection(URI+mainCollection, adminUsername, adminPassword, yourCollection);

            //CLASE PARA CREAR RECURSO
            existsDAO.createResource(URI+mainCollection+"/"+yourCollection, adminUsername, adminPassword, filePath);

            //CLASE PARA CONSULTA XPATH
            System.out.println("\nCONSULTA XPATH");
            System.out.println(existsDAO.query("collection('"+yourCollection+"')"+XPathQuery, PORT, IP));

            //CLASE PARA CONSULTA XQUERY
            System.out.println("\nCONSULTA XQUERY");
            System.out.println(existsDAO.query("for $p in fn:doc(\"uriDAO/mondial.xml\")//country[population=max(//mondial/country/population)] return $p/name ", PORT, IP));
        }
        catch (XMLDBException e)          {System.out.println("XMLDBException:         " + e);}
        catch (ClassNotFoundException e)  {System.out.println("ClassNotFoundException: " + e);}
        catch (IllegalAccessException e)  {System.out.println("IllegalAccessException: " + e);}
        catch (InstantiationException e)  {System.out.println("InstantiationException: " + e);}
        catch (XQException e)             {System.out.println("XQException:            " + e);}
    }
}
