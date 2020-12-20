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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import model.SinhVien;

/**
 *
 * @author Admin
 */
public class SinhVienDAO {
    
    public static ArrayList<SinhVien> getAllSinhVien(){
        ArrayList<SinhVien> listSinhVien  = new ArrayList<>();
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "SELECT * FROM SinhVien";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            while(rs.next()){
                String MaSV = rs.getString("MaSV");
                String Ho = rs.getString("Ho");
                String Ten = rs.getString("Ten");
                boolean Phai = rs.getBoolean("Phai");
                Date NgaySinh = rs.getDate("NgaySinh");
                String NoiSinh = rs.getString("NoiSinh");
                String DiaChi = rs.getString("DiaChi");
                String GhiChu = rs.getString("GhiChu");
                boolean NghiHoc = rs.getBoolean("NghiHoc");
                String MaKH = rs.getString("MaKH");
               
                if(NgaySinh == null){
                    NgaySinh= new Date();
                }
                 System.out.println(" : " + NgaySinh);
                listSinhVien.add(new SinhVien(
                        MaSV,
                        Ho,
                        Ten,
                        Phai,
                        formatter.format(NgaySinh),
                        NoiSinh,
                        DiaChi,
                        GhiChu,
                        NghiHoc,
                        MaKH     
                ));
            }
            
            return listSinhVien;
        } catch (SQLException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static void addSinhVien(SinhVien sinhVien) throws SQLException {
        
        Connection connection = JDBCConnection.getJDBCCOnection();
        
        String sql = "INSERT INTO SinhVien VALUES(?,?,?,?,?,?,?,?,?,?)";
        
            PreparedStatement ps;

            ps = connection.prepareStatement(sql);
            
            ps.setString(1, sinhVien.getMaSV());
            ps.setString(2, sinhVien.getHo());
            ps.setString(3, sinhVien.getTen());
            ps.setBoolean(4, sinhVien.isPhai());
            ps.setString(5, sinhVien.getNgaySinh());
            ps.setString(6, sinhVien.getNoiSinh());  
            ps.setString(7, sinhVien.getDiaChi());
            ps.setString(8, sinhVien.getGhiChu());
            ps.setBoolean(9, sinhVien.isNghiHoc());
            ps.setString(10, sinhVien.getMaKH());
            
            ps.executeUpdate();

    }
      public static  boolean addSinhVien_1(SinhVien sv){
        String sql = "INSERT INTO SinhVien (MaSV,Ho,Ten,Phai,NgaySinh,NoiSinh,DiaChi,GhiChu,NghiHoc,MaKH) VALUES(?,?,?,?,?,?,?,?,?,?)";
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Connection conn = null;
        try {
            conn = JDBCConnection.getJDBCCOnection();
            conn.setAutoCommit(false);
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setString(1, sv.getMaSV());
            st.setString(2, sv.getHo());
            st.setString(3, sv.getTen());
            st.setBoolean(4, sv.isPhai());
            st.setString(5, sv.getNgaySinh());
            st.setString(6, sv.getNoiSinh());
            st.setString(7, sv.getDiaChi());
            st.setString(8, sv.getDiaChi());
            st.setBoolean(9, sv.isNghiHoc());
            st.setString(10, sv.getMaKH());
            st.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                if (conn != null)
                  conn.rollback();
                
              } catch (SQLException se2) {
                se2.printStackTrace();
              }
            return false;
        }
        
        return true;
    }
    
    
    
}
