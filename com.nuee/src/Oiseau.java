import java.awt.Color;
import java.awt.Graphics;
import java.awt.Color.*;
import javax.swing.JPanel;

class Oiseau extends JPanel{

    private int PosX = -50; 
    private int PosY = -50; 

    public void paintComponent(Graphics g){

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.BLACK);
        g.fillOval(PosX, PosY, 5, 5);
        g.setColor(Color.BLACK);
        g.fillOval(PosX + 10, PosY +10, 5, 5);
        g.setColor(Color.BLACK);
        
        g.fillOval(PosX + 20, PosY +20, 5, 5);
        g.setColor(Color.BLACK);
       
        g.fillOval(PosX + 30, PosY +30, 5, 5);
        g.setColor(Color.BLACK);

        g.fillOval(PosX -10, PosY -10, 5, 5);
        g.setColor(Color.black);
        
        g.fillOval(PosX -20, PosY -20, 5, 5);
        g.setColor(Color.black);

        g.fillOval(PosX -30, PosY -30, 5, 5);
        g.setColor(Color.black);
    }

    public int getPosX(){return PosX;}

    public void setPosX(int PosX){this.PosX = PosX;}

    public int getPosY(){return PosY;}

    public void setPosY(int PosY){this.PosY = PosY;}


    
}