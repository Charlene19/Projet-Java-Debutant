package app;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *11. Trier un tableau de 10 éléments par ordre croissant. 
 * @author CDA611
 * /** */
 
import java.util.Scanner;

class Algo11{

    //Algo 11 Afficher de n à m (de manière croissante). 
    static Scanner input = new Scanner(System.in);
    public static void main (String [] args) {
       
        System.out.println("Entrez le nombre de chiffres que vous voulez trier : ");
        int j = input.nextInt();

        System.out.println("Entrer chiffres : ");
        
        int[] tab = new int[j];
        int  max;
        int i = 0;
        int cpt = tab.length; 

        boolean permut = true; 

        for (i= 0; i< j ; i++){
            tab[i] = input.nextInt();
        }

        
        
while(permut){
for(i = 0; i <tab.length; i++) 
System.out.print(tab[i] + " ");
System.out.println();


permut = false; 

for (i=0; i < tab.length -1; i++){
    if(tab [i]> tab[i+1]){
        max = tab[i+1]; 
        
        tab[i +1] = tab[i]; 
        tab[i] = max; 
        
        permut = true;}
cpt --;}
for (i=0; i < cpt; i++)
    
    System.out.print(tab[i] + " ");
System.out.println();
}
}}
    
