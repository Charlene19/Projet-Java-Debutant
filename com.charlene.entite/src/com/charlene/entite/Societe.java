package com.charlene.entite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



 class Societe {

    Etudiant etudiant;
     static ArrayList<Etudiant> listePersonnel;
    CompareEtudiant comparateur;

    public Societe() {
        listePersonnel = new ArrayList<Etudiant>();
      
    }

    public ArrayList getList() {
        return listePersonnel;
    }

    public void recruter(Etudiant etudiant) {
            Societe.listePersonnel.add(etudiant);
        
    }

    public void afficher() {
        String str = "";

        for (Etudiant etudiant : listePersonnel)

            System.out.println(str = "Identité de l'étudiant ----> " + etudiant.toString());

    }

    public void congedier(Etudiant etudiant) {
        if (listePersonnel.contains(etudiant)) {
            listePersonnel.remove(etudiant);
            System.out.println(etudiant.getPrenom() + " " + etudiant.getNom() + " quitte l'entreprise");
        }
    }
    @Override
    public int compare(Etudiant e1, Etudiant e2){}

    public static void main(String[] args) {

        Societe entreprise = new Societe();
        ArrayList<Etudiant> listePersonnel = entreprise.getList();
        Etudiant pers = new Etudiant("Durand", "Michel", 55);
        entreprise.recruter(new Etudiant("Mercier", "Jean", 50));
        entreprise.recruter(new Etudiant("Morin", "Nathalie", 35));
        entreprise.recruter(new Etudiant("Martin", "Louis", 35));
        entreprise.recruter(new Etudiant("Charpentier", "Josette", 25));
        entreprise.recruter(new Etudiant("Charpentier", "Pierre", 25));
        entreprise.recruter(pers);
        entreprise.afficher();
        entreprise.congedier(pers);

        Collections.sort(listePersonnel, new CompareEtudiant());
        System.out.println(listePersonnel);

        Collections.reverseOrder(new CompareEtudiant());
        System.out.println(listePersonnel);

      

}



       
}