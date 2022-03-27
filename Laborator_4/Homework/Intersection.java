package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Intersection  {
    private String name;
    private List<Street> allStreetsInInters = new ArrayList<>();

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addList(Street street){
        allStreetsInInters.add(street);
    }

    public List<Street> getAllStreetsInInters(){
        return allStreetsInInters;
    }

    public boolean compareByName(Set<Intersection> nodes, Intersection node2){
        for(Intersection node : nodes){
            if(node.getName().compareTo(node2.getName()) == 0)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }
}

