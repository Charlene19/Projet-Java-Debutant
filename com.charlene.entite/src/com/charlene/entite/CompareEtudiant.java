package com.charlene.entite;

import java.util.Collections;
import java.util.Comparator;

class CompareEtudiant implements Comparator <Etudiant>{


@Override
    public int compare(Etudiant p1, Etudiant p2){
       

        if (!p1.getNom().equalsIgnoreCase(p2.getNom())){
       return p1.getNom().compareTo(p2.getNom());}

        else if(p1.getNom().equalsIgnoreCase(p2.getNom())){
         return p1.getPrenom().compareTo(p2.getPrenom());
        }

        else if(p2.getPrenom().equalsIgnoreCase(p2.getPrenom())){
       return  Integer.compare(p1.getAge(), p2.getAge());
        }
        return 0;



    }
    
}