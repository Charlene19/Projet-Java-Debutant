package app;

//17. Remplacer toutes les occurrences d'une lettre par une autre dans une chaîne de caractères.

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;

class Algo17{

  public static void main (String []args) throws Exception{

    Reader reader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(reader);

    System.out.println("Entrer un mot contenant au minimum un 'a'");
    String ex =  input.readLine();
    String replaceString = ex.replace('a','e');

    System.out.println("Résultat : \n" + replaceString);
  }
    
}