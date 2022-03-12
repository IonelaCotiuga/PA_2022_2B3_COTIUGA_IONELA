package lab3;

public class Computer extends Node implements Identifiable, Storage {
    private String addressIp;
    private int storageCapacity;

    public Computer(String name, String address, String location, String address1, int storageCapacity) {
        super(name, address, location);
        this.addressIp = address1;
        this.storageCapacity = storageCapacity;
    }


    @Override
    public String getAddressIp() {
        return addressIp;
    }

    public void setAddress(String address) {
        this.addressIp = address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", addressIp='" + addressIp + '\'' +
                ", storageCapacity=" + storageCapacity +
                '}';
    }

}
