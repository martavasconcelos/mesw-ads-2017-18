package hot.devices;

import javax.swing.*;

public class TV extends Device{

    private int volume =50;

    public void volumeUp(){
        volume++;
        System.out.println("TV Volume is at " + volume +" volume\n");
    }

    public void volumeDown(){
        volume--;
        System.out.println("TV Volume is at " + volume +" volume\n");
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println("TV is ON \n");

    }

    @Override
    public void turnOff() {
        super.turnOff();

        System.out.println("TV is OFF\n ");
    }
}
