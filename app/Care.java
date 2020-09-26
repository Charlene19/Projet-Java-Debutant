package app;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.Serializable;

import java.awt.Dimension;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;


public class Care extends JFrame implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel conteneur = new JPanel(); 
private JButton soumission = new JButton("Soumettre");
private Dimension d2 = new Dimension (150, 30);

private JLabel accueil, poids, imc, date, retourImc, taille;
private JTextField inputPoids = new JTextField(null, 4);
private JTextField inputTaille = new JTextField(null, 4);
private Date actuelle = new Date();
private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
private String dat = dateFormat.format(actuelle);
private Double imcR;



   public Care(){
   
        this.setSize(240, 300);
        this.setTitle("CareA");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        //On initialise le conteneur avec tous les composants
          initComposant();
          //On ajoute le conteneur
        this.setContentPane(conteneur);
        this.setVisible(true);
      }

      private void initComposant(){

    Font police = new Font("Arial", Font.BOLD, 20);
    accueil = new JLabel("Bonjour ! ");
    accueil.setFont(police);
    accueil.setHorizontalAlignment(JLabel.CENTER);
    accueil.setPreferredSize(new Dimension(220, 20));

    poids = new JLabel("Poids : ");
    poids.setFont(police);
    poids.setHorizontalAlignment(JLabel.LEFT);
    poids.setPreferredSize(new Dimension(220, 20));

    imc = new JLabel("IMC : ");
    imc.setFont(police);
    imc.setHorizontalAlignment(JLabel.LEFT);
    imc.setPreferredSize(new Dimension(220, 20));
    
    inputTaille.setText(".");
    inputTaille.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Text=" + inputPoids.getText());
        } });

    inputPoids.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println("Text=" + inputPoids.getText());
        } });
    
    soumission.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            imc();
            retourImc = new JLabel(conversion());
            System.out.println(retourImc);
        }
    });
    
    taille = new JLabel("Taille : ");
    taille.setFont(police);
    taille.setHorizontalAlignment(JLabel.LEFT);
    taille.setPreferredSize(new Dimension(220, 20));


    retourImc = new JLabel("0");
    retourImc.setFont(police);
    retourImc.setHorizontalAlignment(JLabel.RIGHT);
    retourImc.setPreferredSize(new Dimension(220, 20));

    date = new JLabel(dat);
    date.setFont(police);
    date.setHorizontalAlignment(JLabel.CENTER);
    date.setPreferredSize(d2);


    conteneur.add(accueil, BorderLayout.NORTH);
    conteneur.add(date, BorderLayout.NORTH);
    conteneur.add(poids, BorderLayout.WEST);
    conteneur.add(inputPoids, BorderLayout.EAST);
    conteneur.add(taille, BorderLayout.WEST);
    conteneur.add(inputTaille, BorderLayout.EAST);
    conteneur.add(imc, BorderLayout.WEST);
    conteneur.add(retourImc, BorderLayout.NORTH);
    conteneur.add(soumission, BorderLayout.SOUTH);


      }
    public Double imc(){

       Double masse = Double.valueOf(inputPoids.getText());
       Double hauteur = Double.valueOf(inputTaille.getText());

        imcR =masse/(hauteur*hauteur);
       return imcR;
    }

   public String conversion(){
	   if (imcR < 25.0) {
		   retourImc.setForeground(Color.green);
	   }else {
		   retourImc.setForeground(Color.red);
	   }
    String s = Double.toString(imc());
   retourImc.setText(s);
   

    return s;
   
}}