/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author cda611
 */
public class CarnetAdresse extends Vector<Personne> implements Suppression, Affichage, Creation {

    Vector<Personne> carnet = new Vector<>();
    Personne personne = null;
    Personne autrePersonne;
    ArrayList<Personne> type;
    String nom;
    Scanner sc = new Scanner(System.in); 
    String prenom;
    String adresse;
    int code_postal;
    String ville;
    long telephone;
    String email;
    long telephone_mobile;
    String date_naissance; 
    String nouvNom;
    String nouvPrenom; 
    String nouvAdresse;
    String nouvCode;
    String nouvVille;
    String nouvTel; 
    String nouvEmail; 
    String nouvMobile; 
    String nouvDateNaiss;
    CarnetAdresse carnetModif;
    boolean lancement;
    String choix;
    String typ; 
    String proprio;
    Ami ami1;
    Ami ami;
    Connaissance con1; 
    Famille fam1;

  

    public CarnetAdresse() {
        carnet = new Vector<>();
    }
    
    public CarnetAdresse(String nom) {
       
        this.nom = nom;
        carnet = new Vector<>();
       
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void addList(Personne personne) {
        carnet.add(personne);
    }

    public void supprime() {
       
    }
    
    public void modifier(){
            System.out.println("Quelle personne voulez-vous modifier ? Entrez son nom \n"); 
    String persModif = sc.nextLine();
    
    for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(pers.getNom())){lancement = true;}
    }
    
    while (lancement = true)
    System.out.println(" Que voulez-vous modifier ? \n 1- Nom du contact \n 2- Prenom \n 3- Adresse \n 4- Code Postal \n 5 - Ville \n 6- Téléphone \n 7- Email \n 8- Téléphone mobile \n 9- Date de naissance \n");  
    
    
     choix = sc.nextLine(); 
    int inpChoix = Integer.parseInt(choix); 
    
    switch(inpChoix){
        
        case(1):
            
            for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvNom = sc.nextLine();  
             pers.setNom(nouvNom);
         
                }       
        case(2):
            
