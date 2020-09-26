package src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Point;


import org.w3c.dom.events.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;

class Reveleur extends JPanel {
    private static final long serialVersionUID = -3228250872355821391L;
	private List<Color> couleurs;

	public Reveleur(){
		couleurs=new ArrayList<Color>();
		couleurs.add(Color.BLACK);
		couleurs.add(Color.BLUE);
		couleurs.add(Color.CYAN);
		couleurs.add(Color.DARK_GRAY);
		couleurs.add(Color.GRAY);
		couleurs.add(Color.GREEN);
		couleurs.add(Color.LIGHT_GRAY);
		couleurs.add(Color.MAGENTA);
		couleurs.add(Color.ORANGE);
		couleurs.add(Color.PINK);
		couleurs.add(Color.RED);
		couleurs.add(Color.WHITE);
		couleurs.add(Color.YELLOW);
	}

	private Color getRandomColor(){
		int indice=(int)(couleurs.size()*Math.random());
		return couleurs.get(indice);
	}

	@Override
	public void paintComponent(Graphics g){
		g.setColor(getRandomColor());
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	public static void main(String[] args){
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setLocationRelativeTo(null);
		f.add(new Reveleur());
		f.setVisible(true);
	}

}