package UF2AAD.ExamenUF2;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ATDAO
{
    private static Scanner in = new Scanner(System.in);
    private static String DRIVER = "org.sqlite.JDBC";
    private static String DBNAME = "jdbc:sqlite:cunado.db";

    public static void insertarEpisodioFromJSON(Capitol episode)
    {
        try
        {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBNAME);
            connection.setAutoCommit(false);
            String insertarPersonaje = "INSERT INTO EPISODIOS"
                    +"(ID, TITULO, PERSONAJES) VALUES"
                    +"(?,?,?)";

            PreparedStatement prepStat = connection.prepareStatement(insertarPersonaje);
            prepStat.setString(1, episode.getId().toString());
            prepStat.setString(2, episode.getTitol());
            prepStat.setString(3, episode.getPersString());

            prepStat.executeUpdate();
            prepStat.close();
            connection.commit();
            connection.close();
            System.out.println("INSERTADO EPISODIO " + episode.getTitol());
        }
        catch (Exception one) {
            System.out.println("ERROR AL INSERTAR EPISODIO");
        }

    }
    public static void insertarPersonajeFromJSON(Character personaje)
    {
        try
        {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBNAME);
            connection.setAutoCommit(false);
            String insertarPersonaje = "INSERT INTO PERSONAJES"
                    +"(ID, NOMBRE, EPISODIOS) VALUES"
                    +"(?,?,?)";

            PreparedStatement prepStat = connection.prepareStatement(insertarPersonaje);
            prepStat.setString(1, personaje.getId().toString());
            prepStat.setString(2, personaje.getName().toString());
            prepStat.setString(3, personaje.getEpisodesString());

            prepStat.executeUpdate();
            prepStat.close();
            connection.commit();
            connection.close();
            System.out.println("INSERTADO PERSONAJE " + personaje.getName());
        }
        catch (Exception one)
        {
            System.out.println("ERROR AL INSERTAR PERSONAJE");
        }

    }
    public static void generateDatabase()
    {
        try
        {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBNAME);
            Statement statement = connection.createStatement();

            String crearPersonajes = "CREATE TABLE PERSONAJES"
                    +"(ID       TEXT,"
                    +"NOMBRE    TEXT,"
                    +"EPISODIOS TEXT)";

            String crearEpisodios = "CREATE TABLE EPISODIOS"
                    +"(ID        TEXT,"
                    +"TITULO     TEXT,"
                    +"PERSONAJES TEXT)";

            statement.executeUpdate(crearPersonajes);
            statement.executeUpdate(crearEpisodios);
            statement.close();
            connection.close();
            System.out.println("\nDATABASE GENERATED SUCCESSFULLY!");
        } catch (Exception one)
        {
            System.out.println("\nERROR GENERANDO LA BBDD");
        }
    }
    public static void mostrarTodo()
    {
        try
        {
            System.out.println("RESULTADOS:");
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBNAME);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            ResultSet consultaPersonajes = statement.executeQuery("SELECT * FROM PERSONAJES");
            while (consultaPersonajes.next())
            {
                System.out.println("\nID Personaje: " + consultaPersonajes.getString("ID"));
                System.out.println("Nombre: " + consultaPersonajes.getString("NOMBRE"));
                System.out.println("Episodios: "+consultaPersonajes.getString("EPISODIOS"));
            }

            ResultSet consultaCapitulos = statement.executeQuery("SELECT * FROM CAPITULOS");
            while (consultaCapitulos.next())
            {
                System.out.println("\n ID Capitulo: " + consultaPersonajes.getString("ID"));
                System.out.println("Titulo: " + consultaPersonajes.getString("TITULO"));
            }

            consultaPersonajes.close();
            consultaCapitulos.close();
            statement.close();
            connection.close();
        }
        catch ( Exception one ) {}
    }


    public static void insertarPersonaje()
    {
        System.out.println("Escribe ID del personaje (Si ya existe no lo insertare!)");
        String id = in.next();
        System.out.println("Escribe nombre del personaje");
        String nombre = in.next();

        try
        {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBNAME);
            connection.setAutoCommit(false);
            String insertarPersonaje = "INSERT INTO PERSONAJES"
                    +"(ID, NOMBRE, EPISODIOS) VALUES"
                    +"(?,?,?)";

            PreparedStatement prepStat = connection.prepareStatement(insertarPersonaje);
            prepStat.setString(1, id);
            prepStat.setString(2, nombre);
            prepStat.setString(3, "");

            prepStat.executeUpdate();
            prepStat.close();
            connection.commit();
            connection.close();
            System.out.println("INSERTADO PERSONAJE " + nombre);
        }
        catch (Exception one) {
            System.out.println("ERROR AL INSERTAR PERSONAJE");
        }
    }
    public static void insertarEpisodio()
    {
        System.out.println("Escribe ID del episodio (Si ya existe no lo insertare!)");
        int id = in.nextInt();
        System.out.println("Escribe titulo del episodio");
        String titulo = in.next();
        try
        {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBNAME);
            connection.setAutoCommit(false);
            String insertarPersonaje = "INSERT INTO EPISODIOS" +
                    "(ID, TITULO, PERSONAJES) VALUES" +
                    "(?,?,?)";

            PreparedStatement prepStat = connection.prepareStatement(insertarPersonaje);
            prepStat.setString(1, String.valueOf(id));
            prepStat.setString(2, titulo);
            prepStat.setString(3, "");

            prepStat.executeUpdate();
            prepStat.close();
            connection.commit();
            connection.close();
            System.out.println("INSERTADO EPISODIO "+titulo);
        }
        catch (Exception one) {
            System.out.println("ERROR AL INSERTAR EPISODIO");
        }
    }
    public static void buscarEpisodio()
    {
        System.out.println("Escribe la ID del episodio");
        String id = in.next();

        try
        {
            System.out.println("RESULTADOS:");
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBNAME);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet consultaEpisodio = statement.executeQuery("SELECT * FROM EPISODIOS WHERE ID = '"+id+"'");
            while (consultaEpisodio.next())
            {
                System.out.println("\nID Personaje: " + consultaEpisodio.getString("ID"));
                System.out.println("Nombre: " + consultaEpisodio.getString("TITULO"));
                System.out.println("Episodios: " + consultaEpisodio.getString("PERSONAJES"));
            }
            consultaEpisodio.close();
            statement.close();
            connection.close();
        }
        catch ( Exception one ) {}
    }
    public static void buscarPersonaje()
    {
        System.out.println("Escribe la ID del personaje");
        String id = in.next();

        try
        {
            System.out.println("RESULTADOS:");
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(DBNAME);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet consultaPersonaje = statement.executeQuery("SELECT * FROM PERSONAJES WHERE ID = '" + id + "'");
            while (consultaPersonaje.next())
            {
                System.out.println("\nID Personaje: " + consultaPersonaje.getString("ID"));
                System.out.println("Nombre: " + consultaPersonaje.getString("NOMBRE"));
                System.out.println("Episodios: " + consultaPersonaje.getString("EPISODIOS"));
            }
            consultaPersonaje.close();
            statement.close();
            connection.close();
        }
        catch ( Exception one ) {}
    }
}
