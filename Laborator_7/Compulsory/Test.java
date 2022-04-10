package lab7;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        // Creating an empty HashMap
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

        // Mapping string values to int keys
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);

        System.out.println("marimea inainte = " + hash_map.size());
        // Removing the existing key mapping
        String returned_value = (String)hash_map.remove(30);

        // Verifying the returned value
        System.out.println("Returned value is: "+ returned_value);

        // Displaying the new map
        System.out.println("New map is: "+ hash_map);

        System.out.println("marimea dupa = " + hash_map.size());
    }
    }

