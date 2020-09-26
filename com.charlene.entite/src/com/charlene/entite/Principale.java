package com.charlene.entite; 

import javax.swing.JOptionPane;

class Principale{

    static boolean sortir = true;

    public static void main(String[] args) throws PanneEssenceException {

        Voiture laguna = new Voiture("Renault", "Laguna", 30.0f);
        System.out.println(laguna);
        laguna.demarrer();
        JOptionPane.showMessageDialog(null, laguna, "Voiture", JOptionPane.INFORMATION_MESSAGE);
        try {
            laguna.rouler(35);
        } catch (PanneEssenceException ex) {
            JOptionPane.showMessageDialog(null, "La laguna vient de tomber en panne : " + ex.getMessage());
            String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
            Integer i = Integer.parseInt(resultat);
            laguna.faireLePlein(i);
            

        }
        Voiture citroen = new Voiture("Citroen", "C5", 40.0f);
        System.out.println(citroen);
        citroen.demarrer();
        JOptionPane.showMessageDialog(null, citroen, "Voiture", JOptionPane.INFORMATION_MESSAGE);

        while (sortir) {

            try {
                citroen.rouler(10);
               
            } catch (PanneEssenceException ex) {
                JOptionPane.showMessageDialog(null, "La citroen vient de tomber en panne : " + ex.getMessage());
                String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
                Integer i = Integer.parseInt(resultat);
                citroen.faireLePlein(i);
            try{
                citroen.rouler(10);}catch (PanneEssenceException e){
                    System.out.print("Qué pasa ");
                }

}
            

            try {
                citroen.rouler(10);
            } catch (PanneEssenceException ex) {
                JOptionPane.showMessageDialog(null, "La citroen vient de tomber en panne : " + ex.getMessage());
                String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
                Integer i = Integer.parseInt(resultat);
                citroen.faireLePlein(i);
                try{
                    citroen.rouler(10);}catch(PanneEssenceException e){
                        System.out.println("Mettre plus d'essence" );
    
    }
            }
        
            try {
                citroen.rouler(10);
            } catch (PanneEssenceException ex) {
                JOptionPane.showMessageDialog(null, "La citroen vient de tomber en panne : " + ex.getMessage());
                String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
                Integer i = Integer.parseInt(resultat);
                citroen.faireLePlein(i);
                try{
                    citroen.rouler(10);}catch(PanneEssenceException e){
                        System.out.println("Mettre plus d'essence" );
    
    }

            }
            try {
                citroen.rouler(10);
            } catch (PanneEssenceException ex) {
                JOptionPane.showMessageDialog(null, "La citroen vient de tomber en panne : " + ex.getMessage());
                String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
                Integer i = Integer.parseInt(resultat);
                citroen.faireLePlein(i);
                try{
                    citroen.rouler(10);}catch(PanneEssenceException e){
                        System.out.println("Mettre plus d'essence" );
    
    }

            }
            try {
                citroen.rouler(10);
            } catch (PanneEssenceException ex) {
                JOptionPane.showMessageDialog(null, "La citroen vient de tomber en panne : " + ex.getMessage());
                String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
                Integer i = Integer.parseInt(resultat);
                citroen.faireLePlein(i);
                try{
                    citroen.rouler(10);}catch(PanneEssenceException e){
                        System.out.println("Mettre plus d'essence" );
    
    }
            }
            try {
                citroen.rouler(10);
            } catch (PanneEssenceException ex) {
                JOptionPane.showMessageDialog(null, "La citroen vient de tomber en panne : " + ex.getMessage());
                String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
                Integer i = Integer.parseInt(resultat);
                citroen.faireLePlein(i);
                try{
                    citroen.rouler(10);
                   
                   }catch(PanneEssenceException e){
                        System.out.println("Mettre plus d'essence" );
                      
                        
    }
    
   
            }sortir = false;
            System.out.println("Le moteur est arrêté");
            
}

Scooter tmax = new Scooter("Yamaha", "X-Max", 20.0f);
System.out.println(tmax);
tmax.demarrer();
JOptionPane.showMessageDialog(null, tmax, "Scooter", JOptionPane.INFORMATION_MESSAGE);

try {
    tmax.rouler(10);
   
} catch (PanneEssenceException ex) {
    JOptionPane.showMessageDialog(null, "La T Max vient de tomber en panne : " + ex.getMessage());
    String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
    Integer i = Integer.parseInt(resultat);
    tmax.faireLePlein(i);
try{
    tmax.rouler(10);}catch (PanneEssenceException e){
        System.out.print("Qué pasa ");
    }

}


try {
    tmax.rouler(10);
} catch (PanneEssenceException ex) {
    JOptionPane.showMessageDialog(null, "La T Max vient de tomber en panne : " + ex.getMessage());
    String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
    Integer i = Integer.parseInt(resultat);
    tmax.faireLePlein(i);
    try{
        tmax.rouler(10);}catch(PanneEssenceException e){
            System.out.println("Mettre plus d'essence" );

}
}

try {
    tmax.rouler(10);
} catch (PanneEssenceException ex) {
    JOptionPane.showMessageDialog(null, "La T Max vient de tomber en panne : " + ex.getMessage());
    String resultat = JOptionPane.showInputDialog(null, "Veuillez saisir le nombre de litres SVP ");
    Integer i = Integer.parseInt(resultat);
    tmax.faireLePlein(i);
    try{
        tmax.rouler(10);}catch(PanneEssenceException e){
            System.out.println("Mettre plus d'essence" );

}
System.out.println("Le moteur est arrêté");
}



    }
}