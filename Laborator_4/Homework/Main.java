package lab4;

import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.IntStream;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.jgrapht.util.SupplierUtil;

public class Main {
    public static void main(String[] args) {
        // declare the intersections
        var nodes = IntStream.rangeClosed(0,8).mapToObj(i -> new Intersection("v" +i )).toArray(Intersection[]::new);
        int[] length = {2,2,2,3,2,2,2,1,3,1,2,1,1,1,3,1};

        // List of the intersections adjacent to each street
        List<List<Intersection>> listList1=new ArrayList<>();
        listList1.add(Arrays.asList(nodes[0], nodes[1]));
        listList1.add(Arrays.asList(nodes[0], nodes[2]));
        listList1.add(Arrays.asList(nodes[0], nodes[3] ));
        listList1.add(Arrays.asList(nodes[1],nodes[4]));
        listList1.add(Arrays.asList( nodes[1], nodes[2] ));
        listList1.add(Arrays.asList(nodes[2], nodes[5]));
        listList1.add(Arrays.asList(nodes[2], nodes[6]));
        listList1.add(Arrays.asList(nodes[2], nodes[3]));
        listList1.add(Arrays.asList(nodes[3], nodes[6]));
        listList1.add(Arrays.asList(nodes[4], nodes[7]));
        listList1.add(Arrays.asList(nodes[4], nodes[8]));
        listList1.add(Arrays.asList(nodes[4], nodes[6]));
        listList1.add(Arrays.asList(nodes[5], nodes[7]));
        listList1.add(Arrays.asList(nodes[5], nodes[8]));
        listList1.add(Arrays.asList(nodes[6], nodes[8]));
        listList1.add(Arrays.asList(nodes[7], nodes[8]));

        // declare streets (name, length, list of intersections)
        var streets = IntStream.rangeClosed(0, 15)
                .mapToObj(i -> new Street("street" + i, length[i],listList1.get(i)))
                .toArray(Street[]::new);

        // Create a list of streets
        ArrayList<Street> arrayList = new ArrayList<>(Arrays.asList(streets));
        LinkedList<Street> streetsList = new LinkedList<>();
        for(Street street : arrayList){
            streetsList.add(street);
        }

        // sort streets by the length
        Collections.sort(streetsList, Comparator.comparing(Street::getLength));

        /*for(Street s : streetsList){
            System.out.println(s);
        }*/

        // Create a set of intersections
        Set<Intersection> intersectionSet = new HashSet<>();
        for(Intersection node : nodes){
            if(node.compareByName(intersectionSet, node)) {
                intersectionSet.add(node);
            }
        }

        // add the streets to every intersection
        for(Street street : streets){
            Intersection node1 = street.getListIntersection().get(0);
            Intersection node2 = street.getListIntersection().get(1);

            node1.addList(street);
            node2.addList(street);
        }

        // Create a class that describes the city.
        City cityMap = new City(streetsList, intersectionSet);


        int value = 2;
        System.out.println("Streets that that are longer then " + value + " and join at least 3 streets :");
        Arrays.stream(streets)
                .filter(element -> element.getLength() >= value && (element.getListIntersection().get(0).getAllStreetsInInters().size()+ element.getListIntersection().get(1).getAllStreetsInInters().size() >= 3)).forEach(System.out::println);

        // display an MST using the algorithm
        MST t = new MST(intersectionSet.size());

        int graph[][] = new int[][]{
                {0,2,2,2,0,0,0,0,0},
                {2,0,2,0,3,0,0,0,0},
                {2,2,0,1,0,2,2,0,0},
                {2,0,1,0,0,0,3,0,0},
                {0,3,0,0,0,0,1,1,2},
                {0,0,2,0,0,0,0,1,1},
                {0,0,2,3,1,0,0,0,3},
                {0,0,0,0,1,1,0,0,1},
                {0,0,0,0,2,1,3,1,0}
        };
        System.out.println("MST created using the algorithm:");
        t.primMST(graph);

        // display an MST using org.jgrapht.alg.spanning package
        Graph<String, DefaultWeightedEdge> graph2 = GraphTypeBuilder
                .undirected()
                .weighted(true)
                .allowingMultipleEdges(false)
                .allowingSelfLoops(false)
                .vertexSupplier(SupplierUtil.createStringSupplier())
                .edgeSupplier(SupplierUtil.createDefaultWeightedEdgeSupplier())
                .buildGraph();

        // convert Intersection to String
        for(Intersection node: intersectionSet){
            String newNode = String.valueOf(node);
            graph2.addVertex(newNode);
        }

        // convert Street to DefaultWeightedEdge and set the edge weight
        for(Street street:streetsList){
            Intersection node1 = street.getListIntersection().get(0);
            Intersection node2 = street.getListIntersection().get(1);

            String node1String = String.valueOf(node1);
            String node2String = String.valueOf(node2);

            DefaultWeightedEdge streetTmp = graph2.addEdge(node1String, node2String);

            double lengthTmp = street.getLength();
            graph2.setEdgeWeight(streetTmp, lengthTmp);
        }

        System.out.println("MST created using the package of JGraphT:");
        for(DefaultWeightedEdge e: new PrimMinimumSpanningTree<>(graph2).getSpanningTree()) {
            System.out.println(e);
        }


        // generate random fake names for intersections and streets
        System.out.println("Generate random fake names for intersections and streets:");
        Faker faker = new Faker();

        for(Intersection node: intersectionSet){
            node.setName(faker.name().firstName());
        }

        for(Intersection node: intersectionSet){
            System.out.println("new name node = " + node.getName());
        }

        System.out.println();

        for(Street street: streetsList){
            street.setName(faker.name().firstName());
        }

        for(Street street: streetsList){
            System.out.println("new name street = " + street.getName());
        }


    }
}
