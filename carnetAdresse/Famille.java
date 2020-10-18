/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author cda611
 */
public class Famille extends Personne {
    
     long telephone_mobile; 
     String date_naissance;
     boolean mobile = false;
     boolean date = false;
     String Telmobile;
     TYPE type = TYPE.FAMILLE;
     CarnetAdresse carnet; 
     
    
    public Famille(String nom, String prenom, long telephone,String adresse, int code_postal, String ville,  String email, String proprio) {
        super(nom, prenom, telephone, adresse, code_postal, ville,  email, proprio); this.type = type;
    }
    
    public Famille(String nom, String prenom,  long telephone, String adresse, int code_postal, String ville, String email, String proprio, long telephone_mobile) {
        super(nom, prenom, telephone, adresse, code_postal, ville,  email, proprio); this.telephone_mobile = telephone_mobile;
        mobile = true; this.type = type;
    }
    
     public Famille(String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, String proprio, long telephone_mobile, String date_naissance) {
        super(nom, prenom, telephone,  adresse, code_postal, ville, email, proprio); 
       
        this.telephone_mobile = telephone_mobile;
         this.date_naissance = date_naissance;
        date = true; 
        mobile = true;
        this.type = type;
    }

   @Override
    public String getTyp() {
       return "F";
    }
    
    
     
    public long getTelMobile() {
        return telephone_mobile;
    }

    public void setTelephone_mobile(long telephone_mobile) {
       this.telephone_mobile = telephone_mobile;
    }
    
    public String getDateNaissance(){return date_naissance;}
     
     public void setDateNaissance(String date_naissance){
           this.date_naissance = date_naissance; 
          
     }
     
     @Override
    public void affiche() {
       
    }
    
       
    public Famille(){
        
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
    public TYPE getType(){
        return TYPE.FAMILLE;
    }
    
    public String toString(){
      String str;
        
        str = nom + "\t\t\t " + prenom + "\t\t\t " + adresse + " \t\t\t" + ville + "\t\t\t " + telephone + " \t\t\t" + email + "\t\t\t ";
                str +=  (mobile == true) ?  telephone_mobile : " \t\t\t"; 
                 str +=  (date == true) ?  date : " \t\t\t"; 
                 
                 return str;
    }
    
    /*Locale locale = new Locale("fr", "FR");
DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
String date = dateFormat.format(new Date());
System.out.print(date);*/

    @Override
    public void setType(TYPE type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personne creer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
 
 
}
    
    