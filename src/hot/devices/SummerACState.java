package hot.devices;

public class SummerACState implements ACState {

    private final double onMinTemperature = 15;

    @Override
    public void turnOn(AC ac) {
        System.out.println("Turning on AC on Summer mode. Initial temperature: " + getOnMinTemperature(ac));
    }

    @Override
    public void turnOff(AC ac) {
        System.out.println("Turning off");
        ac.setState(new ChristmasACState());
    }

    @Override
    public double getOnMinTemperature(AC ac) {
        return onMinTemperature;
    }
}
