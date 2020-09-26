package com.charlene.entite;

import java.io.*;
import java.lang.Exception;
import  com.charlene.exceptions.PanneEssenceException; 

class Voiture extends VehiculeAMoteur{

    private float carburant;
    float carburantDep;


        public Voiture(String marque, String modele, Moteur moteur) {
            super(marque, modele, moteur);
        }

        public Voiture(String marque, String modele, float carburant){super(marque, modele); this.carburant = carburant;}

        public float getCarburant(){ return carburant;}
        public Moteur getMoteur(){return moteur;}

        public void setCarburant(float carburant){ this.carburant = carburant;}

        public float utiliser(float consommation){
            if (consommation < carburant){
              
                carburant = carburant - (consommation + (float) 0.1);
                }else{
                    carburant = carburant - carburant;
                   
                }
                
                 return carburant;}

                 @Override
        public boolean demarrer() { 
           
        
            System.out.println("Je viens de consommer 1/10 litres pour demarrer");
            
           
            return true;
        }
        

        public void rouler( float consommation ) throws PanneEssenceException{

            carburantDep += consommation;

            if ( !getMoteur().demarrer()) { getMoteur().demarrer(); }
           
                carburant = utiliser((int) consommation);
                if (carburant == 0) {throw new PanneEssenceException("problème ");}else{
                    
            System.out.println("Le moteur utilise " + consommation + " litres --> il reste " + (String.format("%.02f",  carburant))  + " litres");
            }

           
        }
       
@Override
public void faireLePlein(int volumeCarbutant) {
   
    super.faireLePlein(volumeCarbutant);
    carburant = carburant + volumeCarbutant;
}

       

        
        

        @Override
        public String toString(){String str; 
            str = super.toString() + "\n" + "Il reste " + (String.format("%.02f",  carburant)) + " dans le réservoir"; return str;}

     
    
        
}