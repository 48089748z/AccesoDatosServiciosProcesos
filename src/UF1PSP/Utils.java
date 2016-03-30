package UF1PSP;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;

/**
 * Created by 48089748z on 30/03/16.
 */
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
        return new KeyPair();
    }
    public static boolean read(File file)
    {
        return true;
    }
    public static byte[] sign(byte[] dignestionat, PrivateKey privateKey)
    {
        return null;
    }
    public static boolean write()
    {
        return true;
    }


}
