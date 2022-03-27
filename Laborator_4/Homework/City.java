package lab4;

import java.util.*;

public class City {

    LinkedList<Street> streetsList = new LinkedList<>();
    Set<Intersection> intersectionSet = new HashSet<>();

    public City(LinkedList<Street> streetsList, Set<Intersection> intersectionSet) {
        this.streetsList = streetsList;
        this.intersectionSet = intersectionSet;
    }

    public LinkedList<Street> getStreetsList() {
        return streetsList;
    }

    public void setStreetsList(LinkedList<Street> streetsList) {
        this.streetsList = streetsList;
    }

    public Set<Intersection> getIntersectionSet() {
        return intersectionSet;
    }

    public void setIntersectionSet(Set<Intersection> intersectionSet) {
        this.intersectionSet = intersectionSet;
    }


    @Override
    public String toString() {
        int i = 0;
        return "City{" +
                "streetsList=" + streetsList +
                ", intersectionSet=" + intersectionSet +
                '}';
    }
}
