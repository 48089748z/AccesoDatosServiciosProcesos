package UF4AAD.DAOsobre;
import UF1AAD.PokemonsJAXB.Nombre;
import UF1AAD.PokemonsJAXB.Pokedex;
import UF1AAD.PokemonsJAXB.Pokemon;
import org.xmldb.api.base.XMLDBException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.xquery.XQException;
import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

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
    public void showAll()
    {
        try
        {
            JAXBContext context = JAXBContext.newInstance(Database.class);
            Unmarshaller UMS = context.createUnmarshaller();
            Database RST = (Database) UMS.unmarshal(databaseFile);

            for (int x=0; x<RST.getClientes().size(); x++)
            {
                System.out.println(RST.getClientes().get(x).getNombre());
            }
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

}

