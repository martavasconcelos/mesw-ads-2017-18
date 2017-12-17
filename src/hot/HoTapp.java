package hot;

import java.awt.EventQueue;

import javax.swing.*;

import hot.Mediator.*;
import hot.command.*;
import hot.compositesingleton.Composite;
import hot.compositesingleton.House;
import hot.devices.*;
import hot.rooms.Bedroom;
import hot.rooms.Kitchen;
import hot.ui.Dashboard;

import java.awt.BorderLayout;

public class HoTapp {
    //strategy method
    public static int numberOfDevices=0;
    public static Mode mode = new Mode();
    private JFrame frame;
    public static JLabel label = new JLabel("");
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                HoTapp window = new HoTapp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * Create the application.
     */
    public HoTapp() throws InterruptedException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()  {
        //factory method
        RoomFactory bedroom = new Bedroom();
        RoomFactory kitchen = new Kitchen();
        bedroom.listDevices();
        kitchen.listDevices();
        mode.initalize();


        //composite singleton method
        Composite c= new Composite();
        House.add(kitchen);



        //Command
        TV newTV = TVRemote.getTV();

        TurnOn onCommand = new TurnOn(newTV);
        Button onPressed = new Button(onCommand);
        onPressed.press();

        TurnVolumeUP upCommand = new TurnVolumeUP(newTV);
        Button upPressed = new Button(upCommand);
        upPressed.press();

        TurnVolumeDown downCommand = new TurnVolumeDown(newTV);
        Button downPressed = new Button(downCommand);
        downPressed.press();

        TurnOff offCommand = new TurnOff(newTV);
        Button offPressed = new Button(offCommand);
        offPressed.press();

        //Mediator
        DoorLockMediator mediator = new MediatorImpl();
        DoorLock doorLock1 = new DoorLockImpl(mediator, "Front Door" );
        mediator.addDoor(doorLock1);
        doorLock1.turnOn();

        DoorLock doorLock2 = new DoorLockImpl(mediator,"Back Door" );
        mediator.addDoor(doorLock2);
        doorLock2.turnOn();

        DoorLock doorLock3 = new DoorLockImpl(mediator,"Kitcken Door" );
        mediator.addDoor(doorLock3);
        doorLock3.turnOn();
        doorLock2.turnOff();
        doorLock3.turnOff();


        if(doorLock1.isOn()){
            System.out.println("\nFront door was locked!\n");
            doorLock2.turnOn();
            doorLock3.turnOn();
        }



        //state method
        final AC ac = new AC();
        ac.turnOn();
        ac.turnOff();
        ac.turnOn();
        ac.turnOff();


        frame = new JFrame();
        frame.setBounds(100, 100, 420, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dashboard dashboard = new Dashboard();
        frame.getContentPane().add(dashboard.getPanel(), BorderLayout.CENTER);

        dashboard.add(new Color_Lamp(), 0, 0, 2, 1);
        dashboard.add(new Lamp(), 0, 1, 1, 1);
        dashboard.add(new Lamp(), 0, 2, 1, 1);
        dashboard.add(new Lamp(), 0, 3, 1, 1);
        dashboard.add(new Lamp(), 1, 1, 1, 1);
        dashboard.add(new Lamp(), 1, 2, 1, 1);
        dashboard.add(new Lamp(), 1, 3, 1, 1);
        //dashboard.add(new Lamp(), 2, 0, 2, 2);
        dashboard.add(new Lamp(), 2, 2, 1, 1);
        dashboard.add(new Lamp(), 2, 3, 1, 1);
        dashboard.add(new Lamp(), 2, 0, 1, 1);
        dashboard.add(new DimmableLamp(), 2, 1, 1, 1);
        dashboard.add(new Radio(), 4, 0, 4, 1);
        dashboard.add(new NullDevice(), 4, 2, 4, 1);
        dashboard.add(new Mode(), 4, 3, 4, 1);
        dashboard.add(new Kitchen().getPanel(), 4, 1, 2, 1);
        dashboard.add(label, 0, 4, 6, 1);

    }

}
