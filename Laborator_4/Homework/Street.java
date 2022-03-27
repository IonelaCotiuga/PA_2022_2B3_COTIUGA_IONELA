package lab4;

import java.util.List;

public class Street {
    private String name;
    private int length;
    private List<Intersection> listIntersection;

    public Street(String name, int length, List<Intersection> list) {
        this.name = name;
        this.length = length;
        this.listIntersection = list;
    }

    public List<Intersection> getListIntersection() {
        return listIntersection;
    }

    public void setListIntersection(List<Intersection> listIntersection) {
        this.listIntersection = listIntersection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", listIntersection=" + listIntersection.get(0).getName() + ", " + listIntersection.get(1).getName() +
                '}';
    }
}
