package lab3;

import java.util.*;
import java.util.Map.Entry;

public class Algorithm {
    Network nodes;
    Node source;

    public Algorithm(Network nodes, Node source) {
        this.nodes = nodes;
        this.source = source;
    }

    /*public Network getNodes() {
        return nodes;
    }

    public void setNodes(Network nodes) {
        this.nodes = nodes;
    }*/

    public void resolve(){
        List<Node> visitedNodes = new ArrayList<>();
        List<Node> unvisitedNodes = new ArrayList<>();

        unvisitedNodes.add(this.source);

        while (unvisitedNodes.size() != 0){
            Node currentNode = getLowestDistanceNode(unvisitedNodes);
            unvisitedNodes.remove(currentNode);
        }

    }

    public static Node getLowestDistanceNode(List<Node> unvisitedNodes){
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unvisitedNodes){
            Map<Node, Integer> nodeDistance = node.getCost();
            int distance = nodeDistance.get(node);
            if(distance < lowestDistance){
                lowestDistance = distance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }


}
