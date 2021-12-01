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
public class PhieuMuonClass {
    private String maPhieu,maSV,ngayMuon,ngayTra,ghiChu;
    private int daTra;
    public PhieuMuonClass() {
    }

    public PhieuMuonClass(String maPhieu, String maSV, String ngayMuon, String ngayTra, String ghiChu, int daTra) {
        this.maPhieu = maPhieu;
        this.maSV = maSV;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
        this.daTra = daTra;
    }

    public PhieuMuonClass(String maSV, String ngayMuon, String ngayTra, String ghiChu, int daTra) {
        this.maSV = maSV;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.ghiChu = ghiChu;
        this.daTra = daTra;
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
    public void setDaTra(int daTra) throws Exception {
        if(daTra != 0 && daTra != 1)
        {
            throw new Exception("trạng thái phiếu sai");
        }
        this.daTra = daTra;
    }
    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public void setGhiChu(String ghiChu) {
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

    public int getDaTra() {
        return daTra;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }
    
    
    
}
