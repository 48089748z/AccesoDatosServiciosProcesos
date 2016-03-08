package UF2AAD.MovieDBwithDAO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseGenerator //Execute this once to build the Database.
{
    //https://api.themoviedb.org/3/movie/100/credits?api_key=db94687026da4c4526fdd35d2e7b2f10

    private static ArrayList<Movie> moviesList;
    final static String BASE_URL = "https://api.themoviedb.org/3/movie/";
    final static String APY_KEY = "?api_key=db94687026da4c4526fdd35d2e7b2f10";
    private static String SQLiteDriver = "org.sqlite.JDBC";
    private static String SQLiteDB = "jdbc:sqlite:Peliculas.db";

    private static String PostgreSQLDriver = "org.postgresql.Driver";
    private static String PostgreSQLiteDB = "jdbc:postgresql://172.31.104.78/peliculas";
    private static String username = "uri3";
    private static String password = "uri3";

    public static void main(String[] args)
    {
        //ESTA CLASE SOLO HA DE SER EJECUTADA UNA VEZ!

        generateDatabase(); //CREAMOS LA BASE DE DATOS VACIA
        fillDatabase(); //LA LLENAMOS CON TODAS LAS PELICULAS Y ACTOR DE THEMOVIEDB API

    }
    public static void generateDatabase()
    {
        try
        {
            Class.forName(PostgreSQLDriver);
            Connection connection = DriverManager.getConnection(PostgreSQLiteDB, username, password);
            Statement statement = connection.createStatement();
            String query =   "CREATE TABLE PELICULAS" +
                    "(ID           TEXT    NOT NULL," +
                    " TITLE        TEXT    NOT NULL," +
                    " RELEASE      TEXT            ," +
                    " CHARACTERS   TEXT            )";
            statement.executeUpdate(query);
            statement.close();
            connection.close();
            System.out.println("\nDATABASE GENERATED SUCCESSFULLY!");
        } catch (Exception one) {}

    }
    public static void fillDatabase()//Metode per fer els INSERTS a la base de dades.
    {
        generateObjectsFromJSON();
        System.out.println();
        for (int x = 0; x < moviesList.size(); x++) {
            try
            {
                Class.forName(PostgreSQLDriver);
                Connection connection = DriverManager.getConnection(PostgreSQLiteDB, username, password);
                connection.setAutoCommit(false);
                String tableSQL = "INSERT INTO PELICULAS" +
                        "(ID, TITLE, RELEASE, CHARACTERS) VALUES" +
                        "(?,?,?,?)";

                PreparedStatement prepStat = connection.prepareStatement(tableSQL);
                prepStat.setString(1, moviesList.get(x).getMovie_id());
                prepStat.setString(2, moviesList.get(x).getTitle());
                prepStat.setString(3, moviesList.get(x).getRelease_date());
                prepStat.setString(4, moviesList.get(x).getCharacters().toString());

                prepStat.executeUpdate();
                prepStat.close();
                connection.commit();
                connection.close();
                System.out.println("INSERT " + x + " DONE SUCCESSFULLY!");
            } catch (Exception one) {
                System.out.println("INSERT " + x + " FAILED!");
            }
        }
    }
    public static void generateObjectsFromJSON()
    {
        moviesList = new ArrayList<>();
        for (int peliNum=110; peliNum<=118; peliNum++) //Agafem les pelicules entre la 99 y la 117
        {
            String callMovie = BASE_URL+peliNum+APY_KEY;
            String callCharacters = BASE_URL+peliNum+"/credits"+APY_KEY;

            Movie movie = new Movie();
            JSONObject movieJO = (JSONObject) JSONValue.parse(getJSON(callMovie));
            JSONObject castJO = (JSONObject) JSONValue.parse(getJSON(callCharacters));
            JSONArray castJA = (JSONArray) JSONValue.parse(castJO.get("cast").toString());
            movie.setMovie_id(movieJO.get("id").toString());
            movie.setTitle(movieJO.get("title").toString());
            movie.setRelease_date(movieJO.get("release_date").toString());
            ArrayList<Character> characters = new ArrayList<>();
            for(int x=0; x<castJA.size(); x++)
            {
                JSONObject characterJO = (JSONObject) JSONValue.parse(castJA.get(x).toString());
                Character character = new Character();
                character.setCharacterName(characterJO.get("character").toString());
                character.setActorName(characterJO.get("name").toString());
                character.setId(characterJO.get("id").toString());
                characters.add(character);
            }
            movie.setCharacters(characters);
            //System.out.println("MOVIE "+peliNum+" OBJECT GENERATED SUCCESFULLY");
            moviesList.add(movie);
        }
    }
    public static String getJSON(String URLtoRead) //Metode per agafar el String que conté el JSON desde internet
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
        catch (Exception one) {return null;}
    }
}
