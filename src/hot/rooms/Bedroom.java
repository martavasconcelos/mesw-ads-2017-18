package hot.rooms;

import hot.DeviceFactory;
import hot.RoomFactory;
import hot.devices.AC;
import hot.devices.Device;
import hot.devices.Lamp;

public class Bedroom extends RoomFactory {
    @Override
    protected Device makeDevice() {
        AC ac = (AC) DeviceFactory.create("AC");
        return ac;
    }
}
