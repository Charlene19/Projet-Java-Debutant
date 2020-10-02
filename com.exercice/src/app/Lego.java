package app;

import java.util.ArrayList;


/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Piece{

     String nom; 

     public Piece(String nom){ this.nom = nom; }
     public String getNom(){return nom;}
     public void setNom(String nom){this.nom = nom;}
     
     public String toString(){ String str = this.getNom(); return str;}

    
     }
     class Simple extends Piece{

        private String orientation = "aucune";
    
        public Simple(String nom, String orientation){ super(nom); this.orientation = orientation;}
        public Simple(String nom){super(nom);}
        public String getOrientation(){ return orientation;}
        public void setOrientation (String orientation){ this.orientation = orientation;}
    
        @Override
        public String toString(){ String str = super.toString() + " "; if(this.orientation!="aucune"){ str += this.orientation;} return str;}
     }
 

 class Composant {

    private int quantite;
    private Piece piece = new Piece("");
   
    public Composant(Piece piece, int quantite){this.piece = piece; this.quantite = quantite;}

    public Piece getPiece() { return piece; }
    

    public int getQuantite(){ return quantite;}
    public void setQuantite(int quantite){  this.quantite = quantite;}

   
}


 

 class Composee extends Piece{

    private int tailleMax;
    private int taille;
    private ArrayList <Piece> lComposee = new ArrayList<Piece>();
    Piece piece;

     public Composee(String nom, int tailleMax){ super(nom); this.tailleMax = tailleMax; }
     public int taille(){  taille =  lComposee.size(); return taille;}
     public int tailleMax(){return tailleMax;}
     public void construire(Piece piece) { if ( taille < tailleMax)
      {lComposee.add(piece);} 
     else { System.out.println("Construction impossible\t");} }   
     
       
    public String toString(){
		String str = "";
		for (Piece p : lComposee){
			str += p.toString() + ",";
		}
		return super.toString() + " (" + str.substring(0, str.length()) + ")";
	}

     }

 class Construction {
   
    
    
    public ArrayList<Composant> listComposant = new ArrayList<>();
    public int tailleMax;

    public Construction(int tailleMax){this.tailleMax = tailleMax;
    listComposant = new ArrayList<Composant>();}

    public int taille(){  int taille = listComposant.size(); return taille;}
    public int tailleMax(){ return tailleMax;}

    public void ajouterComposant(Piece piece, int taille){ 
       
    
    if (taille() < tailleMax()){ listComposant.add(new Composant(piece, taille));}  else
         {
            System.out.println("Ajout de composant impossible");} } 

    
    public String toString(){ String str = " "; 

        for (Composant composant : listComposant){
 
      str =  composant.getPiece().toString() +  "( quantite " + composant.getQuantite() + ")";}
    return str;
  
}
}

        
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

class Lego {

    public static void main(String[] args) {
        // declare un jeu de construction de 10 pieces
        Construction maison = new Construction(10);

        // ce jeu a pour premier composant: 59 briques standard
        // une brique standard a par defaut "aucune" comme orientation
        maison.ajouterComposant(new Simple("brique standard"), 59);

        // declare une piece dont le nom est "porte", composee de 2 autres pieces
        Composee porte = new Composee("porte", 2);

        // cette piece composee est constituee de deux pieces simples:
        // un cadran de porte orient'e a gauche
        // un battant orient'e a gauche
        porte.construire(new Simple("cadran porte", "gauche"));
        porte.construire(new Simple("battant", "gauche"));

        // le jeu a pour second composant: 1 porte
        maison.ajouterComposant(porte, 1);

        // dÃ©clare une piece composee de 3 autres pieces dont le nom est "fenetre"
        Composee fenetre = new Composee("fenetre", 3);

        // cette piece composee est constitu'ee des trois pieces simples:
        // un cadran de fenetre (aucune orientation)
        // un volet orient'e a gauche
        // un volet orient'e a droite
        fenetre.construire(new Simple("cadran fenetre"));
        fenetre.construire(new Simple("volet", "gauche"));
        fenetre.construire(new Simple("volet", "droit"));

        // le jeu a pour troisieme composant: 2 fenetres
        maison.ajouterComposant(fenetre, 2);

        // affiche tous les composants composants (nom de la piece et quantit'e)
        // pour les pieces compos'ees : affiche aussi chaque piece les constituant
        System.out.println("Affichage du jeu de construction : ");
        System.out.println(maison);
    }
}