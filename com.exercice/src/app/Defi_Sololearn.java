package app;

import java.util.Scanner;

class Defi_Sololearn{

    static int x, i, y;
    public static void main(String[] args){

        Scanner lit = new Scanner(System.in);
         int sc = lit.nextInt(); 
        
         if(sc < 2){ sc = 7;}else{
             System.out.println("Ton numérco : " + sc);

        sc = sc*7+1;

        for (int i = 1 ; i <= sc; i++){
        for (int y = 1 ; y <= sc; y++)
        if(y == 1 || x == 6 || y%2 == 1 && x <= y || x > y && x%2 == 2 || y%2 == 1 && x > y && x%2 == 1)
            System.out.print("* " );
        else
            System.out.print("  ");
            System.out.println();
        }
         }}
    }



