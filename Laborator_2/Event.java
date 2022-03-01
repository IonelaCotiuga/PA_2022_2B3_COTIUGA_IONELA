package lab2Compulsory;

public class Event {
    protected String name;
    protected int nrParticipants;
    protected int startTime;
    protected int endTime;

    public Event(String name, int nrParticipants, int startTime, int endTime) {
        this.name = name;
        this.nrParticipants = nrParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrParticipants() {
        return nrParticipants;
    }

    public void setNrParticipants(int nrParticipants) {
        this.nrParticipants = nrParticipants;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", nrParticipants=" + nrParticipants +
                ", StartTime=" + startTime +
                ", EndTime=" + endTime +
                '}';
    }
}
