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
public class PhieuMuonChiTiet {
    private String maPhieu,maSV,ngayMuon,ngayTra;
    private ArrayList<SachClass> arrSach;
    private int tienCoc;
    private String ghiChu;
    public PhieuMuonChiTiet() {
    }
    public PhieuMuonChiTiet(String maPhieu, String maSV, String ngayMuon,  String ngayTra, ArrayList<SachClass> arrSach, int tienCoc,String ghiChu) {
        this.maPhieu = maPhieu;
        this.maSV = maSV;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.arrSach = arrSach;
        this.tienCoc = tienCoc;
        this.ghiChu = ghiChu;
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
        return ngayTra;
    }

    public ArrayList<SachClass> getArrSach() {
        return arrSach;
    }

  

    public int getTienCoc() {
        return tienCoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }
    
    public void setMaPhieu(String maPhieu) throws Exception {
        if(maPhieu.trim().equals(""))
        {
            throw new Exception("mã phiếu trống");
        }
        this.maPhieu = maPhieu;
    }

    public void setMaSV(String maSV) throws Exception {
        if(maSV.trim().equals(""))
        {
            throw new Exception("mã sinh viên trống");
        }
        this.maSV = maSV;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

   

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setArrSach(ArrayList<SachClass> arrSach) throws Exception {
        if(arrSach.size() == 0)
        {
            throw new Exception("không có sách trong phiếu");
        }
        this.arrSach = arrSach;
    }



    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    
    
 
    
}
