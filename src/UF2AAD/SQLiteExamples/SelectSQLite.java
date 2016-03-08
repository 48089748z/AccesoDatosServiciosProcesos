package UF2AAD.SQLiteExamples;

import java.sql.*;

/**
 * Created by dremon on 09/11/15.
 */
public class SelectSQLite {

    public static void main(String[] args)
    {
            Connection c = null;
            Statement stmt = null;
            try
            {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:Peliculas.db");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");

                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM PELICULAS;" );
                while ( rs.next() )
                {
                    int id = rs.getInt("id");
                    String  title = rs.getString("title");
                    String  release = rs.getString("release");
                    String  actor = rs.getString("actor");
                    String  character = rs.getString("character");

                    System.out.println( "ID = " + id );
                    System.out.println( "TITLE = " + title );
                    System.out.println( "RELEASE = " + release );
                    System.out.println( "ACTOR = " + actor);
                    System.out.println( "CHARACTER = " + character );

                    System.out.println();
                }
                rs.close();
                stmt.close();
                c.close();
            }
            catch ( Exception e )
            {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            System.out.println("Operation done successfully");
        }
}


