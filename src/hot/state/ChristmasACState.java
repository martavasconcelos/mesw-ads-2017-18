package hot.state;

import hot.devices.AC;

public class ChristmasACState implements ACState {

    private final double targetTemperature = 22;

    @Override
    public void setTargetTemperature() {
        System.out.println("Turning on AC on Xmas mode. Initial temperature: " + targetTemperature);
    }

    @Override
    public void turnOff(AC ac) {
        System.out.println("Turning off");
        ac.setState(new SummerACState());
    }

}
