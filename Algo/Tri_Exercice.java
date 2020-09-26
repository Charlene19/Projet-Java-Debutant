package app;

class Tri_Exercice {
 //tri par sélection
 public static void main(String [] args){
    int [] t = {7, 15, 45, 53, 26}; 
   int i, j, min, cpt, temp; 
   
   cpt = 5;

   for (i=0; i< cpt -1; i++){
       min = i;
   
   
       for( j= i+1 ; j< cpt; j++){
        if(t[j]< t[min]) min = j; 
    }
    if(min !=i){

            if(min != i){ temp = t[min]; 
                t [min] = t[i];

               t[i] = temp; 
            
        
    
        for(j = 0; j<cpt; j++)System.out.print(t[j] + " ");
        System.out.println(); 
    }
}}}}

