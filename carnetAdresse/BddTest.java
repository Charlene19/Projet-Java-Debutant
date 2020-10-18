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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class BddTest {

  static Statement state;
  static ResultSet result;
  
   static ResultSet result2;
  static ResultSetMetaData resultMeta;
  static ResultSetMetaData resultMeta2;
  
    public static void main(String[] args) throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=Carnet_Adresse;user=sa;password=sa";
        Connection connect = null;

        System.out.println("Lancement ");

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
        
                 result = state.executeQuery("SELECT * FROM Personne");
   
                 resultMeta = result.getMetaData();
                  System.out.println("\n\t\t\t\t********getColumnName()**********\n");
        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
           System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
                
                System.out.println("\n\n\t\t\t\t******getObject()************\n");  
           while(result.next()){
                    
                     for(int j = 1; j <= resultMeta.getColumnCount()  ; j++)
                      System.out.print("\t" + result.getObject(j).toString() + "\t |");
                     System.out.println("\n");


           }   
            
       
            
    }}


