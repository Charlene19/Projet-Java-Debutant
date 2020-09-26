/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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
     TYPE type = TYPE.CONNAISSANCE;


    
    public Connaissance(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email);
        choice2 = true;
        this.type = type;
    }
    
    public Connaissance(String nom, String prenom, long telephone){ super(nom, prenom, telephone); choice1 = true;  this.type = type;}
    
     public Connaissance(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email, long telephone_mobile) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email); this.telephone_mobile = telephone_mobile; choice3 = true; 
         this.type = type;
    }
    
     public Connaissance(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email, long telephone_mobile, String date_naissance) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email); this.telephone_mobile = telephone_mobile; this.date_naissance = date_naissance;
    choice4 = true;  this.type = type;}
     
      public Connaissance(){
        this.type = type;  
 JTextField textField1 = new JTextField();
         JTextField textField2 = new JTextField();
         JTextField textField3 = new JTextField();
         JTextField textField4 = new JTextField();
         JTextField textField5= new JTextField();
         JTextField textField6= new JTextField();
         JTextField textField7= new JTextField();
         JTextField textField8= new JTextField();
         JTextField textField9= new JTextField();
      


         Object[] inputFields = {" Nom : ", textField1,
                 "Prénom : ", textField2, "Adresse", textField3, "Code Postal ", textField4, "Ville", textField5, "Téléphone", textField6, "Email", textField7, "Teléphone mobile", textField8, "Date Anniversaire", textField9};
              JOptionPane.showConfirmDialog(null, inputFields, "Création d'un contact : Connaissance", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
   
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
              date_naissance = textField9.getText(); 
     }
     
     
      @Override
    public void affiche() {
         
         }
     @Override
     public TYPE getType(){
        return TYPE.CONNAISSANCE;
    } 
     
     public int compareTo(Object personne) {
   	  
         return (((Connaissance)this).getNom()).compareTo( ((Connaissance)personne).getNom());

 }
      

     @Override
     public String toString(){
String str;
        
         if(choice2 == true){
        str = nom + " " + prenom + " " + adresse + " " + code_postal + " " + ville + " " + telephone + " " + email + " \n";
         }else if(choice1 == true){
                str =  nom + " " + prenom + " " + telephone + "\n ";
         }else if (choice3 == true){
                 str =  nom + " " + prenom + " " + adresse + " " + code_postal + " " + ville + " " + telephone + " " + email + " " + telephone_mobile + "\n ";
         }else{
             str =  nom + " " + prenom + " " + adresse + " " + code_postal + " " + ville + " " + telephone + " " + email + " " + telephone_mobile + " " + date_naissance + "\n"; }
 return str;    

}

  
    
}