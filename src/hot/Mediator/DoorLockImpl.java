package hot.Mediator;

import hot.HoTapp;
import hot.devices.DoorLock;

public class DoorLockImpl extends DoorLock{

    public DoorLockImpl(DoorLockMediator med, String name) {
        super(med, name);
    }

    @Override
    public void turnOn() {
        super.turnOn();
        System.out.println(this.name + " is Locked \n");
        mediator.changeDoorState(this);

    }

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println(this.name + " is Unlocked\n ");
        mediator.changeDoorState(this);
    }
}
