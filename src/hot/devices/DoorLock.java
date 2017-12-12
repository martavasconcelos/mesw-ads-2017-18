package hot.devices;

import hot.Mediator.DoorLockMediator;

public abstract class DoorLock extends Device{

    protected DoorLockMediator mediator;
    protected String name;

    public DoorLock(DoorLockMediator med, String name){
        this.mediator=med;
        this.name=name;
    }


    @Override
    public void turnOn() {
        super.turnOn();
            }

    @Override
    public void turnOff() {
        super.turnOff();
    }
}
