package UF4AAD;
import net.xqj.exist.ExistXQDataSource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import javax.xml.xquery.*;
import java.io.File;
public class ExistsDAO
{
    private static final String driver = "org.exist.xmldb.DatabaseImpl";
    public void createCollection(String URI, String adminUsername, String adminPassword, String collectionName) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        //CONEXIÓN
        Class clas = Class.forName(driver);
        Database database = (Database) clas.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        //CREAR COLECCIÓN NUEVA
        Collection parent = DatabaseManager.getCollection(URI, adminUsername, adminPassword);
        CollectionManagementService c = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");
        c.createCollection(collectionName);
    }
    public void createResource(String URI, String adminUsername, String adminPassword, String filePath) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        //CONEXIÓN
        Class clas = Class.forName(driver);
        Database database = (Database) clas.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);

        //INSTANCIAR COLECCIÓN A LA QUE AÑADIREMOS EL RECURSO
        Collection collection = DatabaseManager.getCollection(URI, adminUsername, adminPassword);

        //AÑADIR EL RECURSO
        File file = new File(filePath);
        Resource resource = collection.createResource(filePath, "XMLResource");
        resource.setContent(file);
        collection.storeResource(resource);
    }
    public String query(String query, String PORT, String IP) throws XQException
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
        String resultados="";
        String linea;
        while (result.next())
        {
            linea = result.getItemAsString(null);
            resultados = resultados+"\n"+linea;
        }
        connection.close();
        return resultados;
    }
}
