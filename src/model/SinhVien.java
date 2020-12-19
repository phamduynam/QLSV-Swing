/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class SinhVien {
    private String MaSV;
    private String Ho;
    private String Ten;
    private boolean Phai;
    private String NgaySinh;
    private String NoiSinh;
    private String DiaChi;
    private String GhiChu;
    private boolean NghiHoc;
    private String MaKH;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String Ho, String Ten, boolean Phai, String MaKH) {
        this.MaSV = MaSV;
        this.Ho = Ho;
        this.Ten = Ten;
        this.Phai = Phai;
        this.MaKH = MaKH;
    }

    public SinhVien(String MaSV, String Ho, String Ten, boolean Phai, String NgaySinh, String NoiSinh, String DiaChi, String GhiChu, boolean NghiHoc, String MaKH) {
        this.MaSV = MaSV;
        this.Ho = Ho;
        this.Ten = Ten;
        this.Phai = Phai;
        this.NgaySinh = NgaySinh;
        this.NoiSinh = NoiSinh;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
        this.NghiHoc = NghiHoc;
        this.MaKH = MaKH;
    }



    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public boolean isPhai() {
        return Phai;
    }

    public void setPhai(boolean Phai) {
        this.Phai = Phai;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNoiSinh() {
        return NoiSinh;
    }

    public void setNoiSinh(String NoiSinh) {
        this.NoiSinh = NoiSinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public boolean isNghiHoc() {
        return NghiHoc;
    }

    public void setNghiHoc(boolean NghiHoc) {
        this.NghiHoc = NghiHoc;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }
    
    public Object[] toArray(){
        return new Object[]{this.MaSV,this.Ho,this.Ten,this.Phai,this.NgaySinh,this.NoiSinh,this.DiaChi,this.NghiHoc,this.MaKH};
    }
    
    
            
}
