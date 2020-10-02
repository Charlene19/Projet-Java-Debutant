import java.util.ArrayList;
import java.util.Collection;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/

class OptionVoyage{
   
	private String nom; 
    private double prix;

    public OptionVoyage(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public OptionVoyage(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double prix() {
        return prix;
    }
    public double getPrix(){ return prix;}

    public String toString() {
        String str;
        str = nom + " -> " + prix() + " CHF\n";
        return str;
    }

    
}

class Transport extends OptionVoyage {

    private boolean trajetLong = false;
    public static final double TARIF_LONG = 1500.0;
    public static final double TARIF_BASE = 200.0;
    private double prix = 0.0d;
   

    public Transport(String nom, double prix, boolean trajetLong) {
        super(nom, prix);
        this.trajetLong = trajetLong;
    }

    public Transport(String nom, double prix) {
        super(nom, prix);
        this.trajetLong = trajetLong;
    }

@Override
    public double prix() {super.prix(); if (this.trajetLong == false) {
        return TARIF_BASE + super.getPrix();
     }
     else {return  TARIF_LONG;
       
    }
    
         

    }  
    }
    
class Sejour extends OptionVoyage{
    
     private int nbreDeNuit;
     private double prixParNuit;
     private double prix =0.0d; 
      
    
      public Sejour(String nom, double prix, int nbreDeNuit, double prixParNuit){super(nom, prix); this.nbreDeNuit = nbreDeNuit; this.prixParNuit = prixParNuit;}
      public double getPrixParNuit() { return prixParNuit;}
      public int getNbreDeNuit() {
          return nbreDeNuit;
      }
      
      @Override
      public double prix(){super.prix(); prix = super.getPrix(); 
        prix +=  this.nbreDeNuit * this.prixParNuit ;return this.prix;  }

    }
    

class KitVoyage{

       private Collection<OptionVoyage> lOptionVoyages = new ArrayList <> ();
       private String depart;
       private String destination; 
       private double prix;
       
    
        public KitVoyage(String depart, String destination){ this.depart = depart; this.destination = destination;}
    
    @Override
        public String toString(){String str;
            OptionVoyage option = null;
            
            for (OptionVoyage optionVoyage : lOptionVoyages){ lOptionVoyages.toString(); }
            
            str = ("Voyage de " + depart + " à " + destination + ", avec pour options : \n "); 
            str +=  (option == null ? (" -") + lOptionVoyages.toString(): "");
            str += ("\nPrix total : "  + prix() +  " CHF"); return str;}
       
        public void ajouterOption(OptionVoyage option) { if(option != null){ lOptionVoyages.add(option); }}
    
        public void annuler(){ lOptionVoyages.clear();}
    
        public int getNbOptions(){ return lOptionVoyages.size();}

        public Double prix(){ 
            
            for( OptionVoyage option : lOptionVoyages){ 
             
                prix += ((OptionVoyage)option).prix();             
                
                
            }
            return prix;
        }

    }
        
    
      
    

/*******************************************
 * Ne pas modifier apres cette ligne
 * pour pr'eserver les fonctionnalit'es et
 * le jeu de test fourni.
 * Votre programme sera test'e avec d'autres
 * donn'ees.
 *******************************************/

public class Voyage {
    public static void main(String args[]) {

        // TEST 1
        System.out.println("Test partie 1 : ");
        System.out.println("----------------");
        OptionVoyage option1 = new OptionVoyage("Séjour au camping", 40.0);
        System.out.println(option1.toString());

        OptionVoyage option2 = new OptionVoyage("Visite guidée : London by night" , 50.0);
        System.out.println(option2.toString());
        System.out.println();

        // FIN TEST 1
// TEST 2
System.out.println("Test partie 2 : ");
System.out.println("----------------");

Transport transp1 = new Transport("Trajet en car ", 50.0);
System.out.println(transp1.toString());

Transport transp2 = new Transport("Croisière", 1300.0);
System.out.println(transp2.toString());

Sejour sejour1 = new Sejour("Camping les flots bleus", 20.0, 10, 30.0);
System.out.println(sejour1.toString());
System.out.println();

// FIN TEST 2


        // TEST 3
        System.out.println("Test partie 3 : ");
        System.out.println("----------------");

        KitVoyage kit1 = new KitVoyage("Zurich", "Paris");
        kit1.ajouterOption(new Transport("Trajet en train", 50.0));
        kit1.ajouterOption(new Sejour("Hotel 3* : Les amandiers ", 40.0, 5, 100.0));
        System.out.println(kit1.toString());
        System.out.println();
        kit1.annuler();

        KitVoyage kit2 = new KitVoyage("Zurich", "New York");
        kit2.ajouterOption(new Transport("Trajet en avion", 50.0, true));
        kit2.ajouterOption(new Sejour("Hotel 4* : Ambassador Plazza  ", 100.0, 2, 250.0));
        System.out.println(kit2.toString());
        kit2.annuler();

        // FIN TEST 3
    }

       
}

