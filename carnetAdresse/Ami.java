/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author cda611
 */
public class Ami extends Personne  {
    
    long telephone_mobile = 0; 
    String Telmobile = "aucun"; 
    JFrame frame; 
    boolean mobile = false;
    TYPE type = TYPE.AMI;
    String Type = "A";
    CarnetAdresse carnet; 

    
    public Ami(String nom, String prenom, long telephone, String adresse, int code_postal, String ville, String email, String proprio, String Type) {
        super(nom, prenom, telephone, adresse, code_postal, ville,  email, proprio); this.Type = "A"; 
    }
    
    public Ami(String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, String proprio,  long telephone_mobile, String type) {
        super(nom, prenom, telephone, adresse, code_postal, ville, email, proprio);
        this.telephone_mobile = telephone_mobile; 
        mobile = true;
       
    }
    
     public Ami(){
        
        //String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, String proprio,  long telephone_mobile
          JTextField textField1 = new JTextField();
         JTextField textField2 = new JTextField();
         JTextField textField3 = new JTextField();
         JTextField textField4 = new JTextField();
         JTextField textField5= new JTextField();
         JTextField textField6= new JTextField();
         JTextField textField7= new JTextField();
         JTextField textField8= new JTextField();
         
      


         Object[] inputFields = {" Nom : ", textField1, "Prénom : ", textField2, "Téléphone", textField6, "Adresse", textField3, "Code Postal ", textField4, "Ville", textField5,  "Email", textField7, "Teléphone mobile", textField8};
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
       // return new  Ami(nom, prenom, telephone, adresse, code_postal, ville, email, proprio, telephone_mobile, "A");
             


        
    }
    
   
  
     public long getTelMobile(){
         
        return telephone_mobile;
    }

    public void setTelephone_mobile(long telephone_mobile) {
         
     this.telephone_mobile = telephone_mobile; 
    }
    

    @Override
    public void affiche() {
        
    }
    
    @Override
    public TYPE getType(){
        return TYPE.AMI;
    }
    
    
    @Override
    public String toString(){String str;
   str = nom + " \t\t\t" + prenom + " \t\t\t" + adresse + "\t\t\t " + ville + " \t\t\t" + code_postal + " \t\t\t" + telephone + " \t\t\t" + email + " \t\t\t";
                str +=  (mobile == true) ?  telephone_mobile + "\n" : "\n"; 
                return str;
}

    @Override
    public void setType(TYPE type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDateNaissance() {
        return null;
    }

    @Override
    public void setDateNaissance(String date_naissance) {
      
    }

    @Override
    public String getTyp() {
       return "A";
    }

    
    public Personne creer(){
        
        //String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, String proprio,  long telephone_mobile
          JTextField textField1 = new JTextField();
         JTextField textField2 = new JTextField();
         JTextField textField3 = new JTextField();
         JTextField textField4 = new JTextField();
         JTextField textField5= new JTextField();
         JTextField textField6= new JTextField();
         JTextField textField7= new JTextField();
         JTextField textField8= new JTextField();
         
      


         Object[] inputFields = {" Nom : ", textField1, "Prénom : ", textField2, "Téléphone", textField6, "Adresse", textField3, "Code Postal ", textField4, "Ville", textField5,  "Email", textField7, "Teléphone mobile", textField8};
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
        return new Ami(nom, prenom, telephone, adresse, code_postal, ville, email, proprio, telephone_mobile, "A");
             


        
    }
   
  public static void main (String []args){
    
  } 
    

   
}


