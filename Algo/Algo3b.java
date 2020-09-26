package app;

import java.util.Random;

class Algo3b{
//b) Permuter n et m, puis continuer. 
    static int temp;
   
    public static void main (String [] args) {


      
        boolean permut = true; 
        while (permut){
       
            Random obj = new Random(); 
            int nbre = obj.nextInt(100); 
            int nbre2 = obj.nextInt(75);
        System.out.println("Nombre 1 est : " + nbre + " "+ "Nombre 2 est :" + nbre2 + " ");
        
        

        

           

                if ( nbre < nbre2) {
                System.out.print( nbre + " " + nbre2); 
                permut = false; 
                }

                if(nbre > nbre2){
                temp = nbre; 
                nbre = nbre2; 
                nbre2 = nbre;
                System.out.print( nbre + " " + nbre2);
                }
            
            System.out.println();

               break;
            }
           
        }
    }


