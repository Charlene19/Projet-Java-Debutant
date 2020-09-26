package src;

import javax.swing.JFrame;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Color.*;


class Repeindre extends JFrame {

    Repeindre() {
    setTitle("Repeindre");
    addMouseListener(new Reveleur());
    setSize(300,300);
    setVisible(true);
    Graphics g = getGraphics();
    g.setColor(Color.BLUE);
    g.fillRect(0, 0,
    getSize().width, getSize().height);
    g.dispose();
    }
}
    