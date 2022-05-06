package repositoryClasses;

import tables.CitiesEntity;
import tables.ContinentsEntity;
import tables.CountriesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void testJPA() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamplePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //////////////////////// Continents ////////////////////////////

        ContinentRepository continentRepository = new ContinentRepository();
        ContinentsEntity continent = new ContinentsEntity();
        continentRepository.create(continent,202, "Antarctica");
        em.persist(continent);

        int id = 100;
        List<ContinentsEntity> list;
        list = continentRepository.findById(id, em);
        for (ContinentsEntity continent1 : list){
            System.out.println("Continent with id = " + id + " is = " +  continent1.getName());
        }

        list = continentRepository.findByPattern(em);
        System.out.println("List of continents that starts with letter A: ");
        for (ContinentsEntity continent1 : list){
            System.out.println("id = " + continent1.getId() + ", name = " +  continent1.getName());
        }

        //////////////////////// Countries ////////////////////////////

        CountryRepository countryRepository  = new CountryRepository();
        CountriesEntity country = new CountriesEntity();
        countryRepository.create(country, 200, "Italy");
        em.persist(country);

        int idCountry = 100;
        List<CountriesEntity> listCountry;
        listCountry = countryRepository.findById(idCountry, em);
        for (CountriesEntity country1 : listCountry){
            System.out.println("Country with id = " + idCountry + " is = " +  country1.getName());
        }

        listCountry = countryRepository.findByPattern(em);
        System.out.println("List of countries that starts with letter R: ");
        for (CountriesEntity country1 : listCountry){
            System.out.println("id = " + country1.getId() + ", name = " +  country1.getName());
        }

        //////////////////////// Cities ////////////////////////////

        CitiesRepository cityRepository  = new CitiesRepository();
        CitiesEntity city = new CitiesEntity();
        cityRepository.create(city, 300, "NewCity");
        em.persist(city);

        int idCity = 1;
        List<CitiesEntity> listCities;
        listCities = cityRepository.findById(idCity, em);
        for(CitiesEntity city1 : listCities){
            System.out.println("City with id = " + idCity + " is = " +  city1.getName());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void main(String[] args) {
        testJPA();
    }
}
