package lab3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }


    public void identifiableNodes(List<Node> nodes){
        List<Node> identifNodes = new ArrayList<>();
        for(int i = 0; i < nodes.size(); i++){
            Node n = nodes.get(i);
            if( n instanceof Computer  || n instanceof Router)
                identifNodes.add(n);
        }

        Collections.sort(identifNodes, new SortByIpAddress() {
            @Override
            public int compare(Node o1, Node o2) {
                return super.compare(o1, o2);
            }
        });

        for(Node n : identifNodes)
            System.out.println(n.getName() + " " + ((Identifiable) n).getAddressIp());
    }


    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

}
