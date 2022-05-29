package com.example.lab11consumer;


public class Person {
    private long id;
    private String name;

    public Person(){}

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
