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

class ComparatorsParType implements Comparator<Personne> {

    @Override
    public int compare(Personne o1, Personne o2) {
       if (o1.getType() == o2.getType()){
        return  1;
       }else { return 0;
       
    }
}
}
    