package UF4AAD.DAO;
import net.xqj.exist.ExistXQDataSource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import javax.xml.xquery.*;
import java.io.File;
public class DAO1
{
    private static final String driver = "org.exist.xmldb.DatabaseImpl";
    private String URI;
    private String IP;
    private String PORT;
    /**
     *
     * @param IP
     * @param PORT
     */
    public DAO1(String IP, String PORT)
    {
        this.IP = IP;
        this.PORT = PORT;
        URI =  "xmldb:exist://"+IP+":"+ PORT +"/exist/xmlrpc/db";
    }
    /**
     *
     * @param adminUsername
     * @param adminPassword
     * @param collectionName
     * CONEXIÓN CON LA BBDD
     * CREA UNA COLLECCIÓN NUEVA CON EL NOMBRE DADO
     * AÑADE UN RECURSO NUEVO
     * @throws XMLDBException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void createCollection(String adminUsername, String adminPassword, String collectionName) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        registerDatabase();
        Collection parent = DatabaseManager.getCollection(URI, adminUsername, adminPassword);
        CollectionManagementService c = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");
        c.createCollection(collectionName);
    }
    /**
     *
     * @param adminUsername
     * @param adminPassword
     * @param filePath
     * CONEXIÓN CON LA BBDD
     * INSTACIA UNA COLLECCIÓN A LA QUE SE AÑADIRA EL RECURSO
     * AÑADE UN RECURSO NUEVO
     * @throws XMLDBException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void createResource(String yourCollection, String adminUsername, String adminPassword, String filePath) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException
    {
        registerDatabase();
        Collection collection = DatabaseManager.getCollection(URI+yourCollection, adminUsername, adminPassword);
        File file = new File(filePath);
        Resource resource = collection.createResource(filePath, "XMLResource");
        resource.setContent(file);
        collection.storeResource(resource);
    }
    /**
     *
     * @param query String con la query
     * CONEXIÓN CON LA BBDD
     * QUERY A LA BBDD
     * ORDENA LAS LINEAS DEL RESULTADO DE LA QUERY
     * @return String de resultados
     * @throws XQException
     */
    public String query(String query) throws XQException
    {
        XQDataSource source = new ExistXQDataSource();
        source.setProperty("serverName", IP);
        source.setProperty("port", PORT);
        XQConnection connection = source.getConnection();
        XQPreparedExpression expression = connection.prepareExpression(query);
        XQResultSequence result = expression.executeQuery();
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

    /**
     * REGISTRA LA BASE DE DATOS EN EL DATABASEMANAGER
     * @throws ClassNotFoundException
     * @throws XMLDBException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void registerDatabase() throws ClassNotFoundException, XMLDBException, IllegalAccessException, InstantiationException
    {
        Class clas = Class.forName(driver);
        Database database = (Database) clas.newInstance();
        database.setProperty("create-database", "true");
        DatabaseManager.registerDatabase(database);
    }
}
