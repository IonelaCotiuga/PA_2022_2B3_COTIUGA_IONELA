package repositoryClasses;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;
import tables.CitiesEntity;
import tables.ContinentsEntity;
import tables.CountriesEntity;

import java.util.List;


public class Main {
    public static void testJPA() {

        // create, findById,
        ContinentRepository continentRepository = new ContinentRepository();
        ContinentsEntity entity = new ContinentsEntity();
        continentRepository.create(entity, 128, "NewContinent");

        int id = 100;
        List<ContinentsEntity> list;
        list = continentRepository.findById(id, entity);
        for (ContinentsEntity continent1 : list){
            System.out.println("Continent with id = " + id + " is = " +  continent1.getName());
        }

        List<ContinentsEntity> list1;
        list1 = continentRepository.findByPattern(entity);
        System.out.println("List of continents that starts with letter A: ");
        for (ContinentsEntity continent1 : list1){
            System.out.println("id = " + continent1.getId() + ", name = " +  continent1.getName());
        }

        CountryRepository countryRepository  = new CountryRepository();
        CountriesEntity entity1 = new CountriesEntity();
        countryRepository.create(entity1, 126, "NewCountry");

        int idCountry = 100;
        List<CountriesEntity> listCountry;
        listCountry = countryRepository.findById(idCountry, entity1);
        for (CountriesEntity country1 : listCountry){
            System.out.println("Country with id = " + idCountry + " is = " +  country1.getName());
        }

        CitiesRepository cityRepository  = new CitiesRepository();
        CitiesEntity city = new CitiesEntity();
        cityRepository.create(city, 310, "NewCity");

        int idCity = 1;
        List<CitiesEntity> listCitiess;
        listCitiess = cityRepository.findById(idCity, city);
        for(CitiesEntity city1 : listCitiess){
            System.out.println("City with id = " + idCity + " is = " +  city1.getName());
        }

        // insert new cities
        //  log the execution time
        long startTime = System.nanoTime();

        int newCityId = 271;
        for(int i = 0; i<10; i++){
            CitiesEntity newCity = new CitiesEntity();

            newCity.setId(newCityId);
            newCity.setName("City");
            cityRepository.insertIntoCities(newCity);
            newCityId++;
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) ;

        System.out.println("Execution time of JPQL queries: " + duration + " nanoseconds.");

        //  new property in cities -> population.
        for (int i = 1; i <= 245; i++){
            cityRepository.setPopulation(i, i);
        }

        // Choco solver
        List<String> listCities;
        listCities = cityRepository.getCities();

        for(String city1 : listCities){
            for(String city2 : listCities){
                Model model = new Model("my first problem");

                // orasele incep cu aceeasi litera
                IntVar firstLetterOfCity1 = model.intVar((int) city1.charAt(0));
                IntVar firstLetterOfCity2 = model.intVar((int) city2.charAt(0));
                model.arithm(firstLetterOfCity1, "=", firstLetterOfCity2).post();

                // suma populatiei este intre 2 numere [1, 20]
                IntVar[] values = new IntVar[2];
                int value1 = cityRepository.getPopulationAfterCityName(city1);
                int value2 = cityRepository.getPopulationAfterCityName(city2);
                values[0] = model.intVar(value1);
                values[1] = model.intVar(value2);

                model.sum(values, ">=", 1).post();
                model.sum(values, "<=", 20).post();

                // sunt din tari diferite
                String country1 = cityRepository.getCountry(city1);
                String country2 = cityRepository.getCountry(city2);
                int equals = 0;
                if(country1.compareTo(country2) == 0){
                    equals = 1;
                }

                // equals = 0 => tarile sunt diferite
                IntVar intVarEquals = model.intVar(equals);
                IntVar is1 = model.intVar(1);
                IntVar is0 = model.intVar(0);
                model.arithm(intVarEquals, "=", is0).post();

                if(city1.compareTo(city2) != 0){
                    Solver solver = model.getSolver();
                    if(solver.solve()){
                        solver.printStatistics();
                        System.out.println("city1 = " + city1);
                        System.out.println("city2 = " + city2);
                        System.out.println("population1 = " + value1);
                        System.out.println("population2 = " + value2);
                        System.out.println("country1 = " + country1);
                        System.out.println("country2 = " + country2);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        testJPA();
    }
}
