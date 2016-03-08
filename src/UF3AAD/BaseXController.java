package UF3AAD;

import org.basex.api.client.ClientSession;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by 48089748z on 01/03/16.
 */
public class BaseXController
{
    private static boolean stop = false;
    private static String document = "doc(\"mondial.xml\")";

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (!stop)
        {
            System.out.println("\n|--------------------MENU PRINCIPAL-------------------|"+
                    "\n| (1) INFORMACIÓN DE TODOS LOS PAISES                 |"+
                    "\n| (2) NUMERO DE PAISES                                |"+
                    "\n| (3) INFORMACIÓN SOBRE ALEMAÑA                       |"+
                    "\n| (4) POBLACIÓN DE UGANDA                             |"+
                    "\n| (5) CIUDADES DE PERÚ                                |"+
                    "\n| (6) POBLACIÓN DE SHANGAI                            |"+
                    "\n| (7) CODIGO DE LA MATRICULA DE XIPRE                 |" +
                    "\n| (0) CERRAR PROGRAMA                                 |"+
                    "\n| --------------------------------------------------- |");
            Integer option = 0;
            try{option = in.nextInt();}
            catch (InputMismatchException e){System.out.println("\nSi sabes que has de poner un Integer, y pones otra cosa, te cierro el programa :)");}
            switch (option)
            {
                case 1:
                {
                    executeQueryAndOutPrintResult(document+"/mondial/country/name");
                    break;
                }
                case 2:
                {
                    executeQueryAndOutPrintResult(document+"count(/mondial/country/name)");
                    break;
                }
                case 3:
                {
                    executeQueryAndOutPrintResult(document+"/mondial/country[name='Germany']");
                    break;
                }
                case 4:
                {
                    executeQueryAndOutPrintResult(document+"/mondial/country[name='Uganda']/@population");
                    break;
                }
                case 5:
                {
                    executeQueryAndOutPrintResult(document+"/mondial/country[name='Peru']/province/city/name");

                    break;
                }
                case 6:
                {
                    executeQueryAndOutPrintResult(document+"/mondial/country/province/city[name='Shanghai']/population");
                    break;
                }
                case 7:
                {
                    executeQueryAndOutPrintResult(document+"/mondial/country[name='Cyprus']/@car_code");
                    break;
                }

                case 0:
                {
                    stop = true;
                    System.out.println("CERRANDO PROGRAMA!");
                    break;
                }
                default:
                {
                    System.out.println("OPCIÓN NO VALIDA, INTENTALO DE NUEVO.");
                    break;
                }
            }
        }
    }
    public static void executeQueryAndOutPrintResult (String query)
    {
        ClientSession clientSession = null;
        try
        {
            clientSession = new ClientSession("localhost", 1984, "admin", "admin");
            System.out.println("\nQuery: " + query);
            System.out.println("\nResultado: "+clientSession.query(query).execute());

        }
        catch (IOException one) {
            one.printStackTrace();
            System.out.println("\nERROR EJECUTANDO CONSULTA");
        }
        finally
        {
            if (clientSession!=null)
            {
                try {clientSession.close();
                } catch (IOException two) {
                    System.out.println("\nERROR CERRANDO SESIÓN");
                }
            }
        }
    }
}
