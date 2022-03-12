package lab2;

/**
 * commentss in Solution
 */

public class Solution {
    private Room[] assignment;

    public Solution(Room[] assignment) {
        this.assignment = assignment;
    }

    public Room[] getAssignment() {
        return assignment;
    }

    public StringBuilder computeUsedRooms(Event[] events){
        StringBuilder result = new StringBuilder();
        result.append("Solution{");
        for (int i = 0; i < events.length; i++) {
            if(events[i] != null) {
                result.append(events[i].getName());
                result.append(" -> ");
                result.append(assignment[i].getName());
                result.append(", ");
            }
        }
        result.append("}");
        return result;
    }


}
