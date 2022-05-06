package lab8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/cities";
    private static final String USER = "postgres";
    private static final String PASSWORD = "IONELA";
    private static Connection connection = null;
    private Database() {}

    public static Connection getConnection() {
        return connection;
    }

    public static void createConnection() throws SQLException {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public static void createTableContinents() throws SQLException{
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        try(Statement stmt = con.createStatement();
        ){
            String sql1 = "DROP table if exists continents";

            String sql = "CREATE TABLE continents " +
                        "(id INTEGER , " +
                        " name VARCHAR(40), " +
                        " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql1);
           stmt.executeUpdate(sql);
            stmt.close();
            System.out.println("Created table continents in cities database");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTableCountries() throws SQLException{
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        try(Statement stmt = con.createStatement();
        ){
            String sql1 = "DROP table if exists countries";
            String sql = "CREATE TABLE countries " +
                    "(id INTEGER , " +
                    " name VARCHAR(40), " +
                    " code VARCHAR(40),"+
                    " continent VARCHAR(40))";

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql);

            stmt.close();
            System.out.println("Created table countries in cities database");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTableCities() throws SQLException{
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        try(Statement stmt = con.createStatement();
        ){
            String sql1 = "DROP table if exists cities";
            String sql = "CREATE TABLE cities " +
                    "(id INTEGER , " +
                    " name VARCHAR(40), " +
                    " country VARCHAR(40)," +
                    " capital VARCHAR(40) ," +
                    " latitude VARCHAR(20) ," +
                    " longitude VARCHAR(20) ," +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql);

            stmt.close();
            System.out.println("Created table cities in cities database");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

    public static void rollback() {

    }



}
