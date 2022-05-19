/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.testgruppprojekt;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;




public class EmployeeController  {

    @FXML
    private Label idLabel;
    @FXML
    private Button AddEntryButton;
    @FXML
    private ListView<EmployeeEntiteClass> List;
    @FXML
    private TextField IDTextField;
    @FXML
    private TextField FirstNameTextField;
    @FXML
    private TextField LastNameTextField;
    @FXML
    private TextField TypeTextField;
    @FXML
    private Button BrowsAllButton;
   
     private final EmployeeQueries employeequeries = new EmployeeQueries();
     
     private final ObservableList<EmployeeEntiteClass> contactList = 
      FXCollections.observableArrayList();
    
    
   
    public void initialize() {
      List.setItems(contactList); 
      getAllEmployees(); 

      
      List.getSelectionModel().selectedItemProperty().addListener(
         (observableValue, oldValue, newValue) -> {
            displayContact(newValue);
         }
      );     
   }  
    
    private void getAllEmployees() {
      contactList.setAll(employeequeries.getAllEmployees()); 
     // selectFirstEntry();
   }
    
    private void selectFirstEntry() {
      List.getSelectionModel().selectFirst();          
   }

    
    private void displayContact(EmployeeEntiteClass Employee) {
      if (Employee != null) {
         //IDTextField.setText(int)(Employee.getIdEmployee());
         FirstNameTextField.setText(Employee.getfName());
         LastNameTextField.setText(Employee.getlName());
         TypeTextField.setText(Employee.getType());
      }
      else {
         FirstNameTextField.clear();
         LastNameTextField.clear();
         TypeTextField.clear();
         
      }
   }
    

    
    
    @FXML
    private void ShowAllEmployessButton(ActionEvent event) {
        
    }

}
