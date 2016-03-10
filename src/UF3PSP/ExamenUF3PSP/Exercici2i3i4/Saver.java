package UF3PSP.ExamenUF3PSP.Exercici2i3i4;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
public class Saver
{
    private static File info = new File("/home/48089748z/Escriptori/IdeaProjects/DadesIServeis/src/UF3PSP/ExamenUF3PSP/Exercici2i3i4/log.txt");
    public static void saveInfoInAFile(String infoToSave)
    {
        Date actual = new Date();
        infoToSave = "\n"+actual.toString()+"  "+infoToSave;
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(info, true));
            if (info.exists())
            {
                bw.write(infoToSave);
            }
            else
            {
                info.createNewFile();
                bw.write(infoToSave);
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
