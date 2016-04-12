package UF4AAD.DAOsobre;
import org.xmldb.api.base.XMLDBException;
import javax.xml.xquery.XQException;
import java.util.Scanner;


/**
 * Created by 48089748z on 31/03/16.
 */
public class Controller
{
    private static DAOsobreDAO dao2;
    public static void main(String[] args) throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException
    {
        start();
        menu();




    }
    public static void menu()
    {
        Scanner in = new Scanner(System.in);
        boolean stop = false;
        while (stop==false)
        {
            System.out.println("\n (0)Mostrar Todo\n (1) Añadir Empleado\n(2) Añadir Cliente\n(3) Borrar Empleado \n(4) Borrar Cliente \n (5)Facturas Cliente X");
            String option = in.nextLine();
            switch (option)
            {
                case "1":
                {
                    //dao2.añadirEmpleado();
                    break;
                }
                case "2":
                {
                   dao2.añadirCliente();
                    break;
                }
                case "3":
                {
                    //dao2.borrarEmpleado();
                    break;
                }
                case "4":
                {
                    //dao2.borrarCliente();

                    break;
                }
                case "5":
                {
                    //dao2.todasLasFacturasDelCliente();
                    break;
                }
                case "0":
                {
                    dao2.showAll();
                    break;
                }
                default: //Cierra el programa
                {
                    stop=true;
                    System.out.println("\nCERRANDO PROGRAMA");
                    break;
                }
            }
        }
    }
    static void start() throws XMLDBException, ClassNotFoundException, IllegalAccessException, InstantiationException, XQException
    {
        dao2 = new DAOsobreDAO();
        dao2.openDatabase();
    }
}
