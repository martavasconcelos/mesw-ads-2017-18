package hot.Mediator;

import hot.devices.DoorLock;

public interface DoorLockMediator {

    public void changeDoorState(DoorLock doorLock);

    void addDoor(DoorLock doorLock);
}