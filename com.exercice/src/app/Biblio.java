package app;

import java.util.ArrayList;
import java.util.List;

class Auteur {

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    // Completer la classe Auteur ici

    private String nom = ""; 
    private boolean prime = false; 

    public Auteur(){}

    public Auteur(String nom){}

    public Auteur(boolean prime){}

    public Auteur(String nom, boolean prime){ this.nom = nom; this.prime = prime;}

    public String getNom(){return nom;}//retourne le nom de l'auteur 

    public boolean getPrix(){return prime;} //retourne sous forme de boolean s'il a été primé

}

class Oeuvre 
{
     // Completer la classe Oeuvre ici
     private String titre = "";
     private Auteur auteur;
     private String langue = ""; 

     public Oeuvre(String titre, Auteur auteur, String langue) {this.titre = titre; this.auteur = auteur; this.langue = langue;}

     public Oeuvre(String titre, Auteur auteur){ this.langue = "francais"; this.titre = titre; this.auteur = auteur;}

     public String getTitre() { return titre;}

     public Auteur getAuteur() { return auteur;}

     public String getLangue() { return langue;}// retourne la langue

     public  void afficher() {System.out.println(this.titre + ", " + this.auteur.getNom() + ", en " + this.langue);}

 }

 // completer les autres classes ici
 class Exemplaire {

     private Oeuvre oeuvre;
     

     public Exemplaire(Oeuvre oeuvre){

        this.oeuvre =  oeuvre;

        System.out.println("Nouvel exemplaire -> " + this.oeuvre.getTitre() + ", " + this.oeuvre.getAuteur().getNom() + ", en " + this.oeuvre.getLangue());} 

     
        // Nouvel exemplaire -> <titre>, <nom de l’auteur>, en <langue>

     public Exemplaire (Exemplaire autrExemplaire){ 


         System.out.println(" Copie d’un exemplaire de -> " + this.oeuvre.getTitre() + ", " + this.oeuvre.getAuteur().getNom() + ", en " + this.oeuvre.getLangue() + "\n" ); return;} 
         //constructeur de copie}
    
     public Oeuvre getOeuvre() {return this.oeuvre;}

     public  void afficher() {System.out.println("Un exemplaire de " + this.oeuvre.getTitre()+ "," + this.oeuvre.getAuteur().getNom() + ", en " + this.oeuvre.getLangue());}

     
}

class Bibliotheque{ 

    private String nom; 
    private Oeuvre oeuvre; 
    private Auteur auteur;
    private int nombreExemplaire;
    private boolean affiche = false;
    
    private ArrayList<Exemplaire> exemplaires = new ArrayList<>(); 
    

     public  Bibliotheque(String nom) { this.nom = nom; System.out.println("La bibliothèque " + this.nom + " est ouverte !");}
              /*doit afficher La bibliothèque <nom> est ouverte ! suivi d’un saut de ligne,
                    où <nom> est à remplacer par le nom de la bibliothèque ; }*/
    
     public String getNom(){ return nom;} //retourne le nom de la bibliothèque }

     public int getNbExemplaires(){ int compteur = 0; compteur = exemplaires.size(); return compteur;}
     //retourne le nombre d'exemplaires dans la liste}
    
     public void stocker(Oeuvre oeuvre1, int nombreExemplaire) {

        for (int i = 0; i < nombreExemplaire; i++){ Exemplaire ex = new Exemplaire (oeuvre1); this.exemplaires.add(ex);}}
    
     public void stocker (Oeuvre oeuvre1){ this.stocker(oeuvre1, 1);}
       // permet d'ajouter une oeuvre dans la bibliothèque. Doit être conforme au main
     // avec méthode add}
    
     public ArrayList <Exemplaire> listerExemplaires (String langue1){
        ArrayList <Exemplaire> exempLang = new ArrayList <Exemplaire>();
        for( int i = 0; i < this.exemplaires.size(); i++){
            Exemplaire exe = (Exemplaire) this.exemplaires.get(i);
            String inLang = exe.getOeuvre().getLangue();
            if (langue1.equals(inLang)){
            exempLang.add(exe);
            }
        }
        return exempLang;
        }
        
        public ArrayList <Exemplaire> listerExemplaires (){
        //return this.listerExemplaires("francais");
        return this.exemplaires;
        }
   
     public String getLangue(String langue ){ return langue;}

     public void afficherAuteur (boolean contenu){ for( int i = 0; i < this.exemplaires.size(); i++){

            Exemplaire exemP = (Exemplaire) this.exemplaires.get(i);
            boolean cont = exemP.getOeuvre().getAuteur().getPrix();
            if (cont == contenu){
            System.out.println(exemP.getOeuvre().getAuteur().getNom());
            }
        }
        }
        
        public void afficherAuteur (){
        afficherAuteur (true);
        }
    
     public int compterExemplaires(Oeuvre o3) {return nombreExemplaire;}
}
    //affiche le nom des auteurs possibilité d'un booléen pr n'afficher que les auteurs avec un prix}
/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
/*******************************************
 * Ce qui suit est propose' pour vous aider
 * dans vos tests, mais votre programme sera
 * teste' avec d'autres donnees.
 *******************************************/

public class Biblio {

    public static void afficherExemplaires(ArrayList<Exemplaire> arrayList) {
        for (Exemplaire exemplaire : arrayList) {
            System.out.print("\t");
            exemplaire.afficher();
        }
    }

    public static void main(String[] args) {
        // create and store all the exemplaries
        Auteur a1 = new Auteur("Victor Hugo", false);
        Auteur a2 = new Auteur("Alexandre Dumas", false);
        Auteur a3 = new Auteur("Raymond Queneau", true);

        Oeuvre o1 = new Oeuvre("Les Miserables", a1, "francais");
        Oeuvre o2 = new Oeuvre("L\'Homme qui rit", a1, "francais");
        Oeuvre o3 = new Oeuvre("Le Comte de Monte-Cristo", a2, "francais");
        Oeuvre o4 = new Oeuvre("Zazie dans le metro", a3, "francais");
        Oeuvre o5 = new Oeuvre("The count of Monte-Cristo", a2, "anglais");

        Bibliotheque biblio = new Bibliotheque("municipale");
        biblio.stocker(o1, 2);
        biblio.stocker(o2);
        biblio.stocker(o3, 3);
        biblio.stocker(o4);
        biblio.stocker(o5);

        // ...
        System.out.println("La bibliotheque " + biblio.getNom() + " offre ");
        afficherExemplaires(biblio.listerExemplaires());
        String langue = "anglais";
        System.out.println("Les exemplaires en " + langue + " sont  ");
        afficherExemplaires(biblio.listerExemplaires(langue));
        System.out.println("Les auteurs a succes sont  ");
        biblio.afficherAuteur();
        System.out.print("Il y a " + biblio.compterExemplaires(o3) + " exemplaires");
        System.out.println(" de  " + o3.getTitre());
    }

    
}
