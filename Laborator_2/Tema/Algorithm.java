package lab2;

import java.util.Arrays;
import java.util.HashMap;

public class Algorithm {
    Problem pb;

    public Algorithm(Problem newProblem) {
        this.pb = newProblem;
    }

    public Problem getPb() {
        return pb;
    }

    public void setPb(Problem pb) {
        this.pb = pb;
    }

    public Event[] sortByFinalTime(Event[] events){
        for (int i = 0; i < events.length; i++) {
            for (int j = i+1; j < events.length; j++)
                if(events[i] != null && events[j] != null) {
                    if (events[i].getEndTime() > events[j].getEndTime()) {
                        Event temp = events[i];
                        events[i] = events[j];
                        events[j] = temp;
                    }
                }
        }
        return events;
    }

    public Room[] sortByRoomSize(Room[] rooms){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = i+1; j < rooms.length; j++) {
                if(rooms[i] != null && rooms[j] != null){
                    if(rooms[i].getCapacity() > rooms[j].getCapacity()){
                        Room temp = rooms[i];
                        rooms[i] = rooms[j];
                        rooms[j] = temp;
                    }
                }
            }
        }
        return rooms;
    }

    public boolean isAvailable(Event eventToBeScheduled, Event lastEvent){
        return lastEvent == null || eventToBeScheduled.getStartTime() >= lastEvent.getEndTime(); // return true
    }

    public Solution solve(){
        Event[] sortEvents = sortByFinalTime(pb.getEvents());
        Room[] sortRooms = sortByRoomSize(pb.getRooms());
        pb.setEvents(sortEvents);
        pb.setRooms(sortRooms);


        Room[] assignment = new Room[pb.getEvents().length];
        HashMap<Room ,Event> eventsInRoom = new HashMap<>();
        int indexEvent = 0;

        // verifica ultimul eveniment programat in acea camera
        // se verifica daca sala are capacitate pt nr participanti

        for(Event event : pb.getEvents()){
            int roomAvailable = 0;
            for(Room room : pb.getRooms()){
                if(event != null && room != null) {
                    if(event.getNrParticipants() <= room.getCapacity() && isAvailable(event, eventsInRoom.get(room))){
                        eventsInRoom.put(room, event);
                        assignment[indexEvent++] = room;
                        roomAvailable = 1;
                        break;
                    }
                }
            }
            if(roomAvailable == 0){ // nu exista camera disponibila pt evenimentul propus
                Room emptyRoom = new Room(("no available room")) {
                };
                assignment[indexEvent++] = emptyRoom;
            }
        }
        Solution solution = new Solution(assignment);
        return  solution;

    }
    // se primeste lista cu evenimente si cu camere si trebuie algoritm
    // pt a atribui cate o camera fiecarui eveniment, in functie de ora evenimentelor -- minimazare


    @Override
    public String toString() {
        return "Algorithm{" +
                "pb=" + pb +
                '}';
    }
}
