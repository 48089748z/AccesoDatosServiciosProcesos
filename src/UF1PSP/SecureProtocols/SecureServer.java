package UF1PSP.SecureProtocols;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;

/**
 * Created by 48089748z on 13/04/16.
 */
public class SecureServer
{
    public static void main(String[] args) throws IOException, ScriptException
    {
        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sss = (SSLServerSocket) ssf.createServerSocket();
        InetSocketAddress address = new InetSocketAddress("0.0.0.0", 5556);
        sss.bind(address);

        SSLSocket ss = (SSLSocket) sss.accept();
        InputStream is = ss.getInputStream();
        byte[] men = new byte[25];
        is.read(men);

        String msg = new String(men);
        System.out.println("Resultado de: "+msg+" "+calcular(msg));
        sss.close();
    }

    public static String calcular(String msg) throws ScriptException
    {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return engine.eval(msg).toString();
    }
}
