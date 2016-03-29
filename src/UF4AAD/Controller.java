package UF4AAD;
import org.xmldb.api.base.XMLDBException;
import javax.xml.xquery.XQException;
/**
 * Created by 48089748z on 29/03/16.
 */
public class Controller
{
    private static final DAO DAO = new DAO();

    //AMB AQUEST DAO NOMES CAL CAMBIAR LES PREFERENCIES PER QUE FUNCIONI AMB QUALSEVOL ALTRE USUARI I COLECCIÓ
    private static String adminUsername = "admin";
    private static String adminPassword = "dionis";
    private static String filePath = "/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3AAD/ExamenUF3/mondial.xml";
    private static String mainCollection ="/db";
    private static String yourCollection = "uriDAO";
    private static String IP = "172.31.101.225";
    private static final String PORT = "8080";
    private static final String URI = "xmldb:exist://"+IP+":"+ PORT +"/exist/xmlrpc";
    private static final String driver = "org.exist.xmldb.DatabaseImpl";

    //EL CODI DEL MAIN NO CAL TOCARLO I EL DEL DAO TAMPOC
    public static void main(String[] args)
    {
     /* IP = "172.31.83.34";
        adminUsername="admin";
        adminPassword="admin";  */
        try
        {
            //EJEMPLO DE CREAR COLLECCION
            DAO.createCollection(driver, URI+mainCollection, adminUsername, adminPassword, yourCollection);

            //EJEMPLO DE CREAR RECURSO
            DAO.createResource(driver, URI+mainCollection+"/"+yourCollection, adminUsername, adminPassword, filePath);

            //EJEMPLO DE CONSULTA XPATH
            System.out.println("\nCONSULTA XPATH");
            System.out.println(DAO.query("collection('"+yourCollection+"')/mondial/country/name", PORT, IP));

            //EJEMPLO DE CONSULTA XQUERY
            System.out.println("\nCONSULTA XQUERY");
            System.out.println(DAO.query("for $p in fn:doc(\"uriDAO/mondial.xml\")//country[population=max(//mondial/country/population)] return $p/name ", PORT, IP));

            //MODIFICAR RECURSO
            DAO.deleteResource();

        }
        catch (XMLDBException e)          {System.out.println("XMLDBException:         " + e);}
        catch (ClassNotFoundException e)  {System.out.println("ClassNotFoundException: " + e);}
        catch (IllegalAccessException e)  {System.out.println("IllegalAccessException: " + e);}
        catch (InstantiationException e)  {System.out.println("InstantiationException: " + e);}
        catch (XQException e)             {System.out.println("XQException:            " + e);}
    }
}
