package hot.state;

import hot.devices.AC;

public interface ACState {
    void turnOn(AC ac);
    void turnOff(AC ac);
    double getOnMinTemperature(AC ac);
}
