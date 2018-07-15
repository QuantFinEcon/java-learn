package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListenActionEvent implements ActionListener {
    JButton button; // button match ActionListener, only 1 method to implement
    int clicked;

    public static void main(String[] args) {
        ButtonListenActionEvent gui = new ButtonListenActionEvent();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        // source accepts registration from listener, get events from users,
        // call listener's event-handling method
        button = new JButton("Click me");
        button.addActionListener(this); // register to listen to event source

        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 300);
        frame.setVisible(true);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // ActionEvent object carries data to-and-fro between listener
        // interface and event source. e.g. when its clicked, (x,y) coord,
        // which button key sent the event?
        button.setText(String.format("I have been clicked %d", this.clicked));
        this.clicked++;
    }
}
