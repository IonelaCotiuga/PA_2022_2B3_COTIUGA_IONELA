package com.example.lab11;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connect {
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("Person");
    EntityManager em = emf.createEntityManager();

    public void create(Person entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        //em.close();
    }

    public Person findById(int id){
        return (Person) em.createNamedQuery("Person.findById")
                .setParameter(1 , id)
                .getResultList()
                .get(0);
    }

    public void update(String newName, int id){
        em.getTransaction().begin();
        em.createNamedQuery("Person.update")
                .setParameter(1, newName)
                .setParameter(2, id)
                .executeUpdate();
        em.getTransaction().commit();
    }

    public void delete(int id){
        em.getTransaction().begin();;
        em.createNamedQuery("Person.delete")
                .setParameter(1, id)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
