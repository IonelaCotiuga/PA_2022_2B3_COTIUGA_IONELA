package lab3;

import java.util.Map;

public class Router extends Node implements Identifiable{
    private String addressIp; // IP

    public Router(String name, String address, String location, String addressIp) {
        super(name, address, location);
        this.addressIp = addressIp;
    }

    public Router(String name, String address, String location, String addressIp, Map<Node, Integer> cost) {
        super(name, address, location, cost);
        this.addressIp = addressIp;
    }


    @Override
    public String getAddressIp() {
        return addressIp;
    }

    public void setAddress(String address) {
        this.addressIp = address;
    }

    @Override
    public String toString() {
        return "Router{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", addressIp='" + addressIp + '\'' +
                '}';
    }
}
