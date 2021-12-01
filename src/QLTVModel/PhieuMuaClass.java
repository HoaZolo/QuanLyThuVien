/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTVModel;

/**
 *
 * @author WIN1064
 */
public class PhieuMuaClass {
    private String maMua,ngayDat,ghiChu,maSV;
    private int daTra;

    public PhieuMuaClass(String ngayDat, String ghiChu, String maSV, int daTra) {
        this.ngayDat = ngayDat;
        this.ghiChu = ghiChu;
        this.maSV = maSV;
        this.daTra = daTra;
    }
    
    public PhieuMuaClass(String maMua, String ngayDat, String ghiChu, String maSV, int daTra) {
        this.maMua = maMua;
        this.ngayDat = ngayDat;
        this.ghiChu = ghiChu;
        this.maSV = maSV;
        this.daTra = daTra;
    }

    public PhieuMuaClass() {
    }

    public String getMaMua() {
        return maMua;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getMaSV() {
        return maSV;
    }

    public int getDaTra() {
        return daTra;
    }

    public void setMaMua(String maMua) throws Exception {
        if(maMua.trim().equals(""))
        {
            throw new Exception("mã mua trống");
        }
        this.maMua = maMua;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setMaSV(String maSinhVien) throws Exception {
        if(maSinhVien.trim().equals(""))
        {
            throw new Exception("mã sinh viên trống");
        }
        this.maSV = maSinhVien;
    }

    public void setDaTra(int daTra) throws Exception {
        if(daTra != 0 && daTra != 1)
        {
            throw new Exception("trạng thái phiếu sai");
        }
        this.daTra = daTra;
    }
    
}
