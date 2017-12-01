package hot.devices;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Radio extends Device {
    public int i;
    public int c = 0;


    Originator originator = new Originator();
    CareTaker careTaker = new CareTaker();

    public JPanel getPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        Border blackline = BorderFactory.createLineBorder(Color.black);
        panel.setBorder(blackline);
        JTextField text = new JTextField();
        JButton button = new JButton("Radio");
        JButton freq1 = new JButton("F1");
        JButton freq2 = new JButton("F2");
        JButton save = new JButton("Save");

        button.setMargin(new Insets(20, 20, 20, 20));
        text.setMargin(new Insets(5, 5, 5, 5));
        freq1.setMargin(new Insets(20, 10, 20, 10));
        freq2.setMargin(new Insets(20, 10, 20, 10));
        save.setMargin(new Insets(20, 5, 20, 5));


        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(Color.RED);
        button.setForeground(Color.BLACK);

        freq1.setOpaque(true);
        freq1.setContentAreaFilled(true);
        freq1.setBorderPainted(false);
        freq1.setFocusPainted(false);
        freq1.setBackground(Color.RED);
        freq1.setForeground(Color.BLACK);

        freq2.setOpaque(true);
        freq2.setContentAreaFilled(true);
        freq2.setBorderPainted(false);
        freq2.setFocusPainted(false);
        freq2.setBackground(Color.RED);
        freq2.setForeground(Color.BLACK);

        save.setOpaque(true);
        save.setContentAreaFilled(true);
        save.setBorderPainted(false);
        save.setFocusPainted(false);
        save.setBackground(Color.RED);
        save.setForeground(Color.BLACK);

        text.setOpaque(true);

        panel.add(text, BorderLayout.NORTH);
        panel.add(button, BorderLayout.PAGE_END);
        panel.add(freq1, BorderLayout.LINE_START);
        panel.add(freq2, BorderLayout.CENTER);
        panel.add(save, BorderLayout.LINE_END);


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isOn()) {
                    button.setBackground(Color.RED);
                    turnOff();
                    i = 0;
                    text.setText("");

                } else {
                    button.setBackground(Color.GREEN);
                    freq1.setBackground(Color.LIGHT_GRAY);
                    freq2.setBackground(Color.LIGHT_GRAY);
                    save.setBackground(Color.LIGHT_GRAY);
                    turnOn();
                    i = 1;
                    text.setText("63.7");
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (isOn()) {
                    String freqvalue = text.getText();
                    originator.setState(freqvalue);
                    careTaker.add(originator.saveStateToMemento());
                    c++;
                }
            }
        });

        freq1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (isOn()) {
                    if (c == 1) {
                        originator.getStateFromMemento(careTaker.get(0));
                        String b = originator.getState();

                        text.setText(b);
                    } else {
                        originator.getStateFromMemento(careTaker.get(c - 2));
                        String b = originator.getState();

                        text.setText(b);
                    }
                }
            }

        });


        freq2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (isOn()) {

                    originator.getStateFromMemento(careTaker.get(c - 1));
                    String b = originator.getState();

                    text.setText(b);
                }

            }
        });

        return panel;
    }
}