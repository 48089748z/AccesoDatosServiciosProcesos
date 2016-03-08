package UF3PSP.RMIRemote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class RMICalculatorClient//CLIENTE QUE ACCEDE AL SERVIDOR
{
    private static String operacion = " ";
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        while (!operacion.equals("0"))
        {
            System.out.println("\nIntroduce una operación \n(0) Para Cerrar \n(I) Para Información\n(S) Para Sorpresa");
            operacion = in.nextLine();
            RMIServerInterface server;
            try
            {
                Registry registry = LocateRegistry.getRegistry("localhost", 5555); //ACCEDEMOS AL REGISTRO
                server = (RMIServerInterface) registry.lookup("interfaz");
                if (operacion.equals("0"))
                {
                    System.out.println("AQUI SI QUE ENTRA");
                    System.out.println(server.cerrar()); //LLAMAMOS AL METODO CERRAR()
                }
                else if (operacion.equalsIgnoreCase("I"))
                {
                    System.out.println(server.informacion()); //LLAMAMOS AL METODO INFORMACION()
                }
                else if(operacion.equalsIgnoreCase("S"))
                {
                    System.out.println(server.sorpresa()); //LLAMAMOS AL METODO SORPRESA
                }
                else
                {
                    System.out.println("\nEl resultado de '" + operacion + "' es: " + server.calcular(operacion)); //LLAMAMOS AL METODO CALCULAR
                }
            }
            catch (RemoteException | NotBoundException exception) {exception.printStackTrace();}
        }
    }
}
