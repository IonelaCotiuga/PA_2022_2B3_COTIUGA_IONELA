package lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CitiesDAO {
    private int id = 1;
    BufferedReader lineReader = new BufferedReader(new FileReader("C:\\Users\\cotiu\\IdeaProjects\\PA_Lab\\Laborator_8\\src\\main\\resources\\concap.csv"));
    String lineText = null;

    public CitiesDAO() throws FileNotFoundException {
    }

    public  Integer getNrCities() throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select count(*) from cities")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public  Integer findLatitude(int newId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select latitude from cities where id = '" + newId + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public  Integer findLongitude(int newId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select longitude from cities where id = '" + newId + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findCity(int newId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select country from cities where id = '" + newId + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public void create() throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into cities (id, name, country, capital, latitude, longitude) values (?,?,?,?,?,?)")) {

            lineReader.readLine(); // skip header line
            while((lineText = lineReader.readLine()) != null){
                String[] data = lineText.split(",");
                String countryName = data[0];
                String capitalName = data[1];
                String capitalLatitude = data[2];
                String capitalLongitude = data[3];
                String cityName = "City" + id;

                pstmt.setInt(1, id++);
                pstmt.setString(2, cityName);
                pstmt.setString(3, countryName);
                pstmt.setString(4, capitalName);
                pstmt.setString(5, capitalLatitude);
                pstmt.setString(6, capitalLongitude);

                pstmt.executeUpdate();
            }
            lineReader.close();

            //pstmt.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
