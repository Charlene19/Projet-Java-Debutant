package com.charlene.entite; 


public abstract class Vehicule{

    String marque; 
    String modele; 

     public Vehicule(String marque, String modele){
this.marque = marque; 
this.modele = modele;
    }

    abstract boolean demarrer(); 

    abstract void arreter();

    abstract void faireLePlein(int volumeCarbutant); 

    abstract void utiliser(int distance);

    public String toString(){
        String str; 
        str = ("Le véhicule est un : "  + marque + " et de modèle : " + modele);
        return str;
    }

   
}