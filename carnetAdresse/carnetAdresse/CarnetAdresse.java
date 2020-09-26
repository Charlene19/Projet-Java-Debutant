/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Collections;
import java.util.Comparator;
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
Personne personne;
Personne autrePersonne;


    public CarnetAdresse(){carnet = new Vector<>();
    carnet.add(personne);}
    
    

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
        
        
         Collections.sort(carnet);
     
    }
    
    @Override
    public String toString(){
        String str; 
        return str = "Ceci est un  : " + 
                carnet.toString();
        
    }
    
  


  public static void main(String []args){
      
      CarnetAdresse c1 = new CarnetAdresse(); 
      c1.creer();
      c1.creer();
    
      c1.comparer();
     
      System.out.println(c1.toString());
     
  
      
  } 
  //  return ((this.getNom())).compareTo( ((Personne)personne).getNom());
  
  public static class NomComparator implements Comparator{
      
      public int compare(Object personne, Object autrePersonne) {
            return ((((Personne)personne).getNom())).compareTo(((Personne)autrePersonne).getNom());
      }
  }
      
   public static class CodePostalComparator implements Comparator {
public int compare(Object personne, Object autrePersonne) {
    return ((((Personne)personne).getCode_postal())) - ((Personne)autrePersonne).getCode_postal();
      }
   }
   
   public static class TypeComparator implements Comparator {
public int compare(Object personne, Object autrePersonne) {
    
    return ((((Personne)personne).getType())).compareTo(((Personne)autrePersonne).getType());
      }
   
}
   }
