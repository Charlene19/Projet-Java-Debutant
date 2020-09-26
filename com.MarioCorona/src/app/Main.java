package app;

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.event.*;

public class Main {

    public static Scene scene;


    public static void main(String[] args){
        JFrame fenetre = new JFrame("Mario "); 
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(700, 360);
        fenetre.setLocationRelativeTo(null);
        fenetre.setResizable(true);
        fenetre.setAlwaysOnTop(true);

        Scene scene = new Scene(); 

        fenetre.setContentPane(scene); 
        fenetre.setVisible(true); 
    }
}