/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openjfx.testgruppprojekt;

/**
 *
 * @author nicla
 */
public class EmployeeEntiteClass {
    
    int idEmployees;
    String fName;
    String lName;
    String type;
    
    
    public EmployeeEntiteClass(){}
       
       public EmployeeEntiteClass(int idEmployees, String fName, String lName, String type){
       
           this.idEmployees = idEmployees;
           this.fName = fName;
           this.lName = lName;
           this.type = type;
        
       
    
       }

    public int getIdEmployee() {
        return idEmployees;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployees = idEmployee;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getType() {
        return type;
    }

    public void setType(String Type) {
        this.type = type;
    }
    @Override
    public String toString() 
      {return getlName() + ", " + getfName();}
}
    
    

        

        
        
        
