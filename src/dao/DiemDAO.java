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
import model.Diem;

/**
 *
 * @author Admin
 */
public class DiemDAO {
    
    public static ArrayList<Diem> getAllDiem(){
        
        ArrayList<Diem> listDiem = new ArrayList<>();
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql =  "SELECT * FROM Diem";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String MaSV = rs.getString("MaSV");
                String MaMH = rs.getString("MaMH");
                int HocKy = rs.getInt("HocKy");
                int Lan = rs.getInt("Lan");
                float Diem = rs.getFloat("Diem");
                listDiem.add(new Diem(MaSV,MaMH,HocKy,Lan,Diem));
            }
            
            return listDiem; 
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
    public static ArrayList<Diem> getDiemByMaSV(String MaSV){
        
        ArrayList<Diem> listDiem = new ArrayList<>();
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql  = "SELECT * FROM Diem WHERE MaSV = ?";
            
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(0, MaSV);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String MaMH =  rs.getString("MaMH");
                int HocKy = rs.getInt("HocKy");
                int Lan = rs.getInt("Lan");
                float Diem = rs.getFloat("Diem");
                
                listDiem.add(new Diem(MaSV,MaMH,HocKy,Lan,Diem));
            }
            return listDiem;
            
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      public static ArrayList<Diem> getDiemByMaMH(String MaMH){
        ArrayList<Diem> listDiem = new ArrayList<>();
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql  = "SELECT * FROM Diem WHERE MaMH = ?";
            
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(0, MaMH);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String MaSV =  rs.getString("MaSV");
                int HocKy = rs.getInt("HocKy");
                int Lan = rs.getInt("Lan");
                float Diem = rs.getFloat("Diem");
                
                listDiem.add(new Diem(MaSV,MaMH,HocKy,Lan,Diem));
            }
            return listDiem;
            
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
      public static ArrayList<Diem> getDiemByLan(int Lan){
        ArrayList<Diem> listDiem = new ArrayList<>();
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql  = "SELECT * FROM Diem WHERE Lan = ?";
            
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(0, Lan);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String MaSV =  rs.getString("MaSV");
                String MaMH =  rs.getString("MaMH");
                int HocKy = rs.getInt("HocKy");
                float Diem = rs.getFloat("Diem");
                
                listDiem.add(new Diem(MaSV,MaMH,HocKy,Lan,Diem));
            }
            return listDiem;
            
        } catch (SQLException ex) {
            Logger.getLogger(DiemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
      
      
    public static void addDiem(Diem diem) throws SQLException {
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "INSERT INTO Diem(MaSV,MaMH,HocKy,Lan,Diem) VALUES(?,?,?,?,?)";
        
            PreparedStatement ps;

            ps = connection.prepareStatement(sql);
            ps.setString(1, diem.getMaSV());
            ps.setString(2, diem.getMaMH());
            ps.setInt(3, diem.getHocKy());
            ps.setInt(4, diem.getLan());
            ps.setFloat(5, diem.getDiem());
            
            ps.executeUpdate();

    }
    
        public static void updateDiem(Diem diem) throws SQLException {
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "UPDATE Diem SET MaSV = ?, MaMH = ?, HocKy = ?, Lan = ?, Diem = ?";
        
            PreparedStatement ps;

            ps = connection.prepareStatement(sql);
            ps.setString(1, diem.getMaSV());
            ps.setString(2, diem.getMaMH());
            ps.setInt(3, diem.getHocKy());
            ps.setInt(4, diem.getLan());
            ps.setFloat(5, diem.getDiem());
            
            ps.executeUpdate();

    }
    
    
    
    
    
    
    
    
    
    public static void deleteDiemByIdSV(String id){
     
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "DELETE FROM Diem WHERE MaSV = " + "'" + id + "'";
            
        Statement st;
        try {
            st = connection.createStatement();
     
            st.executeUpdate(sql);
                 
        } catch (SQLException ex) {
            Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

}
