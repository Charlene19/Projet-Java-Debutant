package app;

import java.lang.reflect.Array;

class TriParSelection {

    public static void main (String[] args){


    int t[] = {25, 15, 45, 85, 65 ,15 ,2, 3 ,8 , 56 ,889, 87, 45, 78};
    int i, j, cpt, min, temp; 
    cpt = 14; 

    for (i =0; i<cpt -1;i++){
    min = i; 
   
    for( j= i+1 ; j< cpt; j++){
        if(t[j]< t[min]) min = j; 
    }
    if(min !=i){

        temp = t[min];
        t[min] = t[i];

        t[i] = temp;
    }
    for(j = 0; j<cpt; j++){
        System.out.print(t[j] + " ");
        System.out.println();
    }
    

    }}}