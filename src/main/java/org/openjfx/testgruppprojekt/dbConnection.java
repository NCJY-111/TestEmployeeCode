package org.openjfx.testgruppprojekt;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Simons
 */
public class dbConnection {
    
    
    private static Connection connection = null; //connection variables
    
    static 
          {
        String URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Stockholm";
        String USERNAME = "root";
        String PASSWORD = "SUnny2001";
     try{
            String DB_DRIVER = "com.mysql.jdbc.Driver";
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            

        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
        public static Connection getConnection()
    {
        return connection;
    }
}
        


/*/Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            insertNewPerson = connection.prepareStatement("INSERT INTO patron " + "(idPatron, fName, lName, email, ssn, streetName, postalcode, city, type, maxAmount " + 
                    "VALUES(?,?,?,?,?,?,?,?,?,?)");
            insertNewPerson.setInt(1, 1);
            insertNewPerson.setString(2, "Linus");
            insertNewPerson.setString(3,"Linusberg");
            insertNewPerson.setString(4, "asd123@hotmail.com");
            insertNewPerson.setInt(5, 199501);
            insertNewPerson.setString(6, "bananvägen 6");
            insertNewPerson.setInt(7, 94472);
            insertNewPerson.setString(8, "Stockholm");
            insertNewPerson.setString(9, "student");
            insertNewPerson.setInt(10, 5);
            insertNewPerson.executeUpdate();
            connection.close(); */