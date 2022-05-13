package repositoryClasses;

import tables.CitiesEntity;
import java.util.List;

public class CitiesRepository extends DataRepository {
    public void create(CitiesEntity entity, int id, String name) {
        entity.setId(id);
        entity.setName(name);
        super.create(entity);
    }

    @Override
    public List findById(int id, Object entity) {
        return super.findById(id, entity);
    }

    @Override
    public List findByPattern(Object entity) {
        return super.findByPattern(entity);
    }

    public List getPopulation(){
        return em.createNamedQuery("CitiesEntity.population")
                .getResultList();
    }

    public int getPopulationAfterCityName(String name){
        return (int) em.createNamedQuery("CitiesEntity.getPopulation")
                .setParameter(1 , name)
                .getResultList()
                .get(0);
    }

    public List getCities(){
        return em.createNamedQuery("CitiesEntity.getCities")
                .getResultList();
    }

    public String getCountry(String cityName){
        return (String) em.createNamedQuery("CitiesEntity.getCountry")
                .setParameter(1, cityName)
                .getResultList()
                .get(0);
    }

    public void insertIntoCities(CitiesEntity city) {
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO cities (id, name) VALUES (?,?)")
                .setParameter(1, city.getId())
                .setParameter(2, city.getName())
                .executeUpdate();
        em.getTransaction().commit();
    }

    public void setPopulation(int id, int population){
        em.getTransaction().begin();
        em.createNativeQuery("UPDATE cities set population = ?1 where id = ?2")
                .setParameter(1, population)
                .setParameter(2,id)
                .executeUpdate();
        em.getTransaction().commit();
    }


}
