import javax.swing.JFrame;
import javax.swing.JPanel;

class Fenetre extends JFrame {

Oiseau oiseau = new Oiseau(); 

Position position;

  public static void main(String[] args) {
    new Fenetre();
  }


  public Fenetre() {

    

    this.setTitle("La nuée");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setContentPane(oiseau);
    this.setVisible(true);

    go();
   
  }
  private void go() {
    int x = oiseau.getPosX(), y = oiseau.getPosY();
    boolean backX = false;
    
    boolean backY = false;

    
    while (true) {
     
      if (x < 1)
        backX = false;
     
      if (x > oiseau.getWidth() - 50)
        backX = true;
      
      if (y < 1)
        backY = false;
      if (y > oiseau.getHeight() - 50)
        backY = true;

     
      if (!backX)
        oiseau.setPosX(++x);
     
      else
        oiseau.setPosX(--x);
      
      if (!backY)
        oiseau.setPosY(++y);
      else
        oiseau.setPosY(--y);

      
      oiseau.repaint();
      
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  }

    
