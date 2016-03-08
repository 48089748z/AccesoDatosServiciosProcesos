import UF2AAD.PokemonDatabase.Pokemon;
import com.db4o.internal.Null;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ParaSergi
{
    private static String url = "http://www.vagalume.com.br/iron-maiden/discografia/index.js";
    public static void main(String[] args)
    {
        JSONObject OBJETO_ENTERO = (JSONObject) JSONValue.parse(getJSON(url));
        JSONObject DISCOGRAPHY =  (JSONObject) JSONValue.parse(OBJETO_ENTERO.get("discography").toString());
        JSONArray ARRAY_ALBUMS = (JSONArray) JSONValue.parse(DISCOGRAPHY.get("item").toString());

        for (int x=0; x<ARRAY_ALBUMS.size(); x++)
        {
            JSONObject SELECTED_ALBUM = (JSONObject) JSONValue.parse(ARRAY_ALBUMS.get(x).toString());
            System.out.println();
            System.out.println("ALBUM: "+SELECTED_ALBUM.get("desc").toString());
            System.out.println("PUBLISHED: "+SELECTED_ALBUM.get("published").toString());
            JSONArray ENESTEJSONHAYUNARRAYSINSENTIDO = (JSONArray) JSONValue.parse(SELECTED_ALBUM.get("discs").toString());
            JSONArray ARRAY_DISCS = (JSONArray) JSONValue.parse(ENESTEJSONHAYUNARRAYSINSENTIDO.get(0).toString());
            System.out.println("DISCOS:");
            for (int y=0; y<ARRAY_DISCS.size(); y++)
            {
                JSONObject SELECTED_DISC = (JSONObject) JSONValue.parse(ARRAY_DISCS.get(y).toString());
                System.out.println("   DISCO "+y);
                System.out.println("   ID: "+SELECTED_DISC.get("id").toString());
                System.out.println("   DESC: "+SELECTED_DISC.get("desc").toString());
                try
                {
                    System.out.println("   URL: "+SELECTED_DISC.get("url").toString());
                }
                catch (NullPointerException noexiste)
                {
                    System.out.println("   URL: NO TIENE");
                }
                System.out.println();
            }
        }









    }

    public static String getJSON(String URLtoRead) //Metode per agafar el String que cont� el JSON desde internet
    {
        try
        {
            StringBuilder stringJSON = new StringBuilder();
            URL url = new URL(URLtoRead);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null)
            {
                stringJSON.append(line);
            }
            reader.close();
            return stringJSON.toString();
        }
        catch (Exception one)
        {
            return "getJSON() didn't work, you are in the Catch block!";
        }
    }
}
