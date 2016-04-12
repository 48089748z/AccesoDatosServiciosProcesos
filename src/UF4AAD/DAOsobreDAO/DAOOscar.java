package UF4AAD.DAOsobreDAO;
import net.xqj.exist.ExistXQDataSource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import javax.xml.xquery.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
/**
 * Created by oscarXIII on 07/04/2016.
 */
public class DAOOscar
{
    private static String IP;
    private static String puerto;
    private static String usuario;
    private static String contra;
    private static String URI;
    private static String driver;
    /************************ GETTERS & SETTERS ************************/
    /**
     * Constructor sin parametros
     */
    public DAOOscar()
    {
        IP="";
        puerto ="";
        usuario="";
        contra="";
        URI = "";
        driver = "";
    }
    /**
     * Constructor con parametros:
     * @param IP - IP del servidor
     * @param puerto - puerto servicio
     * @param usuario - usuario para la conexion
     * @param contra - contraseña del usuario
     * @param URI - url existdb.
     * @param driver - driver de conexion
     *
     */
    public DAOOscar(String IP, String puerto, String usuario, String contra, String URI, String driver){
        this.IP=IP;
        this.puerto= puerto;
        this.usuario=usuario;
        this.contra=contra;
        this.URI = URI;
        this.driver = driver;
    }

    /**
     * getIP Obtener la IP
     * @return  Ip de la maquina (String)
     */
    public static String getIP() {
        return IP;
    }
    /**
     * setIP Fijar IP maquina
     * @param IP - Ip de la maquina
     */
    public static void setIP(String IP) {
        DAOOscar.IP = IP;
    }

    /**
     * getPuerto Obterner el puerto
     * @return puerto del servicio
     */
    public static String getPuerto() {
        return puerto;
    }
    /**
     * SetPuerto Fijar el puerto del servicio
     * @param puerto - puerto del servicio
     */
    public static void setPuerto(String puerto) {
        DAOOscar.puerto = puerto;
    }

    /**
     * getUsuario Obtener usuario
     * @return Usuario (String)
     */
    public static String getUsuario() {
        return usuario;
    }
    /**
     * setUsuario Fijar usuario
     * @param usuario - usuario
     */
    public static void setUsuario(String usuario) {
        DAOOscar.usuario = usuario;
    }

    /**
     * getContra Obtener contraseña
     * @return  Contraseña
     */
    public static String getContra() {
        return contra;
    }
    /**
     * setContra Fijar la cosntraseña
     * @param contra - constraseña del usuario
     */
    public static void setContra(String contra) {
        DAOOscar.contra = contra;
    }

    /**
     * getURI Obtener URL existdb
     * @return  URL existdb
     */
    public static String getURI() {
        return URI;
    }
    /**
     * setURI Fijar url existdb
     * @param URI - uri existdb
     */
    public static void setURI(String URI) {
        DAOOscar.URI = URI;
    }

    /**
     * getDriver Obtener driver
     * @return  driver (String)
     */
    public static String getDriver() {
        return driver;
    }
    /**
     * setDriver Fijar driver
     * @param driver - driver
     */
    public static void setDriver(String driver) {
        DAOOscar.driver = driver;
    }

    /************************ METODOS ************************/

    /**
     * Metodo para iniciar el Driver de la BBDD
     * @return database con el driver iniciado
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws XMLDBException
     */
    public static Database iniciarDriver() throws ClassNotFoundException, IllegalAccessException, InstantiationException, XMLDBException {
        Class cl = Class.forName(driver);
        Database database = (Database) cl.newInstance();
        database.setProperty("create-database", "true");
        return database;
    }

