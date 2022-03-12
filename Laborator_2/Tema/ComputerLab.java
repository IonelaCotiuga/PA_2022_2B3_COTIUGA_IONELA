package lab2;

public class ComputerLab extends Room{
    public ComputerLab(String name, TypeEnum type, int capacity) {
        super(name, type, capacity);
    }

    public ComputerLab(String name, TypeEnum type, int capacity, String operatingSystem) {
        super(name, type, capacity, operatingSystem);
    }

    @Override
    public String toString() {
        if(property != null) {
            return "ComputerLab{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    ", type=" + type +
                    ", property='" + property + '\'' +
                    '}';
        }
        else {
            return "ComputerLab{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    ", type=" + type +
                    '}';
        }
    }


}
