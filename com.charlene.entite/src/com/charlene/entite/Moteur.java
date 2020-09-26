package com.charlene.entite;

class Moteur {

  

    float volume_reservoir;
    float volume_total;
    boolean demarre;
    int carburant;

    public float getVolumeReservoir(){ return volume_reservoir;}

    public float getVolumeTotal(){return volume_total;}
    public void setVolumeTotal(){ volume_total = volume_reservoir + carburant;}

    public boolean getDemarre(){return demarre;}

    public boolean demarrer(){
        if (volume_reservoir != 0){ volume_reservoir = volume_reservoir - 1/10*volume_reservoir; 
            System.out.println("Je démarre avec : " +  volume_reservoir + "  dans le réservoir. ");
            demarre = true;}else{
        
        demarre = false;}
        return demarre;
    }

    public float utiliser(int carburant){
        if (carburant < volume_reservoir){
        volume_reservoir = volume_reservoir - carburant;
        }else{
            volume_reservoir = volume_reservoir - volume_reservoir;
           
        }
        
         return volume_reservoir;}

    public void faireLePlein(int carburant){
        volume_reservoir = volume_reservoir + carburant; 
        
        
        System.out.println("Plein effectué avec " + carburant + " litres");} 

    public void arreter(){System.out.println("J'arrêtes");}

    public String toString(){ String str; 
    str = ("Il reste " + volume_reservoir + " dans le réservoir.");return str;}


}