package app; 

import java.util.Scanner;
import java.lang.Exception;

class Serie1{

    static double resultat;
    static Scanner input = new Scanner(System.in);

    public static double calculer(char operateur, double var1, double var2) throws ArithmeticException {

        
        if (operateur == '+') { resultat = var1 + var2;}
        if (operateur == '-') { resultat = var1 - var2;}
        if (operateur == '/')
            try {
                resultat = var1 / var2;
            } catch (ArithmeticException e) {
                System.out.println("Impossible de / par 0");
            }
        if (operateur == '*') { resultat = var1 * var2;}

    else{
        System.out.println(" Le caractère saisi n'existe pas ! ");
    }

        return resultat;
    }

    public static void main(String[] args) {

        System.out.println("Quel opé ? /n");
        char opé = input.next().charAt(0);
        System.out.println("Premier terme : /n"); 
        double un = input.nextDouble();
        System.out.println("2ème terme : /n"); 
        double deux = input.nextDouble();
try {
    resultat = calculer(opé, un, deux);
    System.out.println(resultat);
} catch (Exception e) {
    //TODO: handle exception
}
      

    }
}