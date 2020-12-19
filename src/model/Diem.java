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
public class Diem {
    private String MaSV;
    private String MaMH;
    private int HocKy;
    private int Lan;
    private float Diem;

    public Diem() {
    }

    
    
    public Diem(String MaSV, String MaMH, int HocKy, int Lan, float Diem) {
        this.MaSV = MaSV;
        this.MaMH = MaMH;
        this.HocKy = HocKy;
        this.Lan = Lan;
        this.Diem = Diem;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public int getHocKy() {
        return HocKy;
    }

    public void setHocKy(int HocKy) {
        this.HocKy = HocKy;
    }

    public int getLan() {
        return Lan;
    }

    public void setLan(int Lan) {
        this.Lan = Lan;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }
    
    public Object[] toArray(){
        return new Object[]{this.MaSV,this.MaMH,this.HocKy,this.Lan,this.Diem};
    }
    
}
