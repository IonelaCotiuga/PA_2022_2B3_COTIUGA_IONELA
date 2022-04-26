package lab8;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {
        try {
            Database.createConnection();
            //Database.createTableContinents();
            //Database.createTableCountries();

            var continents = new ContinentDAO();
            //continents.create("Europe", 100);
            //Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("America");
            System.out.println(europeId);
//            countries.create("Romania", europeId);
//            countries.create("Ukraine", europeId);
//            Database.getConnection().commit();

            String[] countriesArray = countries.printAllCountries(europeId);
            for(String str:countriesArray){
                if(str != null)
                    System.out.println(str);
            }

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }

/*
* run sql shell
* \connect dbname - to connect to your cities database
*
* */
}
