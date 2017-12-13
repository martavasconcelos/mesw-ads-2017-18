package hot.devices;

import hot.HoTapp;
import hot.state.ACState;
import hot.state.ChristmasACState;

public class AC extends Device {
	private ACState acState = new ChristmasACState();
	private int targetTemperature = 10;
	private int ambientTemperature = 10;

	public void setState(final ACState newState) {
		acState = newState;
	}

	public void setTemperature(int t) {
		targetTemperature = t;
	}

	public int getTemperature() {
		return ambientTemperature;
	}

	public void turnOn(){
		super.turnOn();
		acState.setTargetTemperature();
	}

	@Override
	public void turnOff() {
		super.turnOff();
		acState.turnOff(this);
	}


}
