package app;

import javax.swing.ImageIcon;
import java.awt.Image;

class Mario extends Personnage {

    private Image imgMario; 
    private ImageIcon icoMario; 

    public Mario(int x, int y) {
        super(x, y, 28, 50);

        icoMario = new ImageIcon("src\\app\\image\\marioMarcheDroite.png");
        this.imgMario = this.icoMario.getImage();  }
    
        public Image getImgMario(){ return imgMario;}
}