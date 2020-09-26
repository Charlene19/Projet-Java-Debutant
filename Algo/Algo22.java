package app;


//22. Découper une chaîne de caractères en mots avec l'espace comme séparateur et les compter.
class Algo22{

    public static void main (String[] args){
        
        String chaine = "randoma is the new thing !";
        String []compte;
        
        compte = chaine.split(" ");

        System.out.println(compte.length);

}}