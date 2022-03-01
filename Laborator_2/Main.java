package lab2Compulsory;

public class Main {
    public static void main(String[] args) {
        Event e1 = new Event("C1", 100, 8, 10);
        Event e2 = new Event("C2", 100, 10, 12);
        Event e3 = new Event("L1", 30, 8, 10);
        Event e4 = new Event("L2", 30, 8, 10);
        Event e5 = new Event("L3", 30, 10, 12);

        Room r1 = new Room("401", TypeEnum.LAB, 30);
        Room r2 = new Room("403", TypeEnum.LAB, 30);
        Room r3 = new Room("405", TypeEnum.LAB, 30);
        Room r4 = new Room("309", TypeEnum.LECTURE_HALLS, 100);

        System.out.println(e1 + "\n" + e2 + "\n" + e3 + "\n" + e4 + "\n" + e5);
        System.out.println(r1 + "\n" + r2 + "\n" + r3 + "\n" + r4);

    }
}
