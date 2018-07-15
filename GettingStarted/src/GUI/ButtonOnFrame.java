package GUI;

import javax.swing.*;
import java.awt.*;

public class ButtonOnFrame {
    /*
     * Event Handling (many events types handled in Java)
     * button pressed (an event) ---> roll off? ---> button released (an event)
     * listener interface: bridge listener (user) and event source (button)
     * interface is where call-back method is declared
     * Event is an object of event class. MouseEvent, KeyEvent, WindowEvent,
     * ActionEvent... java.awt.event.. click mouse, type key, close window...
     *
     * Event source (button) creates an event object on an event (click)
     * Most time, Event listener receive rather than create event
     * Event Source -> MouseEvent -> matching MouseListener interface
     *
     * let an event source (button) that implements ActionListener, know that
     * you are interested to listen to its events with
     * button.addActionListener(this); --> AND ALSO method actionPerformed()
     *
     * listener invokes it -> addActionListener() runs -> button takes a
     * parameter, stores it in a list --> user clicks button -> button fires
     * the event by calling actionPerformed on each listener in the list ->
     * this is event-handling
     *
     * */

    //    public interface MouseListener extends EventListener {
//
//        /**
//         * Invoked when the mouse button has been clicked (pressed
//         * and released) on a component.
//         * @param e the event to be processed
//         */
//        public void mouseClicked(MouseEvent e);
//
//        /**
//         * Invoked when a mouse button has been pressed on a component.
//         * @param e the event to be processed
//         */
//        public void mousePressed(MouseEvent e);
//
//        /**
//         * Invoked when a mouse button has been released on a component.
//         * @param e the event to be processed
//         */
//        public void mouseReleased(MouseEvent e);
//
//        /**
//         * Invoked when the mouse enters a component.
//         * @param e the event to be processed
//         */
//        public void mouseEntered(MouseEvent e);
//
//        /**
//         * Invoked when the mouse exits a component.
//         * @param e the event to be processed
//         */
//        public void mouseExited(MouseEvent e);
//    }
//
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click Me!");

        // prog quits when window close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.CENTER, button);
        frame.setSize(330, 300);
        frame.setVisible(true);
    }
}
