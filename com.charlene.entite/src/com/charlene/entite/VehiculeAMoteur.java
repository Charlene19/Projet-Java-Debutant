package com.charlene.entite;

abstract class VehiculeAMoteur extends Vehicule {

    Moteur moteur = new Moteur();

    public VehiculeAMoteur(String marque, String modele, Moteur moteur) {
        super(marque, modele); 
        
        this.moteur = moteur;
    }

    public VehiculeAMoteur(String marque, String modele) {
        super(marque, modele); 
        this.moteur = getMoteur();
    }

    public Moteur getMoteur(){return moteur;}

    @Override
    public boolean demarrer() {
      
        return moteur.demarrer();
        
        }
      
        @Override
        public void arreter() {
       moteur.arreter();
        }

        @Override
        public void faireLePlein(int volumeCarbutant){
            moteur.arreter(); 
            moteur.faireLePlein(volumeCarbutant);
            moteur.demarrer();
        } 
        @Override
        public String toString(){ return super.toString() + " \n";
        
        }
        
    
}