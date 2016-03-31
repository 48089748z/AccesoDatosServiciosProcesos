package UF1PSP;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
public class Utils
{

    public static byte[] digestiona(File file, String type) throws NoSuchAlgorithmException, IOException
    {
        MessageDigest md = MessageDigest.getInstance(type);
       return null;
    }
    public static boolean areKeysPresent()
    {
        return true;
    }
    public static KeyPair generatePublicKey()
    {
        return null;//new KeyPair();
    }
    public static boolean read(File file)
    {
        return true;
    }
    public static byte[] sign(byte[] digestionat, PrivateKey privateKey)
    {
        return null;
    }
    public static boolean write()
    {
        return true;
    }
    public static String digestiona(String path) throws NoSuchAlgorithmException, FileNotFoundException, IOException
    {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        File f = new File(path);
        InputStream is = new FileInputStream(f);
        byte[] buffer = new byte[(int) f.length()];
        int read = 0;
        while ((read = is.read(buffer)) > 0)
        {
            digest.update(buffer, 0, read);
        }
        byte[] md5sum = digest.digest();
        BigInteger bigInt = new BigInteger(1, md5sum);
        String output = bigInt.toString(16);
        is.close();
        return output;
    }
    public static boolean Comparar(String file, String hashCode) throws NoSuchAlgorithmException, IOException {return hashCode.equals(digestiona(file));}
    public static boolean comparar(String file1, String file2) throws NoSuchAlgorithmException, IOException{return digestiona(file1).equals(digestiona(file2));}
}
