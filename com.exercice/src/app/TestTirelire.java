import java.util.Scanner;

/*******************************************
 * Completez le programme a partir d'ici.
 *******************************************/
class Tirelire{

    private double montant = 0;

    public Tirelire(){

        
    }
    public double getMontant(){

//retourne le montant de la tirelire
        return montant; 
    }

    public String afficher(){

        //affiche le montant de la tirelire

        if (this.montant <= 0 ){

            // si 0 dans la tirelire
            System.out.println("Vous etes sans le sou.");
        }

            if (this.montant>0){
//s'il y a de l'argent dans la tirelire 

                System.out.println("Vous avez : "+ this.montant + "euros dans votre tirelire.");
            }
            return null;
        }
    public String secouer(){

        if (this.montant>0){ System.out.println("Bing bing"); 
    // s'affiche s'il y a de l'argent dans la tirelire

    }else{
        return null;
    }
            

    return null; 
        }
    

    public double remplir (double don){

        double montant = 0;

        // met un montant donné dans la tirelire

        while (don>0) {

            this.montant = montant + don; 
            // ne fait que si montant mis est positif 

            return montant;
            
        }
        return  montant;
     
    }

    public double vider(){

        //initialise le montant de la tirelire à 0
        double nMon = 0.0; 
        this.montant = (int)nMon;

        return this.montant; 

    }

    public void puiser(double retrait){

        //permet de puiser donné en paramétre. 
        //Si le montant est négatif il est ignoré. 
        //Si le montant est plus grand que le montant disponible, la tirelire est vidée 
        if (retrait<0){}
        if (retrait>this.montant){vider();
        }
        if (retrait>0){this.montant = (int) (montant - retrait);
        }

    }

    public double calculerSolde(double depense){

        int x = (int) (this.montant - depense);

        if (depense<0){ return this.montant;}

        return x;



    }
}


/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/
public class TestTirelire {

    public static void main(String[] args) {
        Tirelire piggy = new Tirelire();

        piggy.vider();
        piggy.secouer();
        piggy.afficher();

        piggy.puiser(20.0);
        piggy.secouer();
        piggy.afficher();

        piggy.remplir(550.0);
        piggy.secouer();
        piggy.afficher();

        piggy.puiser(10.0);
        piggy.puiser(5.0);
        piggy.afficher();

        System.out.println();

        // le budget de vos vacances de rêves.
        double budget;
        Scanner clavier = new Scanner(System.in);

        System.out.println("Donnez le budget de vos vacances : ");
        budget = clavier.nextDouble();

        // ce qui resterait dans la tirelire après les
        // vacances
        double solde = piggy.calculerSolde(budget);

        if (solde >= 0) {
            System.out.println("Vous etes assez riche pour partir en vacances !");
            System.out.print(" il vous restera " + solde + " euros");
            System.out.print(" a la rentree \n");
            piggy.puiser(budget);
        }

        else {
            System.out.print("Il vous manque " + (-solde) + " euros");
            System.out.print(" pour partir en vacances !\n");
        }
        clavier.close();
    }
}