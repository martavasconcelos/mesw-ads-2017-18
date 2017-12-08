package hot;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
    public static int numberOfDevicesAllowed=6 ;
    private JFrame frame;

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


        //composite singleton method
        Composite c= new Composite();
        House.add(kitchen);




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
        dashboard.add(new Lamp(), 2, 0, 2, 2);
        dashboard.add(new Lamp(), 2, 2, 1, 1);
        dashboard.add(new Lamp(), 2, 3, 1, 1);
        dashboard.add(new Lamp(), 3, 2, 1, 1);
        dashboard.add(new DimmableLamp(), 3, 3, 1, 1);
        dashboard.add(new Radio(), 4, 0, 4, 1);
        dashboard.add(new NullDevice(), 4, 2, 4, 1);
        dashboard.add(new Saver(), 4, 3, 4, 1);
        dashboard.add(new Kitchen().getPanel(), 4, 1, 2, 1);
    }

}
