/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Lop;

/**
 *
 * @author Admin
 */
public class LopDAO {
 
    
    public static ArrayList<Lop> getAllLop(){
        ArrayList<Lop> listLop = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "SELECT * FROM Lop";
        
        Statement st;
        
        try {
            st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
             
            while(rs.next()){
                String maLop = rs.getString("MaLop");
                String tenLop = rs.getString("TenLop");
                String maMH = rs.getString("MaMH");
                
                listLop.add(new Lop(maLop,tenLop,maMH));
            }             
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLop;
    };
    
    public static void addLop(Lop lop) throws SQLException{
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "INSERT INTO Lop VALUES(?,?,?)" ;
        
        PreparedStatement st;

            st = connection.prepareStatement(sql);
            st.setString(1, lop.getMaLop());
            st.setString(2, lop.getTenLop());
            st.setString(3, lop.getMaMH());
           
            st.executeUpdate();
                 

    }
    
    
    
    
    
    public static void deleteLopById(String id){
     
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "DELETE FROM Lop WHERE MaLop = " + "'" + id + "'";
            
        Statement st;
        try {
            st = connection.createStatement();
     
            st.executeUpdate(sql);
                 
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
}
