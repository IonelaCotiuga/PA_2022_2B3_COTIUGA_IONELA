package repositoryClasses;

import tables.ContinentsEntity;
import tables.CountriesEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CountryRepository {
    public void create(CountriesEntity country, int id, String name){
        country.setId(id);
        country.setName(name);
    }

    public List findById(int id, EntityManager em ) {
        return em.createNamedQuery("CountriesEntity.findById")
                .setParameter(1 , id)
                .getResultList();
    }

    public List findByPattern(EntityManager em ) {
        return em.createNamedQuery("CountriesEntity.findByPattern")
                .getResultList();
    }
}

