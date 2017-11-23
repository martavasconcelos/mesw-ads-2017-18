package hot.rooms;

import hot.DeviceFactory;
import hot.RoomFactory;
import hot.devices.Device;
import hot.devices.Lamp;

public class Kitchen extends RoomFactory {
    @Override
    protected Device makeDevice() {
        Lamp lamp = (Lamp) DeviceFactory.create("Lamp");
        return lamp;
    }
}
