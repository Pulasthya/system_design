package trafficSignalSystem;

public class TrafficSignal {
    private Integer redDuration, yellowDuration, greenDuration;
    private SignalType currentSignal;

    public TrafficSignal(Integer redDuration, Integer yellowDuration, Integer greenDuration){
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
        this.currentSignal = SignalType.RED;
    }

    public Integer getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(Integer greenDuration) {
        this.greenDuration = greenDuration;
    }

    public Integer getRedDuration() {
        return redDuration;
    }

    public void setRedDuration(Integer redDuration) {
        this.redDuration = redDuration;
    }

    public Integer getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(Integer yellowDuration) {
        this.yellowDuration = yellowDuration;
    }

    public SignalType getCurrentSignal() {
        return currentSignal;
    }

    public synchronized void setCurrentSignal(SignalType signalType) {
        this.currentSignal = signalType;
    }
}
