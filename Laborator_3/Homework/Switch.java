package lab3;

import java.util.Map;

public class Switch extends Node{
    public Switch(String name, String address, String location) {
        super(name, address, location);
    }

    public Switch(String name, String address, String location, Map<Node, Integer> cost) {
        super(name, address, location, cost);
    }

    @Override
    public String toString() {
        return "Switch{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", location='" + getLocation() + '\'' +
                '}';
    }
}
