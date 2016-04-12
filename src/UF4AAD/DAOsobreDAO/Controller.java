package UF4AAD.DAOsobreDAO;

import UF4AAD.DAO.DAO;
import org.xmldb.api.base.XMLDBException;

import javax.xml.xquery.XQException;

/**
 * Created by 48089748z on 31/03/16.
 */
public class Controller
{
    private static final String DRIVER = "org.exist.xmldb.DatabaseImpl";
    private static final String IP = "172.31.101.225";
    private static final String PORT = "8080";
    private static String adminUsername = "admin";
    private static String adminPassword = "dionis";
    private static String myCollection = "uriDAOsobreDAO";
    private static String XPathQuery = "/mondial/country/name";
    private static String URI =  "xmldb:exist://"+IP+":"+ PORT +"/exist/xmlrpc";

    private static String empleados = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobreDAO/Empleados.xml";
    private static String clientes ="/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobreDAO/Clientes.xml";
    private static String catalogo = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobreDAO/Catalogo.xml";
    private static String facturas = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobreDAO/Facturas.xml";

    public static void main(String[] args) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException
    {
        DAOOscar daoOscar = new DAOOscar(IP, PORT, adminUsername, adminPassword, URI, DRIVER);

        //CLASE PARA CREAR COLLECCION
        daoOscar.anadorColeccion(myCollection);

        //AÑADIMOS LOS RECURSOS
        daoOscar.anadirColecionArchivo(empleados, myCollection);
        daoOscar.anadirColecionArchivo(clientes, myCollection);
        daoOscar.anadirColecionArchivo(catalogo, myCollection);
        daoOscar.anadirColecionArchivo(facturas, myCollection);



        //CLASE PARA CONSULTA XPATH
        System.out.println("\nCONSULTA XPATH");


        //CLASE PARA CONSULTA XQUERY
        System.out.println("\nCONSULTA XQUERY");

    }
}
