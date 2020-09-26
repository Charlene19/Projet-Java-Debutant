/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author cda611
 */
public class ChoixConstructeur {
    
     public static void main(String[] args) {
        Box box = Box.createVerticalBox();
        JCheckBox cbox1 = new JCheckBox("Check me once");
        JCheckBox cbox2 = new JCheckBox("Check me twice");
        JCheckBox cbox3 = new JCheckBox("Check me thrice");
        box.add(cbox1);
        box.add(cbox2);
        box.add(cbox3);
        JOptionPane.showMessageDialog(null, box);
    }
    
}
