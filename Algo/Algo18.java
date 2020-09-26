package app; 

//18. Supprimer toutes les occurrences d'une lettre dans une chaîne de caractères.

class Algo18{

        public static void main (String[] args){
    String chaine = "randoma"; 
    String arr [] = chaine.split("a");
      String result = "";

      for(String c : arr)
          result+=c;
      System.out.println(result);
  
}}