package com.example.lab11consumer;

import org.springframework.boot.web.client.RestTemplateBuilder;

public class Client {

    public MyService service;

    public Client(){

        service = new MyService(new RestTemplateBuilder());
    }


}