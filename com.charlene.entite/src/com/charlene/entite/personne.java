package com.charlene.entite; 

 

class Personne{
    private String nom; 
    private String societe;
    private static final String PAS_DE_SOCIETE = "?";
    private boolean affi;
    private int i;
    public Adresse adresse;


    public Personne(String nom){this.nom = nom; this.societe = PAS_DE_SOCIETE; affi = false;}

    public Personne(String nom, String societe){this.nom = nom; this.societe = societe; affi = true; validerSociete(societe);}

    private void validerSociete(String entreprise){
        if ((entreprise.length() > 30) || (entreprise.equals("?"))){ System.out.println("La société " + entreprise + " ne correspond pas au format.");}
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom){this.nom = nom;}

    public String getSociete(){return societe;}
    public void setSociete(String societe){
       
        if(i < 1){
        this.societe = societe; affi = true; validerSociete(societe);
    i++;}else{
        System.out.println("Erreur : 1 quitterSociete, puis 2-affecterSociete");
        System.exit(0);
    }}

    
    public void afficher(){String str = " ";
        str = ("Je m'appelle " + this.nom.toUpperCase()); 
        str +=  (affi == true ? " et je travaille dans " + this.societe : " et je ne suis pas employé.");
        str += adresse.toString();

        System.out.println(str);}

    public void quitterSociete(){
        if(affi == false){
            afficher();
            System.out.println("Je ne suis pas salarié : impossible de quitter"); 
            System.exit(1);

        }else{
         societe = PAS_DE_SOCIETE; 
         affi = false;
        }
        i = 0;
    }
    

}