package UF1PSP;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
public class Utils
{
    private static KeyPairGenerator generator = null;
    public static byte[] digestiona(File file, String type) throws NoSuchAlgorithmException, IOException
    {
        MessageDigest messageDigest = MessageDigest.getInstance(type);
        messageDigest.update(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        return messageDigest.digest();
    }
    public static boolean areKeysPresent()
    {
        if (generator==null){return false;}
        else {return true;}
    }
    public static KeyPair generatePublicKey() throws NoSuchAlgorithmException
    {
        generator = KeyPairGenerator.getInstance("RSA");
        return generator.generateKeyPair();
    }
    public static byte[] read(File file) throws IOException {return Files.readAllBytes(Paths.get(file.getAbsolutePath()));}

    public static byte[] sign(byte[] digestionat, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(digestionat);
    }

    public static void write()
    {

    }




    public static void concatenateByteArrays()
    {

    }
}
