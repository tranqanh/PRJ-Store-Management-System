/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DBUntils {
     public static Connection getcon(){
        final String url = "jdbc:sqlserver://localhost:1433;databaseName=FoodManagement";
        final String user = "sa";
        final String password = "123456vn";
        
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        Connection connection = getcon();
        
        if(connection != null)
            System.out.println("Connection successful\n"+connection);
        else
            System.out.println("Connection fail");
    }
}
