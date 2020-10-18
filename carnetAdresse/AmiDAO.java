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

/**
 *
 * @author cda611
 */
public class AmiDAO {
    
    private String url; 
    private String username; 
    private String password; 
    
    public AmiDAO(String url, String username, String password){
        this.url = url; 
        this.username = username; 
        this.password = password; 
    }
    
    public void SaveAmi(Ami ami) throws SQLException{
        
        
		Connection connection = DriverManager.getConnection(url, username, password);
                
            
			PreparedStatement prepare = connection.prepareStatement("insert into dbo.Personne VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                        
			prepare.setString(1, ami.getNom());
			prepare.setString(2, ami.getPrenom());
			prepare.setLong(3, ami.getTelephone());
			prepare.setString(4, ami.getAdresse());
			prepare.setInt(5, ami.getCode_postal());
			prepare.setString(6, ami.getVille());
			prepare.setString(7, ami.getEmail());
                        prepare.setString(8, ami.getProprietaire());
			prepare.setLong(9, ami.getTelMobile());
                             prepare.setString(10, ami.getDateNaissance());
                        prepare.setString(11, ami.getTyp());
                        
			prepare.execute();
			
		
		System.out.println(ami.getNom() + " mis dans dbb");
		
		
	
	}

    
}


