package trafficSignalSystem;

public class TrafficControllerDemo {
    public static void run() {
        TrafficController trafficController = TrafficController.getInstance();
        trafficController.createIntersection("I1", "Nagarbhavi");
        trafficController.getIntersection("I1").createRoad("R1", "Road1");
        trafficController.getIntersection("I1").createRoad("R2", "Road2");
        trafficController.getIntersection("I1").createRoad("R3", "Road3");

        trafficController.createIntersection("I2", "Nayandahalli");
        trafficController.getIntersection("I2").createRoad("R1", "Road1");
        trafficController.getIntersection("I2").createRoad("R2", "Road2");
        trafficController.getIntersection("I2").createRoad("R3", "Road3");

        trafficController.startTrafficControl();
    }
}
