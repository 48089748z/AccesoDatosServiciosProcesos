package UF1PSP;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
public class SignaturaDigital
{
    public static final String PRIVATE_KEY_FILE = "private.key";
    public static final String FITXER_PLA = "Sparring.pdf";
    public static final String FITXER_SIGNAT = "firmat.pdf";
    private static KeyPair publicKey = null;
    private static PrivateKey privateKey = null;

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ClassNotFoundException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        File f = new File(FITXER_PLA);
        if(!Utils.areKeysPresent()) {
            publicKey = Utils.generatePublicKey();
            privateKey = publicKey.getPrivate();
        }
        else {
            ObjectInputStream inputStream = null;
            inputStream = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
            privateKey = (PrivateKey) inputStream.readObject();
        }

        byte[] digestionat = Utils.digestiona(f,"MD5");
        byte[] encryptDigestionat = Utils.sign(digestionat, privateKey);
        System.out.println("Longitud del fitxer: "+f.length());
        System.out.println("Longitud de la firma: "+encryptDigestionat.length);
        //Utils.write(FITXER_SIGNAT,Utils.concatenateByteArrays(Utils.read(f),encryptDigestionat));

       // String fitxer_signat,
    }
}
