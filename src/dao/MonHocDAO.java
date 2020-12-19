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
import model.MonHoc;

/**
 *
 * @author Admin
 */
public class MonHocDAO {
    public static ArrayList<MonHoc> getAllMonHoc(){
        
        ArrayList<MonHoc> listMonHoc = new ArrayList<>();
                
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "SELECT * FROM MonHoc";
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                String MaMH = rs.getString("MaMH");
                String TenMH = rs.getString("TenMH");
                
                listMonHoc.add(new MonHoc(MaMH, TenMH));
                
            }
            return listMonHoc;
            
        } catch (SQLException ex) {
            System.out.println("==== CAN NOT CONNECT ====");
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;               
    }
    
    public static void deleteMonHocById(String id){
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "DELETE FROM MonHoc WHERE MaMH = ?"; 
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(0,id);
            int rs = ps.executeUpdate();
            System.out.println("State Delete MonHoc is : " + rs);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addMonHoc(MonHoc monHoc){
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "INSERT INTO MonHoc VALUES(?,?)"; 
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(0,monHoc.getMaMH());
            ps.setString(2,monHoc.getTenMH());
            int rs = ps.executeUpdate();
            System.out.println("State Add Mon Hoc is : " + rs);
        } catch (SQLException ex) {
            Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
