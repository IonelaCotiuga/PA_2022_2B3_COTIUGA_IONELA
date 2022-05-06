package repositoryClasses;

import tables.ContinentsEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class ContinentRepository {

    public void create(ContinentsEntity continent, int id, String name){
        continent.setId(id);
        continent.setName(name);
    }

    public List findById(int id, EntityManager em ) {
        return em.createNamedQuery("ContinentsEntity.findById")
                .setParameter(1 , id)
                .getResultList();
    }

    public List findByPattern(EntityManager em ) {
        return em.createNamedQuery("ContinentsEntity.findByPattern")
                .getResultList();
    }

}
