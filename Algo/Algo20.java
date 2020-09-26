package app; 

//20. Compter le nombre d'occurrences de chaque lettre dans une chaine.
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;

class Algo20{

  static Reader reader = new InputStreamReader(System.in);
  static BufferedReader input = new BufferedReader(reader);

  
    static String resultat = " ";
    int i;
    static int count = 0;
  static int index;

  public static int comptOccur(String str, char recherche) {

    if (index != -1) {
      count++;
      resultat = resultat + index + " ";
      index = str.indexOf(recherche, index+1);
    }

    return count;
  }

 

  public static void main(String[] args) throws Exception {
    System.out.println("Entrer un mot : ");
    String mot = input.readLine();

    System.out.println("Entrez un caractère : "); 
    char recherche = (char)input.read();

    int resultat = comptOccur(mot, recherche);

    System.out.println("Le nombre d'occurence est de : " + comptOccur(mot, recherche));
    }
}

