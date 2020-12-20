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
public class MonHoc {
    private String MaMH;
    private String TenMH;
    private String MaKH;

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }
    public MonHoc() {
    }

    public MonHoc(String MaMH, String TenMH, String MaKH) {
        this.MaMH = MaMH;
        this.TenMH = TenMH;
        this.MaKH = MaKH;
    }



    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String TenMH) {
        this.TenMH = TenMH;
    }
    
    public Object[] toArray(){
        return new Object[]{this.MaMH,this.TenMH};
    }
}
