package UF4AAD.DAO;
import org.xmldb.api.base.XMLDBException;
import javax.xml.xquery.XQException;
/**
 * Created by 48089748z on 29/03/16.
 */
public class Controller
{
    private static final DAO1 dao1 = new DAO1();
    private static final String IP = "172.31.101.225";
    private static final String PORT = "8080";
    private static final String URI = "xmldb:exist://"+IP+":"+ PORT +"/exist/xmlrpc";

    private static String adminUsername = "admin";
    private static String adminPassword = "dionis";

    private static String mainCollection ="/db";
    private static String yourCollection = "uriDAO";

    private static String filePath = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/mondial.xml";
    private static String XPathQuery = "/mondial/country/name";

    //EL CODI DEL MAIN NO CAL TOCARLO I EL DEL DAO1 TAMPOC
    public static void main(String[] args)
    {
        try
        {
            //CLASE PARA CREAR COLLECCION
            dao1.createCollection(URI+mainCollection, adminUsername, adminPassword, yourCollection);

            //CLASE PARA CREAR RECURSO
            dao1.createResource(URI+mainCollection+"/"+yourCollection, adminUsername, adminPassword, filePath);

            //CLASE PARA CONSULTA XPATH
            System.out.println("\nCONSULTA XPATH");
            System.out.println(dao1.query("collection('"+yourCollection+"')"+XPathQuery, PORT, IP));

            //CLASE PARA CONSULTA XQUERY
            System.out.println("\nCONSULTA XQUERY");
            System.out.println(dao1.query("for $p in fn:doc(\"uriDAO/mondial.xml\")//country[population=max(//mondial/country/population)] return $p/name ", PORT, IP));
        }
        catch (XQException e)            {System.out.println("XQException:            " + e);}
        catch (XMLDBException e)         {System.out.println("XMLDBException:         " + e);}
        catch (ClassNotFoundException e) {System.out.println("ClassNotFoundException: " + e);}
        catch (IllegalAccessException e) {System.out.println("IllegalAccessException: " + e);}
        catch (InstantiationException e) {System.out.println("InstantiationException: " + e);}
    }
}
