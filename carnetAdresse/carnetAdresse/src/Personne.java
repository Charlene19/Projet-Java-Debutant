/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JFrame;

/**
 *
 * @author cda611
 */
abstract class Personne  implements Affichage{
    
   protected String nom; 
   protected String prenom; 
   protected String adresse = "inconnu"; 
   protected int code_postal = 0; 
   String cp = "inconnu";
   String tel = "inconnu";
   protected String ville = "inconnu"; 
   protected long telephone; 
   protected String email = "inconnu";
   protected JFrame frame; 
   Personne personne;

    
    public Personne(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email ){
    this.nom = nom; this.prenom = prenom;  this.adresse = adresse; this.code_postal = code_postal;  this.ville = ville; this.telephone = telephone; this.email = email;}

    public Personne(String nom, String prenom, long telephone){this.nom = nom; this.prenom = prenom; this.telephone = telephone;}
    
    public Personne(){
     
             
              }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void creer(){
   
    }
    
    public void afficher(){   
    }
    
    abstract public TYPE getType(); 
    abstract public void setType(TYPE type); 
    
       
    //test 
         
    @Override
    public String toString(){
        String str; 
        
        str = nom + " " + prenom + " " + adresse + " " + ville + " " + telephone + " " + email + " ";
              return str;
    }
    }

     

   

    
        
    
       
    
    


