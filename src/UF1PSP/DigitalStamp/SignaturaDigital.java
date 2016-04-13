package UF1PSP.DigitalStamp;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
public class SignaturaDigital
{
    public static final String PUBLIC_KEY_FILE = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF1PSP/DigitalStamp/PUBLIC_KEY.txt";
    public static final String PRIVATE_KEY_FILE = "/home/48089748z/Escriptori/PRIVATE_KEY.txt";
    public static final String ORIGINAL_FILE = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF1PSP/DigitalStamp/Original_file.txt";
    public static final String STAMPED_FILE = "/home/48089748z/Escriptori/IdeaProjects/AccesoDatosServiciosProcesos/src/UF1PSP/DigitalStamp/Signed_file.txt";
    private static KeyPair keyPair = null;
    private static PublicKey publicKey = null;
    private static PrivateKey privateKey = null;
    private static  File file = new File(ORIGINAL_FILE);
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ClassNotFoundException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException
    {
        if(!Utils.areKeysPresent())
        {
            keyPair = Utils.generateKeys();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
            saveKeysOnAFile();
        }
        byte[] fileHash = Utils.getHash(file,"MD5");
        byte[] encrypted = Utils.encrypt(fileHash, privateKey);
        Utils.write(STAMPED_FILE, Utils.concatenateByteArrays(Utils.read(file), encrypted));

        byte[] decryptedHash = Utils.decrypt(encrypted, publicKey);
        String hash1 = new String(fileHash,"UTF-8");
        String hash2 = new String (decryptedHash, "UTF-8");
        System.out.println("\nHASH ORIGINAL FILE: "+hash1+"\nORIGINAL FILE LENGTH: "+file.length()+"\nSTAMPED FILE LENGTH: "+encrypted.length+"\nDECRYPTED HASH: "+hash2);
        if (hash1.equals(hash2))
        {
            System.out.println("\n ES EL ARCHIVO ORIGINAL!");
        }
    }
    public static void saveKeysOnAFile() throws IOException
    {
        FileOutputStream publicFos = new FileOutputStream(PUBLIC_KEY_FILE);
        FileOutputStream privateFos = new FileOutputStream(PRIVATE_KEY_FILE);
        byte[] publicK = publicKey.getEncoded();
        byte[] privateK = privateKey.getEncoded();
        publicFos.write(publicK);
        privateFos.write(privateK);
        publicFos.close();
        privateFos.close();
        System.out.println("\n LLAVES GUARDADAS EN ARCHIVOS.txt");
    }
}
