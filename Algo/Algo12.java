package app;

import java.util.Scanner;
/**
 *
 * @author CDA611
 */
public class Algo12 {
    static Scanner input = new Scanner(System.in);
    static boolean permut = true;
    static int max;

    public static void main(String[] args) {
        System.out.println(" Vous devez remplir deux tableaux initialement ordonné.\n       ************* \n");

        System.out.println("Entrer le nombre de chiffres que vous voulez entrer dans le premier tableau : ");
        int j = input.nextInt();

        System.out.println("Entrer le nombre de chiffres que vous voulez entrer dans le deuxième tableau : ");
        int k = input.nextInt();

        int[] b = new int[j];
        int[] a = new int[k];
        int i = 0;

        System.out.println("Entrer chiffres du 1er tableau : ");

        for (i = 0; i < j; i++) {
            b[i] = input.nextInt();
        }

        System.out.println("Entrer chiffres du 2ème tableau : ");

        for (i = 0; i < j; i++) {
            a[i] = input.nextInt();
        }

        int dim3 = (a.length + b.length);
        int nouv[] = new int[dim3];
        int z = 0;
        int f = 0;

        // Affichage les 3 tableaux
        for (i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println("le tableau fusionné mesure : " + dim3 + " ");

        System.out.println(" Nouveau tableau : ");

        int n = 0;
        int m = 0;

        while (n < b.length) {
            nouv[n] = b[n];
            n++;

        }
        while (m < a.length) {
            nouv[n] = a[m];
            n++;
            m++;
        }

        for (i = 0; i < nouv.length; i++) {
            System.out.println(nouv[i] + " ");

        }

        while (permut) {
        
    for (i = 0; i < nouv.length; i++)
    System.out.print(nouv[i] + " ");
    System.out.println(); 

    permut = false;    

    for (i=0; i<nouv.length -1; i++){

        if(nouv[i] > nouv[i+1]){
            max = nouv[i+1]; 

            nouv[i+1] = nouv [i];
            nouv[i] = max; 
            permut = true; 

        }  
       
    }       

        for (i = 0; i < nouv.length; i++)
        System.out.print(nouv[i] + " ");
        System.out.println(); 

}
}
    
       }


