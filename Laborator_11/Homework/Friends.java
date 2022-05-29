package com.example.lab11;

import javax.persistence.*;

@Entity
@Table

@NamedQueries(value = {
        @NamedQuery(name = "Friends.countByName",
                query = "select count(e) from Friends e where e.name = ?1"),
        @NamedQuery(name = "Friends.getByName",
                query = "select e from Friends e where e.name = ?1"),
})
public class Friends {
    @Id
    @SequenceGenerator(
            name = "friends_sequence",
            sequenceName = "friends_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "friends_sequence"
    )

    private String friend;
    private String name;

    public Friends(String name, String friend) {
        this.name = name;
        this.friend = friend;
    }

    public Friends() {}

    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "name='" + name + '\'' +
                ", friend='" + friend + '\'' +
                '}';
    }
}
