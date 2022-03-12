package lab2;

import java.util.Objects;

enum TypeEnum{
    LAB,
    LECTURE_HALLS
}

public abstract class Room {
    protected String name;
    protected int capacity;
    protected  String property;
    TypeEnum type;

    public Room(String name, TypeEnum type, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public Room(String name) {
        this.name = name;
    }

    public Room(String name, TypeEnum type, int capacity, String property) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity, type);
    }


}
