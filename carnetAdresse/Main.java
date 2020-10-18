/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

import java.sql.SQLException;

/**
 *
 * @author cda611
 */
public class Main {
    
    public static void main (String[] args) throws ClassNotFoundException, SQLException {
		
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Carnet_Adresse;";
	String user = "sa";
	String password = "sa";
    
       
	
        // public Personne(String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email)
   
       Connaissance ami2 = new Connaissance("Cl","Loui",012 , "18 rue de la mer",  589,  "Grenoble ", "claro.savary@yahoo.com" , "monDeuxieme", 205, "12/07/1987", "C");
       
       // public Connaissance(String nom, String prenom, long telephone, String adresse, int code_postal, String ville,  String email, String proprio, long telephone_mobile, String date_naissance) {
        PersonneDAO pDao = new PersonneDAO(url, user, password); 
        Ami ami3 = new Ami("moloko", "m", 25567, "3 rue lnire", 85902, "vaucluse", "toto@him", "monPremier", "A" );
        AmiDAO aDao = new AmiDAO(url, user, password);
        aDao.SaveAmi(ami3);
        
        
      // pDao.SavePersonne(ami2);
	}
    
}
