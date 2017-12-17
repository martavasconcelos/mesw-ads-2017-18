package hot;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static hot.HoTapp.mode;

public class Mode {
    boolean activated=false;
    int devicesAllowed;
    Normal normal;
    Saver saver;
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
                    HoTapp.label.setText(" ");
                    activated=false;
                    mode.devicesAllowed=mode.normal.devicesAllowed;
                    System.out.println("CHANGE MODE");



                } else {
                    button.setText("Saver on");
                    button.setBackground(Color.GREEN);
                    activated=true;
                    mode.devicesAllowed=mode.saver.devicesAllowed;
                    System.out.println("CHANGE MODE");

                }
            }
        });
        return panel;
    }
    public boolean getActivated(){
        return activated;
    }
    public int getDevicesAllowed(){
        return mode.devicesAllowed;
    }


    public void initalize() {
        normal=new Normal();
        saver=new Saver();
        mode.devicesAllowed=normal.devicesAllowed;

    }
}
