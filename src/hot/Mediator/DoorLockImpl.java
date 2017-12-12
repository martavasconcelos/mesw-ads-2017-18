package hot.Mediator;

import hot.devices.DoorLock;

public class DoorLockImpl extends DoorLock{

    public DoorLockImpl(DoorLockMediator med, String name) {
        super(med, name);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println(this.name + " is Locked ");
        mediator.changeDoorState(this);
    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println(this.name + " is Unlocked ");
        mediator.changeDoorState(this);
    }
}
