package hot.Mediator;

import hot.devices.DoorLock;

import java.util.ArrayList;
import java.util.List;

public class MediatorImpl implements DoorLockMediator {

    private List<DoorLock> doors;

    public MediatorImpl(){
        this.doors=new ArrayList<>();
    }


    @Override
    public void changeDoorState(DoorLock doorLock) {

    }

    @Override
    public void addDoor(DoorLock doorLock) {

        this.doors.add(doorLock);

    }
}