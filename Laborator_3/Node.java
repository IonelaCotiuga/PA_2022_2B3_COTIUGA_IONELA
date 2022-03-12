package lab3;

public abstract class Node implements Comparable<Node>{
    private String name;
    private String address;
    private String location;

    public Node(String name, String address, String location) {
        this.name = name;
        this.address = address;
        this.location = location;
        //this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

  /*  public void setCost(Node node, int value) {
        cost.put(node, value);
    }*/

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                //", cost=" + cost +
                '}';
    }

}
