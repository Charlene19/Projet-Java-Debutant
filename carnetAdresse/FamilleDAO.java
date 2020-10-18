package com.carnetAdresse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author cda611
 */
public class FamilleDAO {
    
    private String url; 
    private String username; 
    private String password; 
    
    public FamilleDAO(String url, String username, String password){
        this.url = url; 
        this.username = username; 
        this.password = password; 
    }
    
    public void SaveFamille(Personne personne){
        
        
		try {
		Connection connection = DriverManager.getConnection(url, username, password);
                
			PreparedStatement prepare = connection.prepareStatement("insert into dbo.personne VALUES(?,?,?,?,?,?,?,?,?,?,?)");
                        
			prepare.setString(1, personne.getNom());
			prepare.setString(2, personne.getPrenom());
                        prepare.setLong(3, personne.getTelephone());
                        prepare.setString(4, personne.getAdresse());
			prepare.setInt(5, personne.getCode_postal());
			prepare.setString(6, personne.getVille());
			prepare.setString(7, personne.getEmail());
			prepare.setString(8, personne.getProprietaire());
                        prepare.setLong(9, personne.getTelMobile());
                        prepare.setString(10, personne.getDateNaissance());
                        prepare.setString(11, personne.getTyp());
                       
			prepare.execute();
			
		
		System.out.println(personne.getNom() + " mis dans dbb");
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}

    void savePersonne(Personne personne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    }
