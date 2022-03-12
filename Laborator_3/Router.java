package lab3;

public class Router extends Node implements Identifiable{
    private String addressIp; // IP

    public Router(String name, String address, String location, String address1) {
        super(name, address, location);
        this.addressIp = address1;
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
