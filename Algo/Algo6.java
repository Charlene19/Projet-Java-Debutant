/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercice;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;

/**
 * 6. Lire 10 nombres et trouver le plus petit et son rang. 
 * @author CDA611
 */
public class Algo6 {
   
    
    public static void main (String [] args) throws IOException{
      
    Reader reader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(reader);
    
    System.out.println("Entrez le nombre de chiffres que vous voulez analyser : ");
    int jf = Integer.parseInt(input.readLine());

    System.out.println("Entrer chiffres : ");
    int[] tab = new int[jf];
  
    int i,j;
    int mem = tab[0];

    for (i= 0; i<= tab.length-1 ; i++){
        tab[i] = Integer.parseInt(input.readLine());
    }

        
        for (i =0; i < tab.length -1; i++){
            
            if(mem > tab[i]){ 
                mem = tab[i]; 
                
            }
           
            
        }
System.out.println("Le nombre le plus petit est " + tab[i] + " au rang " + i);    }
    
    
    
    
}