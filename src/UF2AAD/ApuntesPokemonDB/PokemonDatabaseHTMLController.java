package UF2AAD.ApuntesPokemonDB;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 48089748z on 12/11/15.
 */
public class PokemonDatabaseHTMLController
{
    public static void main(String[] args)
    {
        String JsonString ="";
        for (int x = 1; x<=100; x++)
        {
            String peticion = "http://pokeapi.co/api/v1/pokemon/"+x;
            try
            {
                JsonString = getHTML(peticion);
                Pokemon pokemon = SJPokeApi(JsonString);
            }
            catch (Exception one) {}
        }
    }
    public static Pokemon SJPokeApi(String cadena)
    {
        Object obj = JSONValue.parse(cadena);
        JSONObject jobj = (JSONObject) obj;

        String pokemonName = (String) jobj.get("name");
        String pokemonId = (String) jobj.get("id");
        String pokemonsTypes[] = new String[jobj.size()];

        System.out.println("\n-------------------\n\n------POKEMON------");
        System.out.println("Nombre: "+jobj.get("name"));
        System.out.println("Id: "+jobj.get("national_id"));
        System.out.print("Tipos: ");
        JSONArray jarray = (JSONArray) jobj.get("types");

        for(int x=0; x<jarray.size(); x++)
        {
            JSONObject JobjFromArray = (JSONObject) jarray.get(x);

            pokemonsTypes[x] = (String) JobjFromArray.get("name");
            System.out.print(JobjFromArray.get("name")+"   ");
        }

        Pokemon pokemon = new Pokemon(pokemonName, pokemonId, pokemonsTypes);
        return pokemon;
    }

    public static String getHTML(String urlToRead) throws Exception
    {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null)
        {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}
