/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

/**
 *
 * @author cda611
 */
import java.util.Comparator;

class ComparatorsParNom implements Comparator<Personne> {

    @Override
    public int compare(Personne o1, Personne o2) {
       
        return o1.getNom().compareTo(o2.getNom());
    }
}