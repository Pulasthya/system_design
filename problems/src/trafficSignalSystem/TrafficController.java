package trafficSignalSystem;

import java.util.HashMap;

public class TrafficController {
    private final static TrafficController instance = new TrafficController();
    private HashMap<String, Intersection> interstionMap = new HashMap<>();
    private static final Object consoleLock = new Object();

    private TrafficController() {};

    public static TrafficController getInstance() {
        return instance;
    }

    public void createIntersection(String intersectionId, String intersectionName) {
        Intersection intersection = new Intersection(intersectionId, intersectionName);
        interstionMap.put(intersectionId, intersection);
    }

    public HashMap<String, Intersection> getAllIntersections() {
        return interstionMap;
    }

    public Intersection getIntersection(String intersectionId) {
        return interstionMap.get(intersectionId);
    }

    public void startTrafficControl() {
        for(Intersection intersection: interstionMap.values()){
//            System.out.println("Intersection Name: " + intersection.getIntersectionName());
            new Thread(()-> {
                for (Road road: intersection.getAllRoads().values()){
                    try {
                        Thread.sleep(road.trafficSignal.getRedDuration());
                        road.trafficSignal.setCurrentSignal(SignalType.GREEN);
                        synchronized (consoleLock){
                            intersection.getStatus();
                        }
                        Thread.sleep(road.trafficSignal.getGreenDuration());
                        road.trafficSignal.setCurrentSignal(SignalType.YELLOW);
                        synchronized (consoleLock){
                            intersection.getStatus();
                        }
                        Thread.sleep(road.trafficSignal.getYellowDuration());
                        road.trafficSignal.setCurrentSignal(SignalType.RED);
                        synchronized (consoleLock){
                            intersection.getStatus();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ).start();
        }
    }
}
