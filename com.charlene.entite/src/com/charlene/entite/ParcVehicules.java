package com.charlene.entite;

import java.util.Random;

class ParcVehicules {

    int NBR_VEHICULES;
    Vehicule []parc = new Vehicule [NBR_VEHICULES]; 
    Vehicule vehicule;

    
    public Vehicule getVehicule(){ return vehicule;}

    public void controlerVehicules(Vehicule vehicule){

        Random r = new Random();
        int low = 5;
        int high = 10;
        int result = r.nextInt(high-low) + low;

        vehicule.demarrer(); 
        vehicule.utiliser(result);
    }

    
}