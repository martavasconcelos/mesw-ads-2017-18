package hot;

import hot.compositesingleton.Rooms;
import hot.devices.Device;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class RoomFactory implements Rooms {

    private final List<Device> devices = new ArrayList<>();

    //template method
    public RoomFactory(){
        Device device1 = makeDevice();
        Device device2 = makeDevice();
        device1.turnOn();
        device2.turnOn();
        devices.add(device1);
        devices.add(device2);
    }

    public List<Device> getDevices() {
        return devices;
    }

     abstract protected Device makeDevice();

    protected void listDevices(){
        for (Device device: devices) {
            System.out.println(device.getClass().toString());
            System.out.println(device.toString());
            System.out.println(device.isOn());
            System.out.println("------------");
        }
    }


    @Override
    public void turnOn() {
        for(int i = 0; i < this.getDevices().size(); i++){
            Device device = this.getDevices().get(i);
            if(device.getClass().getName().equals( "Lamp"))
                device.turnOn();

        }
    }

    @Override
    public void turnOff() {
        for(int i = 0; i < this.getDevices().size(); i++){
            Device device = this.getDevices().get(i);
            if(device.getClass().getName().equals( "Lamp"))
                device.turnOff();
        }
    }


}
