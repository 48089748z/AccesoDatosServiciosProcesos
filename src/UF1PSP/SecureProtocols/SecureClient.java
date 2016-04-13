package UF1PSP.SecureProtocols;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * Created by 48089748z on 13/04/16.
 */
public class SecureClient
{
    //GENERAR EL ARCHIVO CON LAS LLAVES (EJECUTAR EL COMANDO SIGUIENTE EN LA CARPETA CORRESPONDIENTE)
    //keytool -genkey -keystore yourkeysnames -keyalg RSA

    //REFERENCIAR LOS .class
    //java -Djavax.net.ssl.keyStore=oriolkeys -Djavax.net.ssl.trustStore=oriolkeys -Djavax.net.ssl.keyStorePassword=callapesat SecureServer

    public static void main(String[] args) throws IOException
    {
        SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();

        SSLSocket cliente = (SSLSocket) ssf.createSocket();
        InetSocketAddress address = new InetSocketAddress("localhost", 5556);
        cliente.connect(address);
        OutputStream os = cliente.getOutputStream();

        //Y ara enviem la operacio al Server per que ens doni el resultat.
        Scanner in = new Scanner(System.in);
        System.out.println("\nIntroduce la Operacion en String con * + - / sin espacios");
        String operacion = in.nextLine();
        os.write(operacion.getBytes());
        cliente.close();
    }
}
