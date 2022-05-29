package com.example.lab11;

import javax.persistence.*;

@Entity
@Table
@NamedQueries(value = {
        @NamedQuery(name = "Person.findById",
                query = "select e from Person e where e.id = ?1"),
        @NamedQuery(name = "Person.findByName",
                query = "select e from Person e where e.name = ?1"),
        @NamedQuery(name = "Person.update",
                query = "update Person e set e.name = ?1 where e.id = ?2"),
        @NamedQuery(name = "Person.delete",
                query = "delete from Person e where e.id = ?1"),
        @NamedQuery(name = "Person.getPersons",
                query = "select e from Person e"),
        @NamedQuery(name = "Person.getCount",
                query = "select count(e) from Person e"),
})
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {}

    public int getId() {return id;}

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
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
