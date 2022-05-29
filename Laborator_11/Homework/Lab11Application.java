package com.example.lab11;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@OpenAPIDefinition
//@EnableSwagger2
public class Lab11Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab11Application.class, args);

    }

}
