package UF4AAD.DAOsobre;
import org.xmldb.api.base.XMLDBException;
import javax.xml.bind.JAXBException;
import javax.xml.xquery.XQException;
import java.util.Scanner;
/**
 * Created by 48089748z on 31/03/16.
 */
public class Controller
{
    private static DAOsobreDAO dao2;
    public static void main(String[] args) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException, JAXBException
    {
        dao2 = new DAOsobreDAO();
        menu();
    }
    public static void menu() throws JAXBException
    {
        Scanner in = new Scanner(System.in);
        boolean stop = false;
        while (stop==false)
        {
            System.out.println("\n|-------------------------------------------------------------------------------------|" +
                               "\n| (0) Mostrar Todo         (5) Facturas Cliente X               (10) Añadir Factura   |" +
                               "\n| (1) Añadir Empleado      (6) Empleado por nombre              (11) Añadir Producto  |" +
                               "\n| (2) Añadir Cliente       (7) Empleado por apellido                                  |" +
                               "\n| (3) Borrar Empleado      (8) Empleado por salario                                   |" +
                               "\n| (4) Borrar Cliente       (9) Empleado por años trabajados     (ANY) Cerrar Programa |" +
                               "\n|-------------------------------------------------------------------------------------|");
            String option = in.nextLine();
            switch (option)
            {
                case "0":
                {
                    dao2.showAll();
                    dao2.saveToExistsDB();
                    break;
                }
                case "1":
                {
                    dao2.añadirEmpleado();
                    dao2.saveToExistsDB();
                    break;
                }
                case "2":
                {
                    dao2.añadirCliente();
                    dao2.saveToExistsDB();
                    break;
                }
                case "3":
                {
                    dao2.borrarEmpleado();
                    dao2.saveToExistsDB();
                    break;
                }
                case "4":
                {
                    dao2.borrarCliente();
                    dao2.saveToExistsDB();
                    break;
                }
                case "5":
                {
                    dao2.facturasClienteX();
                    dao2.saveToExistsDB();
                    break;
                }
                case "6":
                {
                    dao2.empleadoPorNombre();
                    dao2.saveToExistsDB();
                    break;
                }
                case "7":
                {
                    dao2.empleadoPorApellido();
                    dao2.saveToExistsDB();
                    break;
                }
                case "8":
                {
                    dao2.empleadoPorSalario();
                    dao2.saveToExistsDB();
                    break;
                }
                case "9":
                {
                    dao2.empleadoPorAñosTrabajados();
                    dao2.saveToExistsDB();
                    break;
                }
                case "10":
                {
                    dao2.añadirFactura();
                    dao2.saveToExistsDB();
                    break;
                }
                case "11":
                {
                    dao2.añadirProducto();
                    dao2.saveToExistsDB();
                    break;
                }
                default:
                {
                    stop=true;
                    System.out.println("\nCERRANDO PROGRAMA");
                    break;
                }
            }
        }
    }
}
