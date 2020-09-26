package app;

import java.util.Scanner;

//a) Afficher un message d'erreur et arrêter le programme.

class Algo3a{

    
    static Scanner input = new Scanner(System.in);
    public static void main (String [] args) {

       
        int i = 0;
        
       
        System.out.println("Entrez le nombre de chiffres que vous voulez trier : ");
        int jf = input.nextInt();

        System.out.println("Entrer chiffres : ");
        int[] tab = new int[jf];
        

        for (i= 0; i< jf ; i++){
            tab[i] = input.nextInt();
        }

        for (i=0; i < jf -1; i++)

                if(tab [i]< tab[i+1]){

                  for (i= 0; i <tab.length; i++)
                     System.out.print(tab [i] + " ");
                     System.out.println();
                    }

                else {

                System.out.println( "Il y a une erreur !");
            }

               
                   
                }
            }

            
        
    