             for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvPrenom = sc.nextLine();  
             pers.setPrenom(nouvPrenom);
         
                }     
        case(3):
            
            for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvAdresse = sc.nextLine();  
             pers.setAdresse(nouvAdresse);
             
            }
             
        case(4):
            
            for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvCode = sc.nextLine();  
             pers.setCode_postal(Integer.parseInt(nouvCode));
             
            }
            
        case(5): 
            
            for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvVille = sc.nextLine();  
             pers.setVille(nouvVille);
             }
            
        case(6):
            
             for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvTel = sc.nextLine();  
             pers.setTelephone(Long.parseLong(nouvTel));
             }
            
        case(7): 
            
            for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvEmail = sc.nextLine();  
             pers.setEmail(nouvEmail);
             }
            
        case(8): 
            
             for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvMobile = sc.nextLine();  
             pers.setTelephone_mobile(Long.parseLong(nouvMobile));
             }
            
        case(9): 
            
             for (Personne pers : carnetModif){
            if(persModif.equalsIgnoreCase(carnetModif.getPersonne().getNom()))
             nouvDateNaiss = sc.nextLine();  
             pers.setDateNaissance(nouvDateNaiss);
             }
    
           
            }
    
    }
    
    public void supprime(Personne personne){ carnet.remove(personne);}

    public Personne getPersonne(){ for (Personne personne : carnet)  return personne;
        return personne;
    }
    @Override
    public void affiche() {
        
    if (telephone_mobile != 0 && date_naissance != null){
        String nomColonne = "Nom \t\t\tPrénom\t\t\tAdresse\t\t\t Code Postal\t\t\tVille\t\t\tTéléphone\t\t\tEmail\t\t\tTélephone mobile\t\t\tDate de naissance\n";
         System.out.println(nomColonne);
         for (Personne pers : carnet){
          
 System.out.println(pers.toString());
        
         }
            
             }else if (telephone_mobile != 0 && date_naissance == null){
                     
                     
     String nomColonne = "Nom \t\t\tPrénom\t\t\tAdresse\t\t\t Code Postal\t\t\tVille\t\t\tTéléphone\t\t\tEmail\t\t\tTélephone mobile\n";
     System.out.println(nomColonne);
                      for (Personne pers : carnet){
 System.out.println(pers.toString());
            }
      
                      
             }else{
 String nomColonne = "Nom \t\t\tPrénom\t\t\tAdresse\t\t\t Code Postal\t\t\tVille\t\t\tTéléphone\t\t\tEmail\n";
 System.out.println(nomColonne);
  for (Personne pers : carnet){
 System.out.println(pers.toString());
            };
      
       
             }}
       
        /*String str;
   
        Box box = Box.createVerticalBox();
        JCheckBox cbox1 = new JCheckBox("Nom");
        JCheckBox cbox2 = new JCheckBox("Code Postal");
        JCheckBox cbox3 = new JCheckBox("Type");
        box.add(cbox1);
        box.add(cbox2);
        box.add(cbox3);
        JOptionPane.showMessageDialog(null, box, "Comment souhaitez-vous triez les personnes", 1);
        
          if(cbox1.isSelected()){ str = carnet.toString();
           JOptionPane.showMessageDialog(null, str);}//à faire
        
        if(cbox2.isSelected()){;}
        
        if(cbox3.isSelected()){;}*/
        
 
  
    
    
    public void creer() {
      
      Box box = Box.createVerticalBox();
        JCheckBox cbox1 = new JCheckBox("Ami");
        JCheckBox cbox2 = new JCheckBox("Connaissance");
        JCheckBox cbox3 = new JCheckBox("Famille");
        box.add(cbox1);
        box.add(cbox2);
        box.add(cbox3);
        JOptionPane.showMessageDialog(null, box, "Quel type de contact ?", 1);
        
        if(cbox1.isSelected()){ Personne ami1 = new Ami(); carnet.add(ami1);}//à faire
        
        if(cbox2.isSelected()){Personne con1 = new Connaissance(); carnet.add(con1);}
        
        if(cbox3.isSelected()){Personne f1 = new Famille(); carnet.add(f1);}

    
    }
 
    
    public void  comparer(){

        System.out.println("Quel type de comparaison ?\n\t1- Selon le nom du contact ? \n\t2- Selon le code postal du contact ? \n\t3- N'affichez qu'un type de contact ?");  
        String input = sc.nextLine();
        int valeur = Integer.parseInt(input);
      
        
       if(valeur == 1){ 
        Collections.sort(carnet, new ComparatorsParNom());

    
          }else if(valeur == 2){  
              
Comparator<Personne> compareTotal = new ComparatorsParCP().thenComparing(new ComparatorsParNom());
            Collections.sort(carnet, compareTotal);
              
              }else if (valeur == 3){

        System.out.println("Quel type de contact voulez-vous ? \n\t\t 1- Connaissance ? 2- Ami ? 3- Famille ? ");
        String entree = sc.nextLine();
        int nb = Integer.parseInt(entree);

        Personne p2;

      switch (nb) {
        

          case 1:
          
          for (Personne p : carnet){
              if (TYPE.CONNAISSANCE == p.getType()){
                 type = new ArrayList<Personne>(); 
                  type.add(p);
              }
              System.out.println(type.toString());
          }    

              break;
      
          case 2:
       
          
          for (Personne p : carnet){
              if (TYPE.AMI == p.getType()){
                 type = new ArrayList<Personne>(); 
                  type.add(p);
              }
              System.out.println(type.toString());
            }
              break;

          case 3:
         
          for (Personne p : carnet){
              if (TYPE.FAMILLE == p.getType()){
                 type = new ArrayList<Personne>(); 
                  type.add(p);
              }
              System.out.println(type.toString());
            }
              break;

          default : System.out.println("Saisie incorrecte"); 
      }
                    
  }
   }
         
  
   
    @Override
    public String toString(){
        String str = "";
        str = "******\t\t\tCarnet d'Adresse\t\t\t******\n\n"; 
        str +=  carnet; 

       
       
        return str;
        
    }
     

  public static void main(String []args){
      
      CarnetAdresse c1 = new CarnetAdresse();
      
   c1.creer();
      Ami ami1 = new Ami("Pablo", "SEr", 02567, "45 rue loire", 85902, "loiret", "blabl@him", "monDeuxieme", "A" );
      c1.addList(ami1); 
      c1.affiche();
   
  } 

   public String getProprio() {
       return this.getNom();
    }

   
    

}
 
 
