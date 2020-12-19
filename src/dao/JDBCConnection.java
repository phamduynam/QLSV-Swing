/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JDBCConnection {
    
    // Trả về một kết nối DB
    public static Connection getJDBCCOnection(){
        String dbURL = "jdbc:sqlserver://CETRICK;databaseName=TEST";
        String username = "sa";
        String password = "root";
        try {
            // khai báo loại thư viện kết nối DB
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            return  DriverManager.getConnection(dbURL,username,password);
            
        } catch (SQLException ex) {
            System.out.println("==== CAN NOT CONNECT TO DATA BASE ====");
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("==== CLASS CONNECT NOT FOUND ====");
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
