package UF4AAD.DAOsobre;
import org.xmldb.api.base.XMLDBException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.xquery.XQException;
import java.io.File;
import java.util.Scanner;
/**
 * Created by 48089748z on 12/04/16.
 *
 * LO DE LES FACTURES PER DATA ES DEMANAR MASSA...
 */
class DAOsobreDAO
{
    private static Scanner in = new Scanner(System.in);
    private static DAOOscar dao1;
    private static DatabaseType DATABASE;
    private static JAXBContext CONTEXT;
    private static final String DRIVER = "org.exist.xmldb.DatabaseImpl";
    private static final String IP = "172.31.101.225";
    private static final String PORT = "8080";
    private static String myCollection = "uriDAOsobreDAO";
    private static String databasePath = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF4AAD/DAOsobre/database.xml";
    private static File databaseFile = new File(databasePath);

    void saveToExistsDB() throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException, XQException
    {dao1.anadirColecionArchivo(databasePath, myCollection);}
    void añadirProducto() throws JAXBException
    {
        System.out.println("ID del Producto");
        String id = in.nextLine();
        System.out.println("NOMBRE del Producto");
        String name = in.nextLine();
        System.out.println("PRECIO del Producto");
        String price = in.nextLine();
        System.out.println("STOCK del Producto");
        String stock = in.nextLine();

        ProductType newProduct = new ProductType();
        newProduct.setId(id);
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setStock(stock);

        DATABASE.getCatalog().getProduct().add(newProduct);
        Marshaller MS = CONTEXT.createMarshaller();
        MS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        MS.marshal(DATABASE, databaseFile);
        System.out.println("\nProducto añadido");
    }
    void añadirFactura() throws JAXBException
    {
        System.out.println("NIF del Cliente");
        String nif_client = in.nextLine();
        System.out.println("ID del Producto");
        String id_product = in.nextLine();
        System.out.println("PRECIO del Producto");
        String price_each = in.nextLine();
        System.out.println("PRECIO total factura");
        String price_total = in.nextLine();
        System.out.println("IVA");
        String iva = in.nextLine();

        BillType newBill = new BillType();
        newBill.setNifClient(nif_client);
        newBill.setIdProduct(id_product);
        newBill.setPriceEach(price_each);
        newBill.setPriceTotal(price_total);
        newBill.setIva(iva);

        DATABASE.getBills().getBill().add(newBill);
        Marshaller MS = CONTEXT.createMarshaller();
        MS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        MS.marshal(DATABASE, databaseFile);
        System.out.println("\nFactura añadida");
    }
    void empleadoPorAñosTrabajados()
    {
        System.out.println("SALARIO del Empleado a Buscar");
        String years = in.nextLine();
        for (int x=0; x<DATABASE.getEmployees().getEmployee().size(); x++)
        {
            if (DATABASE.getEmployees().getEmployee().get(x).getYearsWorked().equalsIgnoreCase(years))
            {
                System.out.println("\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId()+
                                   "\n   NAME: "+DATABASE.getEmployees().getEmployee().get(x).getName()+
                                   "\n   SURNAME: "+DATABASE.getEmployees().getEmployee().get(x).getSurname()+
                                   "\n   SALARY: "+DATABASE.getEmployees().getEmployee().get(x).getSalary()+
                                   "\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId());
            }
        }
    }
    void empleadoPorSalario()
    {
        System.out.println("SALARIO del Empleado a Buscar");
        String salary = in.nextLine();
        for (int x=0; x<DATABASE.getEmployees().getEmployee().size(); x++)
        {
            if (DATABASE.getEmployees().getEmployee().get(x).getSalary().equalsIgnoreCase(salary))
            {
                System.out.println("\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId()+
                                   "\n   NAME: "+DATABASE.getEmployees().getEmployee().get(x).getName()+
                                   "\n   SURNAME: "+DATABASE.getEmployees().getEmployee().get(x).getSurname()+
                                   "\n   SALARY: "+DATABASE.getEmployees().getEmployee().get(x).getSalary()+
                                   "\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId());
            }
        }
    }
    void empleadoPorApellido()
    {
        System.out.println("APELLIDO del Empleado a Buscar");
        String surname = in.nextLine();
        for (int x=0; x<DATABASE.getEmployees().getEmployee().size(); x++)
        {
            if (DATABASE.getEmployees().getEmployee().get(x).getSurname().equalsIgnoreCase(surname))
            {
                System.out.println("\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId()+
                                   "\n   NAME: "+DATABASE.getEmployees().getEmployee().get(x).getName()+
                                   "\n   SURNAME: "+DATABASE.getEmployees().getEmployee().get(x).getSurname()+
                                   "\n   SALARY: "+DATABASE.getEmployees().getEmployee().get(x).getSalary()+
                                   "\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId());
            }
        }
    }
    void empleadoPorNombre()
    {
        System.out.println("NOMBRE del Empleado a Buscar");
        String name = in.nextLine();
        for (int x=0; x<DATABASE.getEmployees().getEmployee().size(); x++)
        {
            if (DATABASE.getEmployees().getEmployee().get(x).getName().equalsIgnoreCase(name))
            {
                System.out.println("\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId()+
                                   "\n   NAME: "+DATABASE.getEmployees().getEmployee().get(x).getName()+
                                   "\n   SURNAME: "+DATABASE.getEmployees().getEmployee().get(x).getSurname()+
                                   "\n   SALARY: "+DATABASE.getEmployees().getEmployee().get(x).getSalary()+
                                   "\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId());
            }
        }
    }
    void facturasClienteX()
    {
        System.out.println("NIF del Cliente que quieres ver sus facturas");
        String nif = in.nextLine();
        for (int x=0; x<DATABASE.getBills().getBill().size(); x++)
        {
            if (DATABASE.getBills().getBill().get(x).getNifClient().equalsIgnoreCase(nif))
            {
                System.out.println("\n   CLIENT NIF: "+DATABASE.getBills().getBill().get(x).getNifClient()+
                                   "\n   PRODUCT ID: "+DATABASE.getBills().getBill().get(x).getIdProduct()+
                                   "\n   PRICE EACH: "+DATABASE.getBills().getBill().get(x).getPriceEach()+
                                   "\n   PRICE TOTAL: "+DATABASE.getBills().getBill().get(x).getPriceTotal()+
                                   "\n   IVA: "+DATABASE.getBills().getBill().get(x).getIva());
            }
        }
    }
    void borrarCliente()
    {
        System.out.println("NIF del Cliente a Borrar");
        String nif = in.nextLine();
        for (int x=0; x<DATABASE.getClients().getClient().size(); x++)
        {
            if (DATABASE.getClients().getClient().get(x).getNif().equalsIgnoreCase(nif))
            {
                DATABASE.getClients().getClient().remove(x);
                System.out.println("\nCliente Borrado");
            }
        }
    }
    void borrarEmpleado() throws JAXBException
    {
        System.out.println("ID del Empleado a Borrar");
        String id = in.nextLine();
        for (int x=0; x<DATABASE.getEmployees().getEmployee().size(); x++)
        {
            if (DATABASE.getEmployees().getEmployee().get(x).getId().equalsIgnoreCase(id))
            {
                DATABASE.getEmployees().getEmployee().remove(x);
                System.out.println("\nEmpleado Borrado");
            }
        }
    }
    void añadirCliente() throws JAXBException
    {
        System.out.println("NIF del Cliente");
        String nif = in.nextLine();
        System.out.println("NOMBRE del Cliente");
        String name = in.nextLine();
        System.out.println("APELLIDO del Cliente");
        String surname = in.nextLine();

        ClientType newClient = new ClientType();
        newClient.setNif(nif);
        newClient.setName(name);
        newClient.setSurname(surname);

        DATABASE.getClients().getClient().add(newClient);
        Marshaller MS = CONTEXT.createMarshaller();
        MS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        MS.marshal(DATABASE, databaseFile);
        System.out.println("\nCliente añadido");
    }
    void añadirEmpleado()throws JAXBException
    {
        System.out.println("ID del Empleado");
        String id = in.nextLine();
        System.out.println("NOMBRE del Empleado");
        String name = in.nextLine();
        System.out.println("APELLIDO del Empleado");
        String surname = in.nextLine();
        System.out.println("SUELDO del Empleado");
        String salary = in.nextLine();
        System.out.println("AÑOS TRABAJADOS del Empleado");
        String years = in.nextLine();

        EmployeeType newEmployee = new EmployeeType();
        newEmployee.setId(id);
        newEmployee.setName(name);
        newEmployee.setSurname(surname);
        newEmployee.setSalary(salary);
        newEmployee.setYearsWorked(years);

        DATABASE.getEmployees().getEmployee().add(newEmployee);
        Marshaller MS = CONTEXT.createMarshaller();
        MS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        MS.marshal(DATABASE, databaseFile);
        System.out.println("\nEmpleado añadido");
    }
    void showAll() throws JAXBException
    {
        System.out.println("\n ----- ----- CLIENTS ----- ----- ");
        for (int x=0; x<DATABASE.getClients().getClient().size(); x++)
        {
            System.out.println("\n   NIF: "+DATABASE.getClients().getClient().get(x).getNif()+
                               "\n   NAME: "+DATABASE.getClients().getClient().get(x).getName()+
                               "\n   SURNAME: "+DATABASE.getClients().getClient().get(x).getSurname());
        }
        System.out.println("\n ----- ----- EMPLOYEES ----- ----- ");
        for (int x=0; x<DATABASE.getEmployees().getEmployee().size(); x++)
        {
            System.out.println("\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId()+
                               "\n   NAME: "+DATABASE.getEmployees().getEmployee().get(x).getName()+
                               "\n   SURNAME: "+DATABASE.getEmployees().getEmployee().get(x).getSurname()+
                               "\n   SALARY: "+DATABASE.getEmployees().getEmployee().get(x).getSalary()+
                               "\n   ID: "+DATABASE.getEmployees().getEmployee().get(x).getId());
        }
        System.out.println("\n ----- ----- BILLS ----- ----- ");
        for (int x=0; x<DATABASE.getBills().getBill().size(); x++)
        {
            System.out.println("\n   CLIENT NIF: "+DATABASE.getBills().getBill().get(x).getNifClient()+
                               "\n   PRODUCT ID: "+DATABASE.getBills().getBill().get(x).getIdProduct()+
                               "\n   PRICE EACH: "+DATABASE.getBills().getBill().get(x).getPriceEach()+
                               "\n   PRICE TOTAL: "+DATABASE.getBills().getBill().get(x).getPriceTotal()+
                               "\n   IVA: "+DATABASE.getBills().getBill().get(x).getIva());
        }
        System.out.println("\n ----- ----- PRODUCTS ----- ----- ");
        for (int x=0; x<DATABASE.getCatalog().getProduct().size(); x++)
        {
            System.out.println("\n   PRODUCT ID: "+DATABASE.getCatalog().getProduct().get(x).getId()+
                               "\n   PRODUCT NAME: "+DATABASE.getCatalog().getProduct().get(x).getName()+
                               "\n   PRICE: "+DATABASE.getCatalog().getProduct().get(x).getPrice()+
                               "\n   STOCK: "+DATABASE.getCatalog().getProduct().get(x).getStock());
        }
    }
    DAOsobreDAO() throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException, JAXBException
    {
        configureJAXB();
        openExistsDB();
    }
    private void configureJAXB() throws JAXBException
    {
        CONTEXT = JAXBContext.newInstance(DatabaseType.class);
        Unmarshaller UMS = CONTEXT.createUnmarshaller();
        DATABASE  = (DatabaseType) UMS.unmarshal(databaseFile);
    }
    private void openExistsDB() throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException
    {
        String URI = "xmldb:exist://" + IP + ":" + PORT + "/exist/xmlrpc";
        String adminUsername = "admin";
        String adminPassword = "dionis";

        dao1 = new DAOOscar(IP, PORT, adminUsername, adminPassword, URI, DRIVER);
        dao1.anadorColeccion(myCollection);
        dao1.anadirColecionArchivo(databasePath, myCollection);
    }
}

