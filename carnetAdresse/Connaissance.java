/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author cda611
 */
public class Connaissance extends Personne{
    
     long telephone_mobile; 
     String date_naissance;
     boolean choice1 = false; 
     boolean choice2 = false; 
     boolean choice3 = false; 
     boolean choice4 = false; 
     String Telmobile;
     String t  = "C";
      String tel;
     TYPE type = TYPE.CONNAISSANCE;
     Scanner scanner = new Scanner(System.in);
     CarnetAdresse carnet; 


    
    public Connaissance(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email, String proprio) {
        super(nom, prenom, telephone, adresse, code_postal, ville,  email, proprio);
        choice2 = true;
        this.type = type;
    }
    
    public Connaissance(String nom, String prenom, long telephone, String proprio, String t){ super(nom, prenom, telephone, proprio); choice1 = true;  this.t = t;}
    
     public Connaissance(String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, long telephone_mobile, String proprio) {
        super(nom, prenom, telephone,  adresse, code_postal, ville, email, proprio); 
        this.telephone_mobile = telephone_mobile; 
         choice3 = true; 
         this.type = type;
    }
    
     public Connaissance(String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, String proprio, long telephone_mobile, String date_naissance, String t) {
        super(nom, prenom, telephone, adresse, code_postal, ville,  email, proprio); 
      
         this.telephone_mobile = telephone_mobile; 
        this.date_naissance = date_naissance;
        
    choice4 = true;  this.type = type;}

    
     @Override
     public long getTelMobile(){return telephone_mobile; }
     
     @Override
     public void setTelephone_mobile(long telephone_mobile){
       this.telephone_mobile = telephone_mobile;
      }
     
     
     @Override
     public String getDateNaissance(){return date_naissance;}
     
     @Override
     public void setDateNaissance(String date_naissance){
         this.date_naissance = date_naissance;
        
     }
     
      @Override
    public void affiche() {
         
         }
     @Override
     public TYPE getType(){
        return TYPE.CONNAISSANCE;
    } 
     
     @Override
    public String getTyp() {
       return "C";
    }
    
     public int compareTo(Object personne) {
   	  
         return (((Connaissance)this).getNom()).compareTo( ((Connaissance)personne).getNom());

 }
      
     
      
    public Connaissance(){
        
        //String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, String proprio, long telephone_mobile, String date_naissance, String t
          JTextField textField1 = new JTextField();
         JTextField textField2 = new JTextField();
         JTextField textField3 = new JTextField();
         JTextField textField4 = new JTextField();
         JTextField textField5= new JTextField();
         JTextField textField6= new JTextField();
         JTextField textField7= new JTextField();
         JTextField textField8= new JTextField();
         JTextField textField9= new JTextField();
      


         Object[] inputFields = {" Nom : ", textField1, "Prénom : ", textField2, "Téléphone", textField6, "Adresse", textField3, "Code Postal ", textField4, "Ville", textField5,  "Email", textField7, "Teléphone mobile", textField8, "Date de naissance", textField9};
              JOptionPane.showConfirmDialog(null, inputFields, "Création d'un contact : " + this.getClass().getName() , JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
   
              nom = textField1.getText();
              prenom = textField2.getText();
              adresse= textField3.getText();
              cp = textField4.getText();
              code_postal = Integer.parseInt(cp);
              ville = textField5.getText();
              tel = textField6.getText();
              telephone = Integer.parseInt(tel);
              email = textField7.getText();
              Telmobile = textField8.getText(); 
              telephone_mobile = Long.parseLong(Telmobile);
              String proprio = carnet.getProprio();
              date_naissance = textField9.getText(); 
              
        //return new Connaissance(nom, prenom, telephone, adresse, code_postal, ville, email, proprio, telephone_mobile, date_naissance, "C");
             


        
    }

     @Override
     public String toString(){
String str;
        
         if(choice2 == true){
        str = nom + "\t\t\t " + prenom + " \t\t\t" + adresse + " \t\t\t" + code_postal + "\t\t\t " + ville + " \t\t\t" + telephone + " \t\t\t" + email + " \n";
         }else if(choice1 == true){
                str =  nom + "\t\t\t " + prenom + " \t\t\t" + telephone + "\n ";
         }else if (choice3 == true){
                 str =  nom + "\t\t\t " + prenom + "\t\t\t " + adresse + "\t\t\t " + code_postal + "\t\t\t " + ville + " \t\t\t" + telephone + " \t\t\t" + email + "\t\t\t " + telephone_mobile + "\n ";
         }else{
             str =  nom + "\t\t\t " + prenom + " \t\t\t" + adresse + " \t\t\t" + code_postal + "\t\t\t " + ville + "\t\t\t " + telephone + "\t\t\t " + email + "\t\t\t " + telephone_mobile + "\t\t\t " + date_naissance + "\n"; }
 return str;    

}

    @Override
    public void setType(TYPE type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personne creer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
    
