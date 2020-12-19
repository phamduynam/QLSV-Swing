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
public class Lop {
    private String MaLop;
    private String TenLop;
    private String MaMH;

    public Lop() {
    }

    public Lop(String MaLop, String TenLop, String MaMH) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
        this.MaMH = MaMH;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String MaMH) {
        this.MaMH = MaMH;
    }
    
    public Object[] toArray(){
        return new Object[]{this.MaLop,this.TenLop,this.MaMH};
    }
}
