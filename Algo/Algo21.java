package app; 

//21. Remplacer les double-espace (ou +) dans une chaîne de caractères par un espace.

class Algo21{

    public static void main (String[] args){
        String chaine = "randoma  is the new thing !  ";  
        String resultat = chaine.replace("  "," ");
        System.out.println(resultat);  
        }
        
    }
    