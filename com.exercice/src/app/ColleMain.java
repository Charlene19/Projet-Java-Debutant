package app;


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Arrays;


class ColleMain {

    static int[] tab;
    static int enter = 0;
    static int i;
    String txt;
    Object affiche = "";
    Object perm = "";
    String str;
    boolean permut;
    int temp;

    public Collemain(){int []tab = new int[demande()];}

    public int demande() {

        String txt = JOptionPane.showInputDialog(null, "Entrez le nombre d'élements");
        enter = Integer.parseInt(txt);
        return enter;
    }

    public static int[] remplir() throws Exception {

        tab = new int[enter];
        Random ran = new Random();
        for (i = 0; i < tab.length - 1; i++) {
            tab[i] = ran.nextInt();
        }
        return tab;
    }

    public void afficher() {

        for (i = 0; i < tab.length; i++) {

            affiche += "tableau [" + i + "] " + tab[i] + "\n";

        }
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, affiche, "Tableau d'entier", 1);

    }

    public void trier(int[] tab) {
       
      Arrays.sort(tab);
        System.out.println(Arrays.toString(tab)); 

        while (permut) {

            for (i = 0; i < tab.length; i++) {
               

                if (tab[i] > tab[i + 1]) {
                    temp = tab[i];

                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;

                    permut = false;
                }
             permut = true;
               
            }
        }
            for (i = 0; i < tab.length; i++){
                perm += "tableau [" + i + "] " + tab[i] + "\n";
            }

            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, perm, "Tableau d'entier", 1);
        
    }

    public static void main(String[] args) {

        ColleMain pri = new ColleMain();
        pri.demande();
        try {
           remplir();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ce ne sont pas des chiffres", "Erreur", 0);
        }

        pri.afficher();
        
        pri.trier(ColleMain.tab);
       
       
   

    

    

   
   
}

  
}