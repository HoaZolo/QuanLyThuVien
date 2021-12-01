/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTVModel;

import java.util.ArrayList;

/**
 *
 * @author WIN1064
 */
public class PhieuMuaChiTiet {
    private String maMua,maSV,ngayDat,ghiChu;
    private ArrayList<SachClass> arrSach;
    private int daTra,tienPhaiTra;

    public PhieuMuaChiTiet(String maMua, String maSV, String ngayDat, String ghiChu, ArrayList<SachClass> arrSach,int tienPhaiTra, int daTra) {
        this.maMua = maMua;
        this.maSV = maSV;
        this.ngayDat = ngayDat;
        this.ghiChu = ghiChu;
        this.arrSach = arrSach;
        this.daTra = daTra;
        this.tienPhaiTra = tienPhaiTra;
    }

    public PhieuMuaChiTiet() {
    }

    public void setMaMua(String maMua) throws Exception {
        if(maMua.trim().equals(""))
        {
            throw new Exception("mã mua trống");
        }
        this.maMua = maMua;
    }

    public void setMaSV(String maSV) throws Exception {
        if(maSV.trim().equals(""))
        {
            throw new Exception("mã sinh viên trống");
        }
        this.maSV = maSV;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setArrSach(ArrayList<SachClass> arrSach) throws Exception {
        if(arrSach.size() == 0)
        {
            throw new Exception("không có sách trong phiếu");
        }
        this.arrSach = arrSach;
    }

    public void setDaTra(int daTra) throws Exception {
        if(daTra != 0 && daTra != 1)
        {
            throw new Exception("trạng thái phiếu sai");
        }
        this.daTra = daTra;
    }

    public void setTienPhaiTra(int tienPhaiTra) {
        this.tienPhaiTra = tienPhaiTra;
    }
    
    public String getMaMua() {
        return maMua;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public ArrayList<SachClass> getArrSach() {
        return arrSach;
    }

    public int getDaTra() {
        return daTra;
    }

    public int getTienPhaiTra() {
        return tienPhaiTra;
    }

    @Override
    public String toString() {
        return "PhieuMuaChiTiet{" + "maMua=" + maMua + ", maSV=" + maSV + ", ngayDat=" + ngayDat + ", ghiChu=" + ghiChu + ", arrSach=" + arrSach + ", daTra=" + daTra + ", tienPhaiTra=" + tienPhaiTra + '}';
    }
    
}
