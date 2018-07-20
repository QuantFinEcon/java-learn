package GUI;

/*
Common mistakes when handling multiple listeners

1. implement 2 actionPerformed() methods

class ... implements ActionListener {
    public void actionPerformed(ActionEvent e){}
    public void actionPerformed(ActionEvent e){}
        }

2. register the same listener with both buttons

button1.addActionListener(this);
button2.addActionListener(this);

public void actionPerformed(ActionEvent e){
    if(e.getSource() == button1){}
    else{}
    }

public class MultipleListenersAndBorders {
    public static void main(String[] args) {

    }
}
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultipleListenersAndBorders {
    // Correct way: create 2 separate ActionListener classes, but can these
    // classes have acess to the GUI variables to act on? Inner Class!
    JFrame frame;
    JLabel label;
    JButton labelButton;
    JButton circleButton;

    public static void main(String[] args) {
        MultipleListenersAndBorders gui = new MultipleListenersAndBorders();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelButton = new JButton("Change Label.");
        labelButton.addActionListener(new LabelListener());

        circleButton = new JButton("Change Circle.");
        circleButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a Label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, circleButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    /* inner classes can access class variables
     *  valid use here since methods implementation not reusable */
    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getSource().toString());
            if (e.getSource() == labelButton) {
                label.setText("Ouch");
            }
        }
    }

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == circleButton) {
                frame.repaint();
            }
        }
    }

}
