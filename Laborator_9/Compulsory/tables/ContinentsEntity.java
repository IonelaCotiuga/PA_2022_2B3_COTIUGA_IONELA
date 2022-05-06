package tables;

import javax.persistence.*;

@Entity
@Table(name = "continents", schema = "public", catalog = "cities")
@NamedQueries({
        @NamedQuery(name = "ContinentsEntity.findAll",
                query = "select e from ContinentsEntity e order by e.name"),
        @NamedQuery(name = "ContinentsEntity.findById",
                query = "select e from ContinentsEntity e where e.id = ?1"),
        @NamedQuery(name = "ContinentsEntity.findByPattern",
                query = "select e from ContinentsEntity e where e.name like 'A%'"),
})

public class ContinentsEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public ContinentsEntity(){}

    public ContinentsEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
