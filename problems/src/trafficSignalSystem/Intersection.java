package trafficSignalSystem;

import java.util.HashMap;

public class Intersection {
    private final String intersectionId;
    private String intersectionName;
    private HashMap<String, Road> roadsMap = new HashMap<>();

    public Intersection(String intersectionId, String intersectionName) {
        this.intersectionId = intersectionId;
        this.intersectionName = intersectionName;
    }

    public String getIntersectionId() {
        return intersectionId;
    }

    public String getIntersectionName() {
        return intersectionName;
    }

    public void setIntersectionName(String intersectionName) {
        this.intersectionName = intersectionName;
    }

    public void createRoad(String roadId, String roadName) {
        Road road = new Road(roadId, roadName);
        roadsMap.put(roadId, road);
    }

    public HashMap<String, Road> getAllRoads() {
        return roadsMap;
    }

    public synchronized void getStatus() {
        System.out.println("Intersection Name: " + intersectionName);
        for(Road road: roadsMap.values()){
            System.out.println(road.getRoadName() + ": " + road.trafficSignal.getCurrentSignal());
        }
    }
}
