/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

import static com.carnetAdresse.BddCarnet.result;
import static com.carnetAdresse.BddCarnet.resultMeta;
import static com.carnetAdresse.BddCarnet.state;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author cda611
 */
public class GestionnaireCarnetAdresse {
    
    CarnetAdresse carnet;
    Scanner sc = new Scanner(System.in);
    int i = 3;
    int j = 3;
    ArrayList<CarnetAdresse> GestionCarnet;
    String nomCarnet;
    CarnetAdresse carnetModif;
    Statement state;
    ResultSet resulta;
    String url = "jdbc:sqlserver://localhost:1433;databaseName=Carnet_Adresse;";
	String user = "sa";
	String password = "sa";

    ResultSetMetaData resultMeta;
    CarnetAdresseDAO caDAO;
     String input; 
   
     
    public GestionnaireCarnetAdresse(){GestionCarnet = new ArrayList<CarnetAdresse>();}
    
    //Création d'un nouveau carnet qui sera dans le gestionnaire
    
    public void init() throws Exception{
    int result = JOptionPane.showConfirmDialog(null, "Est-ce un nouveau carnet ? ", "Gestionnaire de carnet", JOptionPane.YES_NO_OPTION, 1);

     if( result== JOptionPane.YES_OPTION){
         String nom = JOptionPane.showInputDialog(null, "Donnez un nom à votre carnet : "); 
         CarnetAdresse c1 = new CarnetAdresse(nom);
         caDAO = new CarnetAdresseDAO(url, user, password); 
         caDAO.SaveCarnet(c1);
         GestionCarnet.add(c1);
     }
           
    
     if( result== JOptionPane.NO_OPTION){
         String nom = JOptionPane.showInputDialog(null, "Quel est le nom de votre carnet : ");
          String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=Carnet_Adresse;user=sa;password=sa";
        Connection connect = null;

       

        try {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
            } catch (Exception e) {
                System.out.println("échec driver");
            }
            connect = DriverManager.getConnection(connectionUrl);
           
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Echec");
        }      
        try{
         state = connect.createStatement();
         }catch (SQLException e){
        System.out.println(e.getMessage());}
        
        
        //requête SQL 
        
                 resulta = state.executeQuery("SELECT * FROM Carnet_Adresse WHERE NOM_PROPRIETAIRE =  " + nom);
   
                 resultMeta = resulta.getMetaData();
                 
                  
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
          
                
                
           while(resulta.next()){
                    
                     for(int j = 1; j <= resultMeta.getColumnCount()  ; j++)
                      System.out.print("\t" + resulta.getObject(j).toString() + "\t |");
                     System.out.println("\n");


           }   
            
       
            
    }
     }
    
    
    
    //Création de contact et sauvegarde dans bdd
    
    public void ajouterElmnt() throws SQLException{
    
    System.out.println("Souhaitez vous ajouter des contacts à votre carnet ? \n O pour Oui\t\t\t N pour Non");
    String reponse = sc.nextLine(); 
    
    if (reponse.equalsIgnoreCase("O")){
        
        carnet.creer();}
    else if(reponse.equalsIgnoreCase("N")){System.out.println("Bonne journée !");}
    else{
        while(i > 3){
    System.out.println("Entrée incorrecte. Entrée accepté O ou N. Il vous reste : " + i + "chances");
    --i;
    ajouterElmnt();
        caDAO = new CarnetAdresseDAO();
        caDAO.SaveCarnet(carnet);}}
    
    }  
    
    //Vérifies que le nom affecté au carnet est dispo. Lance une RTException
    public void check(String nom) throws Exception{
    
        for (CarnetAdresse carnet : GestionCarnet){
            if (carnet.getNom() == nom){ throw RuntimeException("Le nom existe déjà");
        }else{
             System.out.println("Votre nouveau carnet s'appelle : " + input);   
            }
        
    }
    }
    
    //retourne un carnet Méthode à checker
    public CarnetAdresse getCarnet(String nomCarnet){
        System.out.println("Quel est le nom de votre carnet ? \n");
         this.nomCarnet = sc.nextLine(); 
        return carnet;}
     
    
    //Affichage gestionnaire
    public void afficher(){
        
        System.out.println("Vous êtes dans votre gestionnaire de carnet\n\n"); 
        carnet.comparer();
     for (CarnetAdresse ca : GestionCarnet){
         System.out.println("\t\t\t\t*****************************");
         System.out.println("Ce carnet s'appelle : " + carnet.getNom() + "\n");
         ca.toString();
     }   
       
    }
    
    
    //Checker l'appel au méthode
    public void supprimer(){
        
    System.out.println("Que voulez-vous supprimer ?  1- Un carnet ? 2- Un contact ");
    String reponse = sc.nextLine();
    
    if (reponse.equals(2)){
        CarnetAdresse carnetRecherche = getCarnet(nomCarnet);
        
        
        System.out.println("Entrez le nom de la personne\n");
        String recherche = sc.nextLine(); 
        
        for(Personne pers : carnetRecherche){
        if(carnetRecherche.getPersonne().getNom().equals(recherche));
       
        carnet.supprime(pers);
        }
        }
    
    
    System.out.println("Quel carnet voulez-vous supprimer ? Entrez son nom : ");
    String suppression = sc.nextLine();
    for (CarnetAdresse carnet : GestionCarnet){
        if (suppression.equalsIgnoreCase(carnet.getNom())){
            GestionCarnet.remove(carnet);
            System.out.println("Suppression réussie ! ");
            
    }else {
            System.out.println("Votre carnet est introuvable ! Veuillez recommencer ");
            while (j > 3){supprimer();}
            -- j;
        }
    }}
    
    
    //Le corps de la méthode à mettre dans CarnetAdresse
    public void modifier(){
        
    System.out.println("Quel carnet voulez-vous modifier ? Entrez son nom : ");
    String modif = sc.nextLine();
    
    
     for (CarnetAdresse carnet : GestionCarnet){
         if (modif.equalsIgnoreCase(carnet.getNom())){
   
             carnetModif = carnet;
             carnetModif.modifier();
        }
     }
     

  
    }
    
    
    public static void main (String[] args) throws Exception{
        GestionnaireCarnetAdresse g1 = new GestionnaireCarnetAdresse(); 
       
        g1.init();
        g1.afficher();
        g1.modifier();
    }

    private Exception RuntimeException(String le_nom_existe_déjà) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
