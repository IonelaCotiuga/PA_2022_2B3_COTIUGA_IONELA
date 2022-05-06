package lab8;

import java.sql.*;

public class Distance {

    public static String getLatitude(String city) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select latitude from cities where name='" + city + "'" )) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public static String getLongitude(String city) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select longitude from cities where name='" + city + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
        catch (SQLException e){
            System.out.println("Error!");
        }
        return null;
    }

    public static double findDistance(String city1, String city2) throws SQLException {
        if(getLatitude(city1)==null || (getLongitude(city1)==null)){
            System.out.println("Name "+ city1+" doesn t exists!");
            System.exit(0);
        }

        if(getLatitude(city2)==null || (getLongitude(city2)==null)){
            System.out.println("Name "+ city2+" doesn t exists!");
            System.exit(0);
        }

        double lat1 = Double.parseDouble(getLatitude(city1));
        double lat2 = Double.parseDouble(getLatitude(city2));

        double lon1 = Double.parseDouble(getLongitude(city1));
        double lon2 = Double.parseDouble(getLongitude(city2));

        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;

        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;

        return(c * r);

    }

}
