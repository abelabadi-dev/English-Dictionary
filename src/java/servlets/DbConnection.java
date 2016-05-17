/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author abelo
 */
public class DbConnection {
   
    String url = "jdbc:mysql://localhost:3306/entries";
    String username = "admin";
    String password = "12345";
    public DbConnection() throws NamingException {
        
       

        System.out.println("Connecting database...");

        try (Connection connection = (Connection) DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    
//    public static void main(String[] args) throws NamingException{
//        DbConnection db = new DbConnection();
//    }
    
}
