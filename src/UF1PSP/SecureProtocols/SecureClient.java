package UF1PSP.SecureProtocols;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Created by 48089748z on 13/04/16.
 */
public class SecureClient
{
    public static void main(String[] args) throws IOException
    {
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        SSLSocket cliente = (SSLSocket) ssf.createSocket();
        InetSocketAddress address = new InetSocketAddress("localhost", 5556);
        cliente.connect(address);

        OutputStream os = cliente.getOutputStream();
        String mensage = "HOLA";
        os.write(mensage.getBytes());

        cliente.close();

    }
}
