/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.testgruppprojekt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicla
 */
public class EmployeeQueries {
    
     private static final String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Stockholm";
     private static final   String USERNAME = "root";
     private static final String PASSWORD = "SUnny2001";
    
     
     
     static Connection connection = dbConnection.getConnection();
    
     
     private PreparedStatement selectAllEmployees;
     private PreparedStatement inserNewEmployee;
    
     
      public EmployeeQueries() {
      try {
         connection = 
            DriverManager.getConnection(URL, USERNAME, PASSWORD);

         // create query that selects all entries in the AddressBook 
        selectAllEmployees = connection.prepareStatement(
            "SELECT * FROM employees ORDER BY lName, fName");
         
        inserNewEmployee = connection.prepareStatement(         
            "INSERT INTO employee " +                           
            "(idEmployee,fName, lName, type) " +     
            "VALUES (?, ?, ?, ?)");                           
       
                                   
      } 
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         System.exit(1);
      } 
   } 
     
     public List<EmployeeEntiteClass> getAllEmployees() {
      // executeQuery returns ResultSet containing matching entries
      try (ResultSet resultSet = selectAllEmployees.executeQuery()) {
         List<EmployeeEntiteClass> results = new ArrayList<EmployeeEntiteClass>();
         
         while (resultSet.next()) {
            results.add(new EmployeeEntiteClass(
               resultSet.getInt("idEmployees"),
               resultSet.getString("fName"),
               resultSet.getString("lName"),
               resultSet.getString("type")));
         } 

         return results;
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();         
      }
      
      return null;
   }
      
       public int addEmployee(int idEmployee,String fName, String lName, 
      String Type) {
      
      // insert the new entry; returns # of rows updated
      try {
         // set parameters
         inserNewEmployee.setInt(1, idEmployee);
         inserNewEmployee.setString(2, fName);
         inserNewEmployee.setString(3, lName);
         inserNewEmployee.setString(4, Type);  

         return inserNewEmployee.executeUpdate();         
      }
      catch (SQLException sqlException) {
         sqlException.printStackTrace();
         return 0;
      }
   }
     
      
}
