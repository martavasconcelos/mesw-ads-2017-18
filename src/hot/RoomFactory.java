package hot;

import hot.devices.Device;

import java.util.ArrayList;
import java.util.List;

public abstract class RoomFactory {

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

     abstract protected Device makeDevice();

    protected void listDevices(){
        for (Device device: devices) {
            System.out.println(device.getClass().toString());
            System.out.println(device.toString());
            System.out.println(device.isOn());
            System.out.println("------------");
        }
    }

}
