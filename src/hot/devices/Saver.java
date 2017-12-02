package hot.devices;

import hot.HoTapp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saver extends Device{
    boolean activated=false;

    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);
        JButton button = new JButton("Saver off");
        button.setMargin(new Insets(20, 20, 20, 20));

        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.RED);
        button.setForeground(Color.BLACK);

        panel.add(button, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(activated);
                if (activated) {
                    button.setText("Saver off");
                    button.setBackground(Color.RED);
                activated=false;
                    HoTapp.numberOfDevicesAllowed=6;
                } else {
                    button.setText("Saver on");
                    button.setBackground(Color.GREEN);
                    activated=true;
                    HoTapp.numberOfDevicesAllowed=3;
                }
            }
        });
        return panel;
    }
}
