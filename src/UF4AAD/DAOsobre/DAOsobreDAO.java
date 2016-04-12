package UF4AAD.DAOsobre;
import org.xmldb.api.base.XMLDBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.xquery.XQException;
import java.io.File;
/**
 * Created by 48089748z on 12/04/16.
 */
public class DAOsobreDAO {
    private static DAOOscar dao1;
    private static final String DRIVER = "org.exist.xmldb.DatabaseImpl";
    private static final String IP = "172.31.101.225";
    private static final String PORT = "8080";
    private static String adminUsername = "admin";
    private static String adminPassword = "dionis";
    private static String myCollection = "uriDAOsobreDAO";
    private static String URI = "xmldb:exist://" + IP + ":" + PORT + "/exist/xmlrpc";
    private static String databasePath = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobre/database.xml";
    private static File databaseFile = new File(databasePath);

    public DAOsobreDAO() {
    }

    public static void openDatabase() throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException {
        dao1 = new DAOOscar(IP, PORT, adminUsername, adminPassword, URI, DRIVER);
        dao1.anadorColeccion(myCollection);
        dao1.anadirColecionArchivo(databasePath, myCollection);
    }

    public void añadirEmpleado(String id, String nombre, String apellido, String sueldo, String años_trabajados) {
    }

    public void borrarCliente(String nif_cliente)
    {

    }

    public void borrarEmpleado(String id_empleado) {
    }

    public void todasLasFacturasDelCliente(String nif_cliente) {
    }


    public void añadirCliente()
    {

    }
    public void showAll() throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(DatabaseType.class);
        Unmarshaller UMS = context.createUnmarshaller();
        DatabaseType RST = (DatabaseType) UMS.unmarshal(databaseFile);
        System.out.println("\n\n\nCLIENTS");
        for (int x=0; x<RST.getClients().getClient().size(); x++)
        {
            System.out.println("   \nNIF: "+RST.getClients().getClient().get(x).getNif()+
                    "   \nNAME: "+RST.getClients().getClient().get(x).getName()+
                    "   \nSURNAME: "+RST.getClients().getClient().get(x).getSurname());
        }

        System.out.println("\n\n\nEMPLOYEES");
        for (int x=0; x<RST.getEmployees().getEmployee().size(); x++)
        {
            System.out.println("   \nID: "+RST.getEmployees().getEmployee().get(x).getId()+
                    "   \nNAME: "+RST.getEmployees().getEmployee().get(x).getName()+
                    "   \nSURNAME: "+RST.getEmployees().getEmployee().get(x).getSurname()+
                    "   \nSALARY: "+RST.getEmployees().getEmployee().get(x).getSalary()+
                    "   \nID: "+RST.getEmployees().getEmployee().get(x).getId());
        }

    }

}

