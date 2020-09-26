package com.charlene.entite;

import javax.swing.*;

class Adresse {
    int numero_rue; 
    String nom_rue; 
    int codePostal; 
    String ville; 

    public Adresse(int numero_rue, String nom_rue, int codePostal, String ville){this.numero_rue = numero_rue; this.nom_rue = nom_rue; this.codePostal = codePostal; this.ville = ville;}

    public int getNumeroRue(){return numero_rue;}
    public void setNumeroRue(int numero_rue){this.numero_rue = numero_rue;}

    public String getNomRue(){return nom_rue;}
    public void setNomRue(String nom_rue){this.nom_rue = nom_rue;}

    public int getCodePostal(){return codePostal;}
    public void setCodePostal(int codePostal){this.codePostal = codePostal;}

    public String getVille(){return ville;}
    public void setVille(String ville){this.ville = ville;}

    public String toString(){ String str; 
    str = (numero_rue + " " + nom_rue + " " + codePostal +" " + ville); return str; }

    public static void main(String []args){

        JFrame frame = new JFrame("InputDialog Example #2");
        Adresse adresse1 = new Adresse(2, "rue Victor Hugo", 75008, "Paris");
        System.out.println(adresse1.toString());

      
       JOptionPane.showMessageDialog(frame, adresse1, "Adresse", JOptionPane.INFORMATION_MESSAGE);

       
        Adresse adresse2 = new Adresse(17, "rue de la République", 44000, "Nantes");
        System.out.println(adresse2.toString());

        Adresse adresse3 = new Adresse(55, "Bld de la Libération", 59000,  "Lille ");
        System.out.println(adresse3);

    }

   
}
class Personne1{
        
    private String prenom;
    private String nom;
    private int age;
    private Adresse adresse;

    public Personne1 (String prenom, String nom, int age, Adresse adresse){this.prenom = prenom; this.nom = nom; this.age = age; this.adresse = adresse;}

    public Personne1(Personne1 per1, Personne1 per2){ }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString(){ return prenom + " "+ nom  + "" + age + "ans, habite au " + adresse;
}
public static void main(String []args){


    
    Adresse adresse3 = new Adresse(55, "Bld de la Libération", 59000,  "Lille ");
    JFrame frame = new JFrame("InputDialog Example #2");
Personne1 pers1 = new Personne1("Jean", "Dupont", 30, adresse3);
    System.out.println(pers1.toString());
    pers1.setAdresse(new Adresse(17, "rue de la République", 44000, "Nantes"));

  
    Adresse adresse1 = new Adresse(55, "Bld de la Libération", 59000,  "Lille ");
    Personne1 pers2 = new Personne1("Nathalie", "Durand", 35, adresse1);

    Personne1 couple = new Personne1(pers1, pers2);

  
   JOptionPane.showMessageDialog(frame, couple, "Adresse", JOptionPane.INFORMATION_MESSAGE);
}
}