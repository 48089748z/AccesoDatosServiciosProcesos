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
    private static String empleados = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobre/Empleados.xml";
    private static String clientes = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobre/Clientes.xml";
    private static String catalogo = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobre/Catalogo.xml";
    private static String facturas = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobre/Facturas.xml";

    public DAOsobreDAO() {
    }

    public static void openDatabase() throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException {
        dao1 = new DAOOscar(IP, PORT, adminUsername, adminPassword, URI, DRIVER);
        dao1.anadorColeccion(myCollection);
        dao1.anadirColecionArchivo(empleados, myCollection);
        dao1.anadirColecionArchivo(clientes, myCollection);
        dao1.anadirColecionArchivo(catalogo, myCollection);
        dao1.anadirColecionArchivo(facturas, myCollection);
    }

    public void añadirEmpleado(String id, String nombre, String apellido, String sueldo, String años_trabajados) {
    }

    public void borrarCliente(String nif_cliente) {
    }

    public void borrarEmpleado(String id_empleado) {
    }

    public void todasLasFacturasDelCliente(String nif_cliente) {
    }


    public void añadirCliente()
    {
        try
        {
            Scanner in = new Scanner(System.in);
            File fileClientes = new File(clientes);
            System.out.println("Escribe el NIF del Cliente");
            String nif = in.nextLine();

            System.out.println("Escribe el NOMBRE del Cliente");
            String name = in.nextLine();

            System.out.println("Escribe el APELLIDO del Cliente");
            String surname = in.nextLine();

            Cliente clientToAdd = new Cliente(nif, name, surname);
            JAXBContext context = JAXBContext.newInstance(Pokedex.class);
            Unmarshaller UMS = context.createUnmarshaller();
            Clientes RST = (Clientes) UMS.unmarshal(fileClientes);
            RST.getClientes().add(clientToAdd);

            Marshaller MS = context.createMarshaller();
            MS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            MS.marshal(RST, fileClientes);
        }
        catch (JAXBException e) {e.printStackTrace();}
    }

}

