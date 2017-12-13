package hot.devices;

import hot.HoTapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Device {

    boolean on = false;

    public void turnOn() {
        System.out.println("turn on"+HoTapp.numberOfDevices);
        on = true;
        HoTapp.numberOfDevices= HoTapp.numberOfDevices+1;
    }
    public boolean checkSaver(){
        System.out.println("devices allowed: " + HoTapp.numberOfDevicesAllowed);
        if(HoTapp.numberOfDevices <= HoTapp.numberOfDevicesAllowed) {
            System.out.println("devices on: " + HoTapp.numberOfDevices);
            System.out.println("can be turned on");
            return true;
        }
        else {
            System.out.println("can't be turned on");
            HoTapp.label.setText("the device can't be turned on, the limit of devices allowed was reached. Turn off other device or disable the energy save mode");
            return false;
        }
    }

    public void turnOff() {
        on = false;
        HoTapp.numberOfDevices= HoTapp.numberOfDevices-1;
        System.out.println("turn off"+HoTapp.numberOfDevices);
        HoTapp.label.setText(" ");


    }

    public boolean isOn() {
        return on;
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);
        JButton button = new JButton("OFF");
        button.setMargin(new Insets(20, 20, 20, 20));

        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.RED);
        button.setForeground(Color.BLACK);

        panel.add(button, BorderLayout.CENTER);

        button.addActionListener(e -> {
            System.out.println("state"+ isOn());
            if (isOn()) {
                button.setText("OFF");
                button.setBackground(Color.RED);
                turnOff();
            } else {
                if(checkSaver()) {
                    turnOn();
                    button.setText("ON");
                    button.setBackground(Color.GREEN);
                }
            }
        });
        return panel;
    }

}
