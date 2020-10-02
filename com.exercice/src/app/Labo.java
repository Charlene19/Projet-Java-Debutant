class Souris {

    public static final int ESPERANCE_VIE_DEFAUT = 36;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/

    private int poids;
    private String couleur;
    private int age;
    private int esperanceVie;
    private boolean clonee = false; 
    private String s1; 
    
    public Souris(){ System.out.println("Une nouvelle souris !");}

    public Souris(int poids,String couleur, int age, int esperanceVie){
        this.poids = poids;
        this.couleur = couleur; 
        this.age = age; 
        this.esperanceVie = esperanceVie;

        System.out.println("Une nouvelle souris !");

    }
    public Souris(int poids, String couleur, int age) {

        this.poids = poids;
        this.couleur = couleur;
        this.age = age;
        clonee = false;
        this.esperanceVie = ESPERANCE_VIE_DEFAUT;

        System.out.println("Une nouvelle souris !");

    }

    public Souris(int poids, String couleur) {

        this.poids = poids;
        this.couleur = couleur;
        clonee = false; 
        this.esperanceVie = ESPERANCE_VIE_DEFAUT;

        System.out.println("Une nouvelle souris !");

    }

    public Souris(Souris autreSouris) {

        poids = autreSouris.poids;
        couleur = autreSouris.couleur;
        clonee = true;
        esperanceVie = autreSouris.esperanceVie;
        age = autreSouris.age;

        System.out.println("Clonage de souris !");

    }
 
    
public int evolue() {

       while (age<esperanceVie){this.vieillir();
       }

        return age;

        // fait viellir la souris de son âge courant jusqu'à son espérance de vie

    }

    public void vieillir(){


       age++; 

       if (this.clonee && age>14){ this.couleur = "verte";}
    }

    public  String toString() {

           String str = "Une souris " + couleur ;  if (clonee) { str += ", clonee, ";}
           str += " de " + age
                    + " mois et pesant "
                    + poids
                    + " grammes";

                    return str;
        
}


}

/*******************************************
 * Ne rien modifier apres cette ligne.
 *******************************************/

public class Labo {

    public static void main(String[] args) {
        Souris s1 = new Souris(50, "blanche", 2);
        Souris s2 = new Souris(45, "grise");
        Souris s3 = new Souris(s2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolue();
        s2.evolue();
        s3.evolue();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
