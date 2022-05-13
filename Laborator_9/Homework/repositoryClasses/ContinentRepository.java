package repositoryClasses;

import tables.ContinentsEntity;
import java.util.List;

public class ContinentRepository extends DataRepository {

    public void create(ContinentsEntity entity, int id, String name) {
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
