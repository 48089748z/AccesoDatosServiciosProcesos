package UF3AAD.Practicas;
import net.xqj.exist.ExistXQDataSource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import javax.xml.xquery.*;
import java.io.File;
public class ExistsDBController
{
    private static final String adminUsername = "admin";
    private static final String adminPassword = "dionis";
    private static final String filePath = "/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3AAD/plantes.xml";
    private static final String mainCollection ="/db";
    private static final String myCollection ="/uriCollection";
    private static final String PORT = "8080";
    private static final String IP = "172.31.101.225";
    private static final String URI = "xmldb:exist://"+IP+":"+ PORT +"/exist/xmlrpc";
    private static final String driver = "org.exist.xmldb.DatabaseImpl";
    public static void main(String args[])
    {
        try
        {
            //CREAR UNA COLECCIÓN (CARPETA)
            createCollection();
            System.out.println("COLLECTION CREATED SUCCESSFULLY");

            //AÑADIR RECURSO A LA COLECCIÓN (ARCHIVO XML U OTRO)
            addResourceToCollection();
            System.out.println("RESOURCE ADDED SUCCESSFULLY");

            //QUERY SOBRE LOS ARCHIVOS DE NUESTRA COLECCIÓN (PARA ORDENARLOS PODEMOS METERLOS EN UN ARRAY CON UN SPLIT)
            String[] results = queryResource("collection('oriolDB')/CATALOG/PLANT/COMMON/").replaceAll("</COMMON>","").split("<COMMON>");
            for (String result: results) {System.out.print(result);}
        }
        catch (XMLDBException e)          {System.out.println("XMLDBException:         " + e);}
        catch (ClassNotFoundException e)  {System.out.println("ClassNotFoundException: " + e);}
        catch (IllegalAccessException e)  {System.out.println("IllegalAccessException: " + e);}
        catch (InstantiationException e)  {System.out.println("InstantiationException: " + e);}
        catch (XQException e)             {System.out.println("XQException:            " + e);}
    }

    private static void createCollection() throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        //CONEXIÓN
        Class clas = Class.forName(driver);
        Database database = (Database) clas.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        //CREAR COLECCIÓN NUEVA
        Collection parent = DatabaseManager.getCollection(URI+mainCollection, adminUsername, adminPassword);
        CollectionManagementService c = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");
        c.createCollection("uriCollection");
    }

    private static void addResourceToCollection() throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        //CONEXIÓN
        Class clas = Class.forName(driver);
        Database database = (Database) clas.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        //INSTANCIAR COLECCIÓN A LA QUE AÑADIREMOS EL RECURSO
        Collection collection = DatabaseManager.getCollection(URI+mainCollection+myCollection, adminUsername, adminPassword);

        //AÑADIR EL RECURSO
        File file = new File(filePath);
        Resource resource = collection.createResource(filePath, "XMLResource");
        resource.setContent(file);
        collection.storeResource(resource);
    }

    private static String queryResource(String query) throws XQException
    {
        //CONEXIÓN
        XQDataSource source = new ExistXQDataSource();
        source.setProperty("serverName", IP);
        source.setProperty("port", PORT);
        XQConnection connection = source.getConnection();

        //QUERY
        XQPreparedExpression expression = connection.prepareExpression(query);
        XQResultSequence result = expression.executeQuery();

        //ORDENAR LAS LINEAS DEL RESULTADO DE LA QUERY
        String resultado="";
        String linea;
        while (result.next())
        {
            linea = result.getItemAsString(null);
            resultado = resultado+"\n"+linea;
        }
        connection.close();
        return resultado;
    }
}
