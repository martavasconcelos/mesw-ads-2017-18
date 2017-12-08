package hot;

import hot.compositesingleton.Composite;
import hot.compositesingleton.Rooms;
import hot.devices.Device;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class RoomFactory implements Rooms {

    private final List<Device> devices = new ArrayList<>();
    private boolean isOn = false;
    //template method
    public RoomFactory(){
        Device device1 = makeDevice();
        Device device2 = makeDevice();
        device1.turnOn();
        device2.turnOn();
        devices.add(device1);
        devices.add(device2);
    }

    public List<Device> getDevices() {
        return devices;
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


    @Override
    public void turnOn() {
        for(int i = 0; i < this.getDevices().size(); i++){
            Device device = this.getDevices().get(i);
            device.turnOn();
        }
    }

    @Override
    public void turnOff() {
        for(int i = 0; i < this.getDevices().size(); i++){
            Device device = this.getDevices().get(i);
            device.turnOff();
        }
    }


    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);
        JTextField text = new JTextField();
        JButton dinningRoom = new JButton("Kitchen ");

        dinningRoom.setMargin(new Insets(10, 10, 10, 10));
        text.setMargin(new Insets(5, 5, 5, 5));

        ArrayList<JPanel> devicePanels = new ArrayList<>();

        for(int i = 0; i < this.devices.size(); i++){
            devicePanels.add(this.devices.get(i).getPanel());
            System.out.println(this.devices.get(i).toString());
        }

        dinningRoom.setOpaque(true);
        dinningRoom.setContentAreaFilled(true);
        dinningRoom.setBorderPainted(false);
        dinningRoom.setFocusPainted(false);
        dinningRoom.setBackground(Color.RED);
        dinningRoom.setForeground(Color.BLACK);

        text.setOpaque(true);

        panel.add(text, BorderLayout.NORTH);
        panel.add(dinningRoom, BorderLayout.PAGE_END);

        JPanel panelLamp1 = devicePanels.get(0);
        JPanel panelLamp2 = devicePanels.get(1);

        panel.add(panelLamp1, BorderLayout.LINE_START);
        panel.add(panelLamp2, BorderLayout.LINE_END);

        dinningRoom.addActionListener(e -> {
            if (isOn) {
                isOn = false;
                Composite.turnAllRoomsOff();
                dinningRoom.setBackground(Color.RED);
                panelLamp1.getComponent(0).setBackground(Color.RED);
                panelLamp2.getComponent(0).setBackground(Color.RED);


            } else {
                isOn = true;
                Composite.turnAllRoomsOn();
                dinningRoom.setBackground(Color.GREEN);
                panelLamp1.getComponent(0).setBackground(Color.GREEN);
                panelLamp2.getComponent(0).setBackground(Color.GREEN);

                //TODO mudar o texto
            }

        });

        return panel;
    }
}