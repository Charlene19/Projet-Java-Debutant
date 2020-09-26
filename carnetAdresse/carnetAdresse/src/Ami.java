/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



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

    
    public Ami(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email); this.type = type; 
    }
    
    public Ami(String nom, String prenom, String adresse, int code_postal, String ville, long telephone, String email, long telephone_mobile) {
        super(nom, prenom, adresse, code_postal, ville, telephone, email); this.telephone_mobile = telephone_mobile; mobile = true; this.type = type; 
    }
    
   
    public Ami(){
        this.type = type; 
        
        JTextField textField1 = new JTextField();
         JTextField textField2 = new JTextField();
         JTextField textField3 = new JTextField();
         JTextField textField4 = new JTextField();
         JTextField textField5= new JTextField();
         JTextField textField6= new JTextField();
         JTextField textField7= new JTextField();
         JTextField textField8= new JTextField();
      


         Object[] inputFields = {" Nom : ", textField1,
                 "Prénom : ", textField2, "Adresse", textField3, "Code Postal ", textField4, "Ville", textField5, "Téléphone", textField6, "Email", textField7, "Teléphone mobile", textField8};
              JOptionPane.showConfirmDialog(null, inputFields, "Création d'un contact : Ami", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
   
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
        return TYPE.AMI;
    }
    
    
    @Override
    public String toString(){String str;
   str = nom + " " + prenom + " " + adresse + " " + ville + " " + code_postal + " " + telephone + " " + email + " ";
                str +=  (mobile == true) ?  telephone_mobile + "\n" : "\n"; 
                return str;
}



   
}