    /**
     * Metodo para añadir una colecicion junto con un fichero
     * @param ruta - Ruta del archivo a subir
     * @param coleccion - Nombre de la coleccion, se puede poner NULL para subirlo a la raiz.
     * @throws XMLDBException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws XQException
     */
    public static void anadirColecionArchivo(String ruta, String coleccion) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException {
        //Archivo a utilizar
        File f = new File(ruta);

        //manejador creado
        DatabaseManager.registerDatabase(iniciarDriver());
        Collection col;
        String logs = "";
        if (!(coleccion == null)){
            col = DatabaseManager.getCollection(URI + "/db/" + coleccion, usuario, contra);
            //Escribimod el resultado en el LOG
            logs = "Añadido el archivo: "+ruta+" a la colecion: "+coleccion;
        }else{
            col = DatabaseManager.getCollection(URI + "/db", usuario, contra);
            //Escribimod el resultado en el LOG
            logs = "Añadido el archivo: "+ruta+" a la raiz";
        }

        //Añadir el recurso a utilizar
        Resource res = col.createResource(ruta,"XMLResource");
        res.setContent(f);
        col.storeResource(res);

        //Escribimod el resultado en el LOG
        log(logs);
    }

    /**
     * Metodo para eliminar recursos.
     * @param coleccion - Nom de la coleccio de la que pertany el recurs
     * @param recurso - Nom del recurs que volem eliminar
     * @throws XMLDBException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public void eliminarColeccionArchivo(String coleccion, String recurso) throws XMLDBException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Collection col = DatabaseManager.getCollection(URI+coleccion,usuario,contra);
        Resource resource = col.getResource(recurso);
        col.removeResource(resource);
        log("eliminado el archivo: "+recurso+" de la coleccion: "+coleccion);
    }

    /**
     * Metodo para añadir una coleccion
     * @param coleccion - Nombre de la coleccion a añadir
     * @throws XMLDBException
     */
    public static void anadorColeccion(String coleccion) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //manejador creado
        DatabaseManager.registerDatabase(iniciarDriver());

        //crear la coleccion
        Collection parent = DatabaseManager.getCollection(URI+"/db",usuario,contra);
        CollectionManagementService c = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");
        c.createCollection(coleccion);
        log("coleccion : "+coleccion+" creada");
    }

    /**
     * Metodo para eliminar coleccion
     * @param coleccion - Nombre de la coleccion a eliminar.
     * @throws XMLDBException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void  eliminarColeccion(String coleccion) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //manejador creado
        DatabaseManager.registerDatabase(iniciarDriver());

        //eliminar la coleccion
        Collection parent = DatabaseManager.getCollection(URI+"/db",usuario,contra);
        CollectionManagementService c = (CollectionManagementService) parent.getService("CollectionManagementService", "1.0");
        c.removeCollection(coleccion);
        log("coleccion : "+coleccion+" eliminada");
    }

    /**
     * Metodo para hacer consultas con Strings
     * @param xQuery - Consulta en string
     * @return resultado - Devuelve el resutlado de la consulta
     * @throws XQException
     */
    public static String consulta (String xQuery) throws XQException {
        String resultado = "";
        String linea = "";
        XQDataSource xqs = new ExistXQDataSource();
        xqs.setProperty("IP", IP);
        xqs.setProperty("puerto", puerto);

        XQConnection conn = xqs.getConnection();

        XQPreparedExpression xqpe = conn.prepareExpression(xQuery);
        XQResultSequence rs = xqpe.executeQuery();

        while (rs.next()){
            linea = rs.getItemAsString(null);
            resultado += linea;
        }
        conn.close();
        log("consulta hecha: "+xQuery);
        return resultado;
    }

    /**
     * Metodo para escribir el LOG
     * @param mensaje - Mensaje que se guarda en el LOG
     * @return String Log
     */
    public static String log(String mensaje){
        Date fecha = new Date();
        String log = fecha.toString()+" "+mensaje;
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("log.txt", true));
            out.write(log+"\n");
        } catch (IOException e) {
            System.out.println("ERROR AL ESCRIBIR EL LOG");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("ERROR AL CERRAR EL LOG");
                }
            }
        }
        return log;
    }
}
