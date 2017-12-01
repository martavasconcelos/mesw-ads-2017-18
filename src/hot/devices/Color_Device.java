package hot.devices;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Color_Device extends Device {

    String color;

    public void setColor(String i) {
        color = i;
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);
        JButton button = new JButton("ColorLamp");
        JButton blue = new JButton("blu");
        JButton yellow = new JButton("yew");
        JButton pink = new JButton("pik");

        button.setMargin(new Insets(20, 20, 20, 20));
        blue.setMargin(new Insets(10, 10, 10, 10));
        yellow.setMargin(new Insets(10, 10, 10, 10));
        pink.setMargin(new Insets(10, 10, 10, 10));

        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.RED);
        button.setForeground(Color.BLACK);

        blue.setOpaque(true);
        blue.setContentAreaFilled(true);
        blue.setBorderPainted(false);
        blue.setFocusPainted(false);
        blue.setBackground(Color.RED);
        blue.setForeground(Color.BLACK);

        yellow.setOpaque(true);
        yellow.setContentAreaFilled(true);
        yellow.setBorderPainted(false);
        yellow.setFocusPainted(false);
        yellow.setBackground(Color.RED);
        yellow.setForeground(Color.BLACK);

        pink.setOpaque(true);
        pink.setContentAreaFilled(true);
        pink.setBorderPainted(false);
        pink.setFocusPainted(false);
        pink.setBackground(Color.RED);

        panel.add(blue, BorderLayout.LINE_START);
        panel.add(button, BorderLayout.NORTH);
        panel.add(pink, BorderLayout.LINE_END);
        panel.add(yellow, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn()) {
                    button.setBackground(Color.RED);
                    blue.setBackground(Color.RED);
                    yellow.setBackground(Color.RED);
                    pink.setBackground(Color.RED);
                    turnOff();
                } else {
                    button.setBackground(Color.GREEN);
                    blue.setBackground(Color.BLUE);
                    yellow.setBackground(Color.YELLOW);
                    pink.setBackground(Color.PINK);
                    turnOn();
                }
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (isOn()) {
                    setColor("blue");
                    button.setBackground(Color.BLUE);
                }
            }
        });

        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (isOn()) {
                    setColor("yellow");
                    button.setBackground(Color.YELLOW);
                }
            }
        });

        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (isOn()) {
                    setColor("pink");
                    button.setBackground(Color.PINK);
                }
            }
        });

        return panel;
    }

}
