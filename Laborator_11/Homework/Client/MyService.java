package com.example.lab11consumer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


public class MyService {

    private final RestTemplate restTemplate;

    public MyService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public int getCount(){
        return this.restTemplate.getForObject("http://localhost:90/person/count", Integer.class);
    }

    public List<Person> getPersons(){
        return Arrays.stream(this.restTemplate.getForObject("http://localhost:90/person", Person[].class)).toList();
    }

    public void addPerson(String name){
        HttpEntity<Person> entity = new HttpEntity<>(new Person(name));
        this.restTemplate.exchange("http://localhost:90/person/obj", HttpMethod.POST, entity, String.class);
    }

    public void addPerson(String name, int id){
        HttpEntity<Person> entity = new HttpEntity<>(new Person(name, id));
        this.restTemplate.exchange("http://localhost:90/person/obj", HttpMethod.POST, entity, String.class);
    }

    public void changeName(long id, String name){
        HttpEntity<NameModifier> entity = new HttpEntity<>(new NameModifier(id, name));
        this.restTemplate.exchange("http://localhost:90/person/" + id + "?name=" + name, HttpMethod.PUT, entity, String.class);
    }

    public Person getById(long id){
        return this.restTemplate.getForObject("http://localhost:90/person/" + id, Person.class);
    }

    public void makeFriends(String name, String friend){
        HttpEntity<Friends> entity = new HttpEntity<>(new Friends(name, friend));
        this.restTemplate.exchange("http://localhost:90/friends/obj", HttpMethod.POST, entity, String.class);
    }

    public List<Friends> getFriendList(String name){
        return Arrays.stream(this.restTemplate.getForObject("http://localhost:90/friends/" + name, Friends[].class)).toList();
    }

    public List<Person> getPopular(int number){
        return Arrays.stream(this.restTemplate.getForObject("http://localhost:90/friends/mostPopular/" + number, Person[].class)).toList();
    }

}
