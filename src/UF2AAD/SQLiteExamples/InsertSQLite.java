package UF2AAD.SQLiteExamples; /**
 * Created by dremon on 09/11/15.
 */

import java.sql.*;

public class InsertSQLite {

    public static void main(String[] args) {

        Connection conection = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conection = DriverManager.getConnection("jdbc:sqlite:Peliculas.db");
            conection.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = conection.createStatement();
            String sql = "INSERT INTO PELICULAS (ID,TITLE,RELEASE,ACTOR,CHARACTER) " +

                    "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);
            stmt.close();
            conection.commit();
            conection.close();
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}
