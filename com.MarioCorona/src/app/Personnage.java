package app; 

class Personnage{

    int largeur, hauteur, x, y;
    boolean marche;
    boolean versDroite;
    int compteur;

    

    public Personnage(int x, int y, int largeur, int hauteur){

    this.x = x;
    this.y = y; 
    this.largeur = largeur; 
    this.hauteur = hauteur;
    }

    public int getX(){ return x;}
    public void setX(int x){ this.x = x;}

    public int getY(){ return y;}
    public void setY(int y){this.y = y;}

    public int getLargeur(){ return largeur;}
    public void setLargeur(int largeur){this.largeur = largeur;}

    public int getHauteur(){return hauteur;}
    public void setHauteur(int hauteur){this.hauteur = hauteur;}

    public boolean isMarche(){ return marche;}
    public void setMarche(boolean marche){this.marche = marche;}

    public boolean isDroite(){ return versDroite;}
    public void setVersDroite(boolean versDroite){ this.versDroite = versDroite;}

    public int getCompteur(){return compteur;}
    public void setCompteur(int compteur){this.compteur = compteur;}

}