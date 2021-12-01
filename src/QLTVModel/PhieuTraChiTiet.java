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
public class PhieuTraChiTiet {
    private String maPhieu,maSV,ngayMuon,NgayTra;
    private ArrayList<SachClass> arrSach;
    private int daTra;
    private double tienCoc;
    private double tienPhat;
    public PhieuTraChiTiet() {
        
    }
    public PhieuTraChiTiet(String maPhieu, String maSV, String ngayMuon,  String NgayTra, ArrayList<SachClass> arrSach, int daTra, double tienCoc, double tienPhat) {
        this.maPhieu = maPhieu;
        this.maSV = maSV;
        this.ngayMuon = ngayMuon;
   
        this.NgayTra = NgayTra;
        this.arrSach = arrSach;
        this.daTra = daTra;
        this.tienCoc = tienCoc;
        this.tienPhat = tienPhat;
    }
    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

   

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }

    public void setArrSach(ArrayList<SachClass> arrSach) {
        this.arrSach = arrSach;
    }

    public void setDaTra(int daTra) {
        this.daTra = daTra;
    }

    public void setTienCoc(double tienCoc) {
        this.tienCoc = tienCoc;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public ArrayList<SachClass> getArrSach() {
        return arrSach;
    }

    public int getDaTra() {
        return daTra;
    }

    public double getTienCoc() {
        return tienCoc;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    
    
}
