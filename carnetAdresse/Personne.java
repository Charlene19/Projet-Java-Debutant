/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author cda611
 */
abstract class Personne  implements Affichage{
    
   protected String nom; 
   protected String prenom; 
   protected String adresse = null; 
   protected int code_postal = 0; 
   String cp = null;
   String tel = null;
   protected String ville = null; 
   protected long telephone; 
   protected String email = null;
   protected JFrame frame; 
   Personne personne;
   TYPE type;
   String Telmobile; 
   Long telephone_mobile;
   String date_naissance;
   String[] demande;
   String[] input;
   String proprio = "Default";
   Scanner sc = new Scanner(System.in); 
    
    public Personne(String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, String proprio){
        this.nom = nom; this.prenom = prenom; this.telephone = telephone; this.adresse = adresse; this.ville = ville; this.email = email; this.proprio = proprio;
    }

    public Personne(String nom, String prenom, long telephone, String proprio){this.nom = nom; this.prenom = prenom; this.telephone = telephone; this.proprio = proprio;}
   
    public Personne(){}
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        
        this.nom = nom ;
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
    
    public String getProprietaire(){return proprio;}
    public void setProprietaire(String proprio){this.proprio = proprio;}

    abstract public String getDateNaissance(); 
    abstract public long getTelMobile(); 
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
      
    }
    
   abstract public Personne creer();
    abstract public String getTyp();
    
    public void afficher(){   
    }
    
    abstract public TYPE getType(); 
    abstract public void setType(TYPE type); 
    
    abstract public void setTelephone_mobile(long telephone_mobile);
    
    abstract public void setDateNaissance(String date_naissance);
   
    //test 
         
    @Override
    public String toString(){
        String str; 
        
        str = nom + " \t\t\t" + prenom + " \t\t\t" + adresse + " \t\t\t" + ville + " \t\t\t" + telephone + " \t\t\t" + email + "\t\t\t ";
              return str;
    }
    }


