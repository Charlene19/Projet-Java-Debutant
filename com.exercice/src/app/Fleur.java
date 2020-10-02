package app; 

public class Fleur{

    String nomFleur; 
    String couleurFleur; 

public Fleur( String nomFleur, String couleurFleur){

    this.nomFleur = nomFleur; 
    this.couleurFleur = couleurFleur; 

System.out.println(nomFleur + " " +  "fraichement cueillie"); 
}

public  Fleur(Fleur autrFleur){

    couleurFleur = autrFleur.couleurFleur;
System.out.println ("Fragile corolle taillée ");
 
}
public void eclore(){

    System.out.println("veiné de " + couleurFleur); 

}


public String toString(){

    return  "qu'un simple souffle ";}
   
  




public static void main(String[] args)
{
Fleur f1 = new Fleur("Violette", "bleu");
Fleur f2 = new Fleur(f1);
System.out.print("dans un cristal ");
f2.eclore();
System.out.print("ne laissant plus ");
System.out.println(f1);
System.out.println(f2);
}
}
