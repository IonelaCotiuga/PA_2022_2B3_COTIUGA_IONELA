package repositoryClasses;

import tables.CitiesEntity;
import tables.CountriesEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CitiesRepository {
    public void create(CitiesEntity city, int id, String name){
        city.setId(id);
        city.setName(name);
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
