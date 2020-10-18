/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carnetAdresse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author cda611
 */
public class CarnetAdresseDAO {
    
    private String url; 
    private String username; 
    private String password; 
    Scanner sc = new Scanner(System.in);
    Connection connection;
    
    public CarnetAdresseDAO(String url, String username, String password) throws SQLException{
        this.url = url; 
        this.username = username; 
        this.password = password; 
        
        connection = DriverManager.getConnection(url, username, password);
    }
    
    public CarnetAdresseDAO() throws SQLException{
        System.out.println("Entrez vos informations de connexion: \n "); 
        System.out.println("Url : \n");
         url = sc.nextLine(); 
        System.out.println("User : \n");
         username = sc.nextLine(); 
        System.out.println("password : \n");
         password = sc.nextLine(); 
         
         connection = DriverManager.getConnection(url, username, password);
        
    }
    public void SaveCarnet(CarnetAdresse carnet) throws SQLException{
         
        connection = DriverManager.getConnection(url, username, password);
                
            
	PreparedStatement prepare = connection.prepareStatement("insert into dbo.CARNET_Adresse VALUES(?);");
        
        prepare.setString(1, carnet.getNom());
        
        prepare.execute();
				
	System.out.println(carnet.getNom() + " mis dans dbb");
		
		
	
	}
}

