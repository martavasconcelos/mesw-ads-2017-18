package hot.devices;

public class AC extends Device {
	private ACState acState = new ChristmasACState();
	private int targetTemperature = 10;
	private int ambientTemperature = 10;

	void setState(final ACState newState) {
		acState = newState;
	}

	public void setTemperature(int t) {
		targetTemperature = t;
	}

	public int getTemperature() {
		return ambientTemperature;
	}

	public void turnOn(){
		acState.turnOn(this);
	}

	public void turnOff(){
		acState.turnOff(this);
	}
}
