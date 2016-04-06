package UF1PSP;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.util.Arrays;

public class SignaturaDigital
{
    public static final String PRIVATE_KEY_FILE = "private.key";
    public static final String FITXER_PLA = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF1PSP/Original_file.txt";
    public static final String FITXER_SIGNAT = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF1PSP/Signed_file.txt";
    private static KeyPair keyPair = null;
    private static PublicKey publicKey = null;
    private static PrivateKey privateKey = null;


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ClassNotFoundException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        File f = new File(FITXER_PLA);
        if(!Utils.areKeysPresent())
        {
            keyPair = Utils.generatePublicKey();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
        }
        else
        {
            ObjectInputStream inputStream = null;
            inputStream = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
            privateKey = (PrivateKey) inputStream.readObject();
        }

        byte[] digestionat = Utils.digestiona(f,"MD5");
        byte[] encryptDigestionat = Utils.encrypt(digestionat, privateKey);
        System.out.println("FILE LENGTH: "+f.length());
        System.out.println("STAMP LENGTH: "+encryptDigestionat.length);
        Utils.write(FITXER_SIGNAT, Utils.concatenateByteArrays(Utils.read(f), encryptDigestionat));
    }
}
