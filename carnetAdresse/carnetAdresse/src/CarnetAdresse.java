/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author cda611
 */
public class CarnetAdresse implements Suppression, Affichage, Creation {

    Vector<Personne> carnet = new Vector<>();
    Personne personne = null;
    Personne autrePersonne;
    ArrayList<Personne> type;

    public CarnetAdresse() {
        carnet = new Vector<>();
    }

    public void addList(Personne personne) {
        carnet.add(personne);
    }

    public void supprime() {
        carnet.remove(personne);
    }

    @Override
    public void affiche() {
        String str;
   
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
        
        if(cbox3.isSelected()){;}
        
         
    }

    @Override
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
        Scanner sc = new Scanner(System.in);  
        String input = sc.nextLine();
        int valeur = Integer.parseInt(input);
      
        
       if(valeur == 1){ 
        Collections.sort(carnet, new ComparatorsParNom());

    
          }else if(valeur == 2){  

            Collections.sort(carnet, new ComparatorsParCP());
              
              }else if (valeur == 3){

        System.out.println("Quel type de contact voulez-vous ? \n\t\t\1- Connaissance ? 2- Ami ? 3- Famille ? ");
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
      Personne ami1 = new  Ami("Durand", "Jean", "45 rue des coquelicots", 75020, "Paris", 014, "durand@yahoo.com");
      Personne ami2 = new  Ami("Dupond", "Laurent", "45 rue des coquelicots", 83000, "Bordeaux", 014, "dupond@yahoo.com");
      c1.addList((Personne)ami1);
      c1.addList((Personne)ami2);
      c1.comparer();
    
     
      System.out.println(c1);
     
  
     
  } 


}
 
 
