package lab2;

public class LectureHall extends Room{
    String videoProjector;
    public LectureHall(String name, TypeEnum type, int capacity) {
        super(name, type, capacity);
    }
    public LectureHall(String name, TypeEnum type, int capacity, String property) {
        super(name, type, capacity, property);
    }


    @Override
    public String toString() {
        if(property != null) {
            return "LectureHall{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    ", type=" + type +
                    ", property='" + property + '\'' +
                    '}';
        }
        else {
            return "LectureHall{" +
                    "name='" + name + '\'' +
                    ", capacity=" + capacity +
                    ", type=" + type +
                    '}';
        }
    }
}