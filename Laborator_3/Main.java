package lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        Computer c1 = new Computer("v1", "address1", "location1", "addIP1", 100);
        nodes.add(0, c1);

        Router r1 = new Router("v2", "address2", "location2", "addIP2");
        nodes.add(1, r1);

        Network network = new Network(nodes);
        System.out.println(network);

    }
}
