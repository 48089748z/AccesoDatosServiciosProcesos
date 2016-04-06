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

    public static byte[] encrypt(byte[] digestionat, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(digestionat);
    }
    public static byte[] decrypt(byte[] encrypted, PublicKey publicKey) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(encrypted);
    }
    public static void write(String FILE_TO_SIGN, byte[] arrayConcatenat) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(FILE_TO_SIGN);
        fos.write(arrayConcatenat);
        fos.close();
    }
    public static byte[] concatenateByteArrays(byte[] array1, byte[] array2) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
        outputStream.write( array1 );
        outputStream.write( array2 );
        return outputStream.toByteArray();
    }

}
