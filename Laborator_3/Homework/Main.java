package lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        Computer computerA = new Computer("v1", "address1", "location1", "192.0.2.1", 100);
        Router routerA = new Router("v2", "address2", "location2", "192.158. 1.38");
        Switch switchA = new Switch("v3", "address3", "location3");
        Switch switchB = new Switch("v4", "address4", "location4");
        Router routerB = new Router("v5", "address5", "location5", "255.255.255.255");
        Computer computerB = new Computer("v6", "address6", "location6", "0.0.0.0", 200);

        computerA.setCost(computerA, 0);
        computerA.setCost(routerA,10);
        computerA.setCost(switchA,50);
        routerA.setCost(switchA,20);
        routerA.setCost(switchB,20);
        routerA.setCost(routerB,10);
        switchA.setCost(switchB,20);
        switchB.setCost(routerB,30);
        switchB.setCost(computerB,10);
        routerB.setCost(computerB,20);

        nodes.add(computerA);
        nodes.add(routerA);
        nodes.add(switchA);
        nodes.add(switchB);
        nodes.add(routerB);
        nodes.add(computerB);
        Network network = new Network(nodes);
        System.out.println(network);

        network.identifiableNodes(nodes);
        Algorithm alg = new Algorithm(network, computerA);

        //alg.resolve();

    }
}
