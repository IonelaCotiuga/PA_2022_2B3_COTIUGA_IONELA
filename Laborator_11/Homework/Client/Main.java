package com.example.lab11consumer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Client client = new Client();
        System.out.println(client.service.getCount());
        client.service.addPerson("Ion");
        client.service.addPerson("Ana");
        client.service.addPerson("Mihai");
        client.service.addPerson("Gigi");
        client.service.addPerson("newUser", 8);


        client.service.changeName(1,"pink");
        client.service.changeName(3,"orange");

        Person person = client.service.getById(1);
        System.out.println("Persoana cu id-ul = 1 este: " + person.getName());

        List<Person> persons = client.service.getPersons();
        System.out.println("All persons in the network: ");
        for(var it : persons){
            System.out.println(it.getName());
        }

        client.service.makeFriends("Mihai", "friend3");
        client.service.makeFriends("Ion", "friend1");
        client.service.makeFriends("Ana", "friend2");
        client.service.makeFriends("Mihai", "friend4");

        String name = "user2";
        List<Friends> friends = client.service.getFriendList(name);
        System.out.println("Friends of the user " + name + " are: ");
        for(var it : friends){
            System.out.println(it.getFriend());
        }

        int number = 2;
        List<Person> popular = client.service.getPopular(number);
        System.out.println("Top " + number + " most popular persons: ");
        for(var it : popular){
            System.out.println(it.getName());
        }

    }

}

