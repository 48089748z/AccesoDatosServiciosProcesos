package UF1PSP.SecureProtocols;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;

/**
 * Created by 48089748z on 13/04/16.
 */
public class SecureServer
{
    public static void main(String[] args) throws IOException
    {
        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sss = (SSLServerSocket) ssf.createServerSocket();

        InetSocketAddress address = new InetSocketAddress("0.0.0.0", 5556);
        sss.bind(address);

        SSLSocket ss = (SSLSocket) sss.accept();
        InputStream is = ss.getInputStream();
        byte[] men = new byte[25];
        is.read(men);

        System.out.println("Message: "+new String(men));
        sss.close();
    }
}
