package hot.devices;

public class ChristmasACState implements ACState {

    private final double onMinTemperature = 22;

    @Override
    public void turnOn(AC ac) {
        System.out.println("Turning on AC on Xmas mode. Initial temperature: " + getOnMinTemperature(ac));
    }

    @Override
    public void turnOff(AC ac) {
        System.out.println("Turning off");
        ac.setState(new SummerACState());
    }

    @Override
    public double getOnMinTemperature(AC ac) {
        return onMinTemperature;
    }
}
