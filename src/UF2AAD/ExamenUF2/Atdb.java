package UF2AAD.ExamenUF2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Atdb {
    /**
     * Main: La seva funcionalitat �s un exemple. L'haureu de modificar
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
     /* Capitol cap1 = getCapitol(100);
        Character pers1 = getPersonatge(100);
        cap1.imprimir_capitol();
        pers1.imprimir_personatge();*/

        Scanner in = new Scanner(System.in);
        boolean stop = false;
        ATDAO DAO = new ATDAO();
        while (!stop)
        {
            System.out.println("\n0: CREAR BBDD\n1: BUSCAR PERSONAJES POR ID\n2: BUSCAR EPISODIO POR ID\n3: MOSTRAR TODO\n4: INSERTAR PERSONAJE\n5: INSERTAR EPISODIO\n6: LLENAR BBDD CON JSONS\n7: SALIR");
            int option = in.nextInt();
            switch(option)
            {
                default:
                {
                    stop = true;
                    break;
                }
                case 0:
                {
                    DAO.generateDatabase();
                    break;
                }
                case 1:
                {
                    DAO.buscarPersonaje();
                    break;

                }
                case 2:
                {
                    DAO.buscarEpisodio();
                    break;
                }
                case 3:
                {
                    DAO.mostrarTodo();
                    break;
                }
                case 4:
                {
                    DAO.insertarPersonaje();
                    break;
                }
                case 5:
                {
                    DAO.insertarEpisodio();
                    break;
                }
                case 6:
                {
                    for(int x=1; x<=7; x++)
                    {
                        Capitol episodeX = getCapitol(x);
                        Character personajeX = getPersonatge(x);
                        DAO.insertarEpisodioFromJSON(episodeX);
                        DAO.insertarPersonajeFromJSON(personajeX);
                    }
                }
            }
        }

    }

    /**
     * Petici� GET per a actuar contra la API
     * @param urlToRead
     * @return
     * @throws Exception
     */

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        conn.disconnect();
        return result.toString();
    }


    /**
     * A partir d'un enter k retorna el personatge de id k
     * @param k
     * @return
     * @throws Exception
     */

    private static Character getPersonatge(int k) throws Exception {

        String url = "http://adventuretimeapi.com/api/v1/characters/"+k;
        String jsonurl = getHTML(url);
        return SJPersoApi(jsonurl);

    }

    /**
     * A partir d'un enter k retorna l'episodi de id k
     * @param k
     * @return
     * @throws Exception
     */

    public static Capitol getCapitol(int k) throws Exception
    {

        String url = "http://adventuretimeapi.com/api/v1/episodes/"+k;
        String jsonurl = getHTML(url);
        return SJCapiApi(jsonurl);
    }

    /**
     * Funcio que modifica el JSON del cap�tol per retornar un Cap�tol
     * @param cadena
     * @return
     */

    public static Capitol SJCapiApi(String cadena){
        Object obj = JSONValue.parse(cadena);
        JSONObject jobj = (JSONObject)obj; // Contiene toda la informaci�n del JSON

        Long idprovi = (Long)jobj.get("id");
        Integer id = Math.toIntExact(idprovi);
        String titol = (String)jobj.get("title");
        String description = (String)jobj.get("description");

        JSONArray jarray = (JSONArray)jobj.get("characters");
        Integer num_pers = jarray.size();
        String pers[] = new String[jarray.size()];
        Integer id_pers[] = new Integer[jarray.size()];

        for (int i = 0; i < jarray.size(); i++) {
            JSONObject jobjda = (JSONObject)jarray.get(i);
            pers[i] = (String)jobjda.get("name");
            Long aux = (Long)jobjda.get("id");
            id_pers[i] = Math.toIntExact(aux);
        }

        return new Capitol(id, titol, num_pers, id_pers, pers, description);
    }

    /**
     * Funcio que modifica el JSON del cap�tol per retornar un Personatge
     * @param cadena
     * @return
     */

    public static Character SJPersoApi(String cadena){

        Object obj = JSONValue.parse(cadena);
        JSONObject jobj = (JSONObject)obj; // Contiene toda la informaci�n del JSON

        Long idprovi = (Long)jobj.get("id");
        Integer id = Math.toIntExact(idprovi);
        String name = (String)jobj.get("name");

        JSONArray jarray = (JSONArray)jobj.get("episode");
        Integer epis[] = new Integer[jarray.size()];

        for (int i = 0; i < jarray.size(); i++) {
            JSONObject jobjda = (JSONObject)jarray.get(i);
            Long aux = (Long)jobjda.get("id");
            epis[i] = Math.toIntExact(aux);
        }

        //  public Character(Integer id, String name, Integer num_episodis, Integer[] episodes)

        return new Character(id,name,jarray.size(),epis);

    }
}
