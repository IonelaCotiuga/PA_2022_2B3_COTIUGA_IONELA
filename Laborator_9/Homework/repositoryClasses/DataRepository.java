package repositoryClasses;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

public abstract class DataRepository <T, ID extends Serializable>{
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ExamplePU");
    EntityManager em = emf.createEntityManager();

    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        //em.close();
    }

    public List findById(int id, T entity) {
        String tableName = entity.getClass().getName();
        String str = tableName.substring(7);
        String queryName = str + ".findById";

        return em.createNamedQuery(queryName)
                .setParameter(1 , id)
                .getResultList();
    }

    public List findByPattern(T entity) {
        String tableName = entity.getClass().getName(); // tables.tableName
        String str = tableName.substring(7); // tableName
        String queryName = str + ".findByPattern";

        return em.createNamedQuery(queryName)
                .getResultList();
    }

}