package hot.state;

import hot.devices.AC;

public interface ACState {
    void setTargetTemperature();
    void turnOff(AC ac);
}
