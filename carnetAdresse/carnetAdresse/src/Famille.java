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
public class Famille extends Personne {
    
     long telephone_mobile; 
     String date_naissance;
     boolean mobile = false;
     boolean date = false;
     String Telmobile;
     TYPE type = TYPE.FAMILLE;
     
    
    public Famille(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email); this.type = type;
    }
    
    public Famille(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email, long telephone_mobile) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email); this.telephone_mobile = telephone_mobile;
        mobile = true; this.type = type;
    }
    
     public Famille(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email, long telephone_mobile, String date_naissance) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email); this.telephone_mobile = telephone_mobile; this.date_naissance = date_naissance;
        date = true; 
        mobile = true;
        this.type = type;
    }
    
     public Famille(){
         
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
              JOptionPane.showConfirmDialog(null, inputFields, "Création d'un contact : Famille", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
   
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
     
    public long getTelephone_mobile() {
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
        return TYPE.FAMILLE;
    }
    
    public String toString(){
      String str;
        
        str = nom + " " + prenom + " " + adresse + " " + ville + " " + telephone + " " + email + " ";
                str +=  (mobile == true) ?  telephone_mobile : " "; 
                 str +=  (date == true) ?  date : " "; 
                 
                 return str;
    }
    
    /*Locale locale = new Locale("fr", "FR");
DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
String date = dateFormat.format(new Date());
System.out.print(date);*/

  
 
}
    