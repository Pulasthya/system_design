package trafficSignalSystem;

public class Road {
    private final String roadId;
    private String roadName;
    protected TrafficSignal trafficSignal;

    public Road (String roadId, String roadName) {
        this.roadId = roadId;
        this.roadName = roadName;
        trafficSignal = new TrafficSignal(3600, 900, 1800);
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }
}
