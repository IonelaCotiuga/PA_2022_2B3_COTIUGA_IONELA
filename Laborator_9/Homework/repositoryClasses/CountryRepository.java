package repositoryClasses;

import tables.CountriesEntity;
import java.util.List;

public class CountryRepository extends DataRepository {
    public void create(CountriesEntity entity, int id, String name) {
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

}

