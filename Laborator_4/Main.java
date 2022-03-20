package lab4;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        var nodes = IntStream.rangeClosed(0,8).mapToObj(i -> new Intersection("v" +i )).toArray(Intersection[]::new);

        Street v0v1 = new Street("v0v1", 2);
        Street v0v2 = new Street("v0v2", 2);
        Street v0v3 = new Street("v0v3", 2);
        Street v1v4 = new Street("v1v4", 3);
        Street v1v2 = new Street("v1v2", 2);
        Street v2v5 = new Street("v2v5", 2);
        Street v2v6 = new Street("v2v6", 2);
        Street v2v3 = new Street("v2v3", 1);
        Street v3v6 = new Street("v3v6", 3);
        Street v4v7 = new Street("v4v7", 1);
        Street v4v8 = new Street("v4v8", 2);
        Street v4v6 = new Street("v4v6", 1);
        Street v5v7 = new Street("v5v7", 1);
        Street v5v8 = new Street("v5v8", 1);
        Street v6v8 = new Street("v6v8", 3);
        Street v7v8 = new Street("v7v8", 1);


        ArrayList<Street> arrayList = new ArrayList<>(Arrays.asList(v0v1,v0v2,v0v3,v1v4,v1v2,v2v5,v2v6,v2v3,v3v6,v4v7,v4v8,v4v6,v5v7,v5v8,v6v8,v7v8));
        LinkedList<Street> streetsList = new LinkedList<>();

        for(Street street : arrayList){
            streetsList.add(street);
        }

        Collections.sort(streetsList, Comparator.comparing(Street::getLength));

        for(Street s : streetsList){
            System.out.println(s);
        }

        Set<Intersection> intersectionSet = new HashSet<>();

        for(Intersection node : nodes){
            if(node.compareByName(intersectionSet, node)) {
                intersectionSet.add(node);
            }
        }

        for(Intersection ins : intersectionSet){
            System.out.println(ins);
        }

    }
}
