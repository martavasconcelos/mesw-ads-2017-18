package hot.devices;

public interface ACState {
    void turnOn(AC ac);
    void turnOff(AC ac);
    double getOnMinTemperature(AC ac);
}
