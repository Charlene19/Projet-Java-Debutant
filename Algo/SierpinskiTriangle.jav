package app; 

import java.awt.*;

import javax.swing.*;

/**
 * Triangle de Sierpiński
 * @author fr.wikibooks.org
 */
public class SierpinskiTriangle extends JComponent
{
	private final int size;
	private final int d_min = 8;

	public SierpinskiTriangle(int size)
	{
		this.size = size;
		Dimension d = new Dimension(size, size);
		setPreferredSize(d);
		setMinimumSize(d);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		g.setColor(getBackground());
		g.clearRect(0, 0, size, size);
		g.setColor(getForeground());

		int x0 = 0; // distance de gauche
		int y0 = 0; // distance du haut
		int h = (int) (size * Math.sqrt(3) / 2); // hauteur
		// adapté à un triangle équilatéral

		// spécification du triangle principal: points A, B, C
		int xA = x0, yA = y0 + h; // (bas-gauche)
		int xB = x0 + size, yB = y0 + h; // (bas-droite)
		// int xB=x0, yB=y0; // (haut-gauche)
		// int xB=x0+d, yB=y0; // (haut-droite)
		int xC = x0 + size / 2, yC = y0; // triangle équilatéral (haut-milieu)
		// int xC=x0, yC=y0; // (haut-gauche)
		// triangle perpendiculaire, angle droit près A
		// int xC=x0+d, yC=y0; // (haut-droite)
		// triangle perpendiculaire, angle droit près B
		int[] x = { xA, xB, xC };
		int[] y = { yA, yB, yC };

		drawSierpinskiTriangle(g, x, y, size / 2); // démarrer la récursion
	}

	private void drawSierpinskiTriangle(Graphics g, int[] x, int[] y, int d)
	{
		if (d < d_min)
			g.fillPolygon(x, y, 3); // fin de la récursion
		else
		{
			// milieux des cotés du triangle:
			int xMc = (x[0] + x[1]) / 2, yMc = (y[0] + y[1]) / 2;
			int xMb = (x[0] + x[2]) / 2, yMb = (y[0] + y[2]) / 2;
			int xMa = (x[1] + x[2]) / 2, yMa = (y[1] + y[2]) / 2;

			int[] xNouveau1 =
				{ x[0], xMc, xMb };
			int[] yNouveau1 =
				{ y[0], yMc, yMb };
			drawSierpinskiTriangle(g, xNouveau1, yNouveau1, d / 2); // récursion

			int[] xNouveau2 =
				{ x[1], xMc, xMa };
			int[] yNouveau2 =
				{ y[1], yMc, yMa };
			drawSierpinskiTriangle(g, xNouveau2, yNouveau2, d / 2); // récursion

			int[] xNouveau3 =
				{ x[2], xMb, xMa };
			int[] yNouveau3 =
				{ y[2], yMb, yMa };
			drawSierpinskiTriangle(g, xNouveau3, yNouveau3, d / 2); // récursion
		}
	}

	public static void main(String[] args)
	{
		JFrame f = new JFrame("Triangle de Sierpiński");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(new SierpinskiTriangle(1024));
		f.pack();
		f.setVisible(true);
	}
}