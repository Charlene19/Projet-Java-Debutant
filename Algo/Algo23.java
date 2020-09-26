package app; 

//23. Inverser les mots d'une phrase.

class Algo23{

    public static void main (String[] args){
        
        String chaine = "randoma is the new thing !";
        String []compte;
        int debut = 0;
       
        String invchaine = " "; 
        int i;

       
        
        compte = chaine.split(" ");
        int fin = compte.length-1;

        while (fin >= debut){
            invchaine = compte[debut];
            compte[debut] = compte[fin]; 
            compte[fin] = invchaine; 
            fin --; 
            debut ++;

           
        }
        for (String c : compte)
        System.out.println(c);
            
        }
        }
    
