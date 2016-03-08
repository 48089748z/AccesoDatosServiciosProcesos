package UF2AAD.MovieDBwithDAO;

import java.sql.*;
public class MovieDAO
{
    private static String SQLiteDriver = "org.sqlite.JDBC";
    private static String SQLiteDB = "jdbc:sqlite:Peliculas.db";

    private static String PostgreSQLDriver = "org.postgresql.Driver";
    private static String PostgreSQLiteDB = "jdbc:postgresql://172.31.104.78/peliculas";
    private static String username = "uri3";
    private static String password = "uri3";

    public static void showAll()
    {
        try
        {
            Class.forName(PostgreSQLDriver);
            Connection connection = DriverManager.getConnection(PostgreSQLiteDB, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM PELICULAS");
            while (result.next())
            {
                System.out.println("\nMovie ID: "+result.getString("ID"));
                System.out.println("Title:"+ result.getString("TITLE"));
                System.out.println("Release Date:"+result.getString("RELEASE"));
                System.out.println("Actors: "+result.getString("CHARACTERS"));
            }
            result.close();
            statement.close();
            connection.close();
        }
        catch ( Exception one ) {}
        System.out.println("\nSELECTS DONE SUCCESSFULLY!");
    }
    public static void searchActor(Integer actorId)
    {
        try
        {
            Class.forName(PostgreSQLDriver);
            Connection connection = DriverManager.getConnection(PostgreSQLiteDB, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM PELICULAS WHERE CHARACTERS LIKE '%[ID: " + actorId + " -%'");
            System.out.println("\nActor with ID " + actorId + " appears in the following films");
            while (result.next())
            {
                System.out.println("\nMovie ID: " + result.getString("ID"));
                System.out.println("Title:" + result.getString("TITLE"));
                System.out.println("Release Date:" + result.getString("RELEASE"));
                System.out.println("Actors: " + result.getString("CHARACTERS"));
            }
            result.close();
            statement.close();
            connection.close();
        } catch (Exception one) {}
    }
    public static void searchFilm(Integer filmId)
    {
        try
        {
            Class.forName(PostgreSQLDriver);
            Connection connection = DriverManager.getConnection(PostgreSQLiteDB, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM PELICULAS WHERE ID = "+filmId);
            while (result.next())
            {
                System.out.println("\nMovie ID: " + result.getString("ID"));
                System.out.println("Title:" + result.getString("TITLE"));
                System.out.println("Release Date:" + result.getString("RELEASE"));
            }
            result.close();
            statement.close();
            connection.close();
        } catch (Exception one) {}
    }
    public static void searchFilmByActor(Integer actorId)
    {
        try
        {
            Class.forName(PostgreSQLDriver);
            Connection connection = DriverManager.getConnection(PostgreSQLiteDB, username, password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM PELICULAS WHERE CHARACTERS LIKE '%[ID: " + actorId + " -%'");
            System.out.println("\nActor with ID " + actorId + " appears in the following films");
            while (result.next())
            {
                System.out.println("\nMovie ID: " + result.getString("ID"));
                System.out.println("Title:" + result.getString("TITLE"));
                System.out.println("Release Date:" + result.getString("RELEASE"));
                System.out.println("Actors: " + result.getString("CHARACTERS"));
            }
            result.close();
            statement.close();
            connection.close();
        } catch (Exception one) {}
    }
}
