package hot;

import hot.devices.Device;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NullDevice extends Device {
    public void turnOn() {

    }

    public void turnOff() {

    }
    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);
        return panel;
    }

    public boolean isOn() {
        return false;
    }

}
