package lab2;

/**
 * comments in Problems
 */

import java.util.Arrays;

public class Problem {
    private Event[] events;
    private Room[] rooms;
    public Problem(){

    }

    public Problem(Event[] e, Room[] r) {
        this.events = e;
        this.rooms = r;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "events=" + Arrays.toString(events) +
                "\n" +
                ", rooms=" + Arrays.toString(rooms) +
                '}';
    }

    static boolean addEvent(Event[] events, Event newEvent){
        for(Event event : events){
            if(newEvent.equals(event))
                return false;
        }
        return true;
    }

    static boolean addRoom(Room[] rooms, Room newRoom){
        for(Room room : rooms){
            if(newRoom.equals(room))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Event[] events = new Event[10];
        Room[] rooms = new Room[10];
        int indexEvent = 0;
        int indexRoom = 0;

        Event e1 = new Event("C1", 100, 8, 10);
        if(addEvent(events, e1)){
            events[indexEvent++] = e1;
        }

        Event e2 = new Event("C2", 100, 10, 12);
        if(addEvent(events, e2)){
            events[indexEvent++] = e2;
        }

        Event e3 = new Event("L1", 30, 8, 10);
        if(addEvent(events, e3)){
            events[indexEvent++] = e3;
        }
        Event e4 = new Event("L2", 30, 8, 10);
        if(addEvent(events, e4)){
            events[indexEvent++] = e4;
        }

        Event e5 = new Event("L3", 30, 10, 12);
        if(addEvent(events, e5)){
            events[indexEvent++] = e5;
        }

        /*//---------------
        Event e6 = new Event("L4", 30, 10, 12);
        if(addEvent(events, e6)){
            events[indexEvent++] = e6;
        }

        Event e7 = new Event("L5", 30, 10, 12);
        if(addEvent(events, e7)){
            events[indexEvent++] = e7;
        }

        Event e8 = new Event("L8", 30, 10, 12);
        if(addEvent(events, e8)){
            events[indexEvent++] = e8;
        }

        Event e9 = new Event("L9", 30, 8, 10);
        if(addEvent(events, e9)){
            events[indexEvent++] = e9;
        }
*/

        ComputerLab c1 = new ComputerLab("401", TypeEnum.LAB, 30, "Windows");
        if(addRoom(rooms, c1)){
            rooms[indexRoom++] = c1;
        }

        ComputerLab c2 = new ComputerLab("403", TypeEnum.LAB, 30, "Linux");
        if(addRoom(rooms, c2)){
            rooms[indexRoom++] = c2;
        }

        ComputerLab c3 = new ComputerLab("405", TypeEnum.LAB, 30, "MacOS");
        if(addRoom(rooms, c3)){
            rooms[indexRoom++] = c3;
        }

        LectureHall l4 = new LectureHall("309", TypeEnum.LECTURE_HALLS, 100);
        if(addRoom(rooms, l4)){
            rooms[indexRoom++] = l4;
        }


        Problem pb = new Problem();
        pb.setEvents(events);
        pb.setRooms(rooms);

        Algorithm greedy = new Algorithm(pb);
        events = greedy.sortByFinalTime(pb.getEvents()); // evenimentele sunt in ordinea crescatoare a timpului final

        Solution sol = greedy.solve();
        System.out.println(sol.computeUsedRooms(events));
        //System.out.println(greedy); // evenimentele si camerele sortate

    }

}
