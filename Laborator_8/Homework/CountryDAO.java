package lab8;

import java.sql.*;
import java.util.Arrays;

public class CountryDAO {
    public void create(String name, int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (name, id) values (?,?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int newId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where id=newId")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public String[] printAllCountries(int newId) throws SQLException{
        String[] countries = new String[44];
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from countries where id=100")) {

            int i = 0;
            while (rs.next()) {
                String s = rs.getString(1);
                countries[i++] = s;
            }
        }
        return countries;
    }

}
