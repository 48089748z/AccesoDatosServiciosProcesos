package UF3PSP.RMIRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RMIServerInterface extends Remote //INTERFAZ CON METODOS
{
    String calcular(String operacion) throws RemoteException;
    String cerrar() throws RemoteException;
    String sorpresa() throws RemoteException;
    String informacion() throws RemoteException;
}
