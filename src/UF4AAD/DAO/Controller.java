package UF4AAD.DAO;
import org.xmldb.api.base.XMLDBException;
import javax.xml.xquery.XQException;
/**
 * Created by 48089748z on 29/03/16.
 */
public class Controller
{
    private static final String IP = "172.31.101.225";
    private static final String PORT = "8080";
    private static String adminUsername = "admin";
    private static String adminPassword = "dionis";
    private static String yourCollection = "uriDAO";

    private static String filePath = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/mondial.xml";
    private static String XPathQuery = "/mondial/country/name";

    //EL CODI DEL MAIN NO CAL TOCARLO I EL DEL DAO1 TAMPOC
    public static void main(String[] args)
    {
        DAO1 dao1 = new DAO1(IP, PORT);
        try
        {
            //CLASE PARA CREAR COLLECCION
            dao1.createCollection(adminUsername, adminPassword, yourCollection);

            //CLASE PARA CREAR RECURSO
            dao1.createResource("/"+yourCollection, adminUsername, adminPassword, filePath);


            //CLASE PARA CONSULTA XPATH
            System.out.println("\nCONSULTA XPATH");
            System.out.println(dao1.query("collection('"+yourCollection+"')"+XPathQuery));

            //CLASE PARA CONSULTA XQUERY
            System.out.println("\nCONSULTA XQUERY");
            System.out.println(dao1.query("for $p in fn:doc(\"uriDAO/mondial.xml\")/mondial/country/name return $p/name"));
        }
        catch (XQException e)            {System.out.println("XQException:            " + e);}
        catch (XMLDBException e)         {System.out.println("XMLDBException:         " + e);}
        catch (ClassNotFoundException e) {System.out.println("ClassNotFoundException: " + e);}
        catch (IllegalAccessException e) {System.out.println("IllegalAccessException: " + e);}
        catch (InstantiationException e) {System.out.println("InstantiationException: " + e);}
    }
}
