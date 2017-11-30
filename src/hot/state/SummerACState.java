package hot.state;

import hot.devices.AC;

public class SummerACState implements ACState {

    private final double targetTemperature = 15;

    @Override
    public void setTargetTemperature() {
        System.out.println("Turning on AC on Summer mode. Initial temperature: " + targetTemperature);
    }

    @Override
    public void turnOff(AC ac) {
        System.out.println("Turning off");
        ac.setState(new ChristmasACState());
    }

}
