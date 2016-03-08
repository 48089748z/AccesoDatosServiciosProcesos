package UF3PSP.RMIRemote;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
public class RMICalculatorServer implements RMIServerInterface //SERVIDOR QUE IMPLEMENTA LA INTERFAZ
{
    private static RMICalculatorServer rmiCalculatorServer = new RMICalculatorServer();
    @Override
    public String calcular(String operacion) throws RemoteException //OVERRIDE DEL METODO CALCULAR
    {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result = "\nHa fallado el calculo... (Las Operaciones deben contener solamente numeros, y simbolos / * + -";
        try {result = engine.eval(operacion).toString();}
        catch (ScriptException one) {one.printStackTrace();}
        return result;
    }
    @Override
    public String cerrar() throws RemoteException //OVERRIDE DEL METODO CERRAR
    {return "\nCerrando Programa!";}

    @Override
    public String sorpresa() throws RemoteException //OVERRIDE DEL METODO SORPRESA
    {
        return "HOLA SORPRESAAAAAA METODO USELESS PERO COMO PIDES 4 PUES HAGO 4 :D";
    }

    @Override
    public String informacion() throws RemoteException //OVERRIDE DEL METODO INFORMACION
    {
        return "\nLa opción de introducir operación te permite hacer operaciones complejas con parentesis y sombolos de + - * y / encadenados.\nLas otras opciones se definen en el menú";
    }

    public static void main(String[] args)
    {
        Registry reg = null;
        try {reg = LocateRegistry.createRegistry(5555);} //CREAMOS EL REGISTRO
        catch (Exception two) {two.printStackTrace();}
        try
        {
            reg.rebind("interfaz", UnicastRemoteObject.exportObject(rmiCalculatorServer,0)); //EXPORTAMOS EL OBJECTO 'INTERFAZ' PARA QUE SEA ACCESIBLE DE FORMA REMOTA
            System.out.println("\nEl metodo ha sido subido a Internet para que sea accesible de forma remota.");
        }
        catch (Exception three){System.out.println("\nERROR: No se ha podido subir el metodo a Internet.");three.printStackTrace();}
        System.out.println("El Servidor esta escuchando.\nAhora Ejecuta el Cliente para hacer los calculos.");
    }
}
