package com.example.lab11;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/friends")
public class FriendsController {
    private final List<Friends> friends = new ArrayList<>();
    Connect connect = new Connect();
    public FriendsController() {
    }

    @GetMapping("{name}")
    public List<Friends> getFriends(@PathVariable("name") String name) {
        return connect.getFriendsByName(name);
    }

    @GetMapping("/count/{name}")
    public int getCountByName(@PathVariable("name") String name) {
        return connect.countByName(name);
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


    @GetMapping("mostPopular/{nr}")
    public List<Person> getPopularPersons(@PathVariable("nr") int nr){
        Map<String, Integer> map = new HashMap<String, Integer>(); // persoana, nr prieteni
        int number = 1;

        List<Person> list = connect.get();
        for(Person person: list){
            int nrFriends = connect.countByName(person.getName()); // numara nr de prieteni ai unei persoane
            map.put(person.getName(), nrFriends); // (persoana, nr prieteni) (user, 3), (user2, 1)
        }

        map = sortByValue((HashMap<String, Integer>) map);

        List<Person> firsKPopular = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            firsKPopular.add(connect.findByName(entry.getKey()));
            if(number >= nr){
                break;
            }
            number++ ;
        }
        return firsKPopular;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    createFriends(@RequestBody Friends friend) {
        friends.add(friend);
        connect.createFriend(friend);
        return new ResponseEntity<>(
                "Friend created successfully", HttpStatus.CREATED);
    }


}

