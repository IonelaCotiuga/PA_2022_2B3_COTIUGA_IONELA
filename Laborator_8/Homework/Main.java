package lab8;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        try {
            Database.createConnection();
            Database.createTableCities();
            Database.createTableContinents();
            Database.createTableCountries();


            var continents = new ContinentDAO();
                continents.create("Europe", 100);
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            System.out.println("Europe's id = " + europeId);
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();

            var cities = new CitiesDAO();
            cities.create();
            Database.getConnection().commit();

            System.out.println("Distance between City1 and City2 = " + Distance.findDistance("City1", "City2"));
            System.out.println("Distance between City0 and City2= " + Distance.findDistance("City0", "City2"));

            String[] countriesArray = countries.printAllCountries(europeId);
            for(String str:countriesArray){
                if(str != null)
                    System.out.println(str);
            }

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

/*
* run sql shell
* \connect dbname - to connect to your cities database
*
* */
}
