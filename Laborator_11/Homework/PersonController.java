package com.example.lab11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final List<Person> persons = new ArrayList<>();
    Connect connect = new Connect();
    public PersonController() {
    }
    @GetMapping
    public List<Person> getPersons() {
        return connect.get();
    }
    @GetMapping("/count")
    public int countPersons() {
        return connect.getCount();
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return connect.findById(id);
    }

    @PostMapping
    public String createPerson(@RequestParam String name) {
        connect.create(new Person(name));
        return "Person created successfully";
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createPerson(@RequestBody Person person) {
        persons.add(person);
        connect.create(person);
        return new ResponseEntity<>(
                "Person created successfully", HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(
            @PathVariable int id, @RequestParam String name) {
        Person person = connect.findById(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.NOT_FOUND); //or GONE
        }
        person.setName(name);
        connect.update(name, id);
        return new ResponseEntity<>(
                "Person updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        Person person = connect.findById(id);
        if (person == null) {
            return new ResponseEntity<>(
                    "Person not found", HttpStatus.GONE);
        }
        persons.remove(person);
        connect.delete(person.getId());
        return new ResponseEntity<>("Product removed", HttpStatus.OK);
    }

}

// http://localhost:90/swagger-ui/index.html

