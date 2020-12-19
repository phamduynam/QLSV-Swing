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
    
    
}
