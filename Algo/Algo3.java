package com.exercice;

import java.util.Scanner;

class Algo3{

    //Algo 3c Afficher de n à m (de manière décroissante). 
    static Scanner input = new Scanner(System.in);
    public static void main (String [] args) {
       
        System.out.println("Entrez le nombre de chiffres que vous voulez trier : ");
        int j = input.nextInt();

        System.out.println("Entrer chiffres : ");
        
        int[] tab = new int[j];
        int  max;
        int i = 0;
        int cpt = 5; 

        boolean permut = true; 

        for (i= 0; i< j ; i++){
            tab[i] = input.nextInt();
        }

        while (permut) {
        
        for (i = 0; i < tab.length; i++)
        System.out.print(tab[i] + " ");
        System.out.println(); 

        permut = false;    
    
        for (i=0; i<tab.length -1; i++){

            if(tab[i] < tab[i+1]){
                max = tab[i+1]; 

                tab[i+1] = tab [i];
                tab[i] = max; 
                permut = true; 

            }  
            cpt --;
        }       

            for (i = 0; i < cpt; i++)
            System.out.print(tab[i] + " ");
            System.out.println(); 

    }
}}