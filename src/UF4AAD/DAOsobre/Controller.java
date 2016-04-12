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
        dao2 = new DAOsobreDAO();
       // menu();
        dao2.openDatabase();



    }
    public static void menu()
    {
        Scanner in = new Scanner(System.in);
        String option = in.nextLine();

        //switch(option)
    }

}
