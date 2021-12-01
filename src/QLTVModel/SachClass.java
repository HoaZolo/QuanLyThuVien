/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTVModel;

import Util.IntegerValidate;
import java.util.Objects;

/**
 *
 * @author WIN1064
 */
public class SachClass {

    private String maSach, tenSach;
    private int taiBan;
    
    private String nhaXuatBan;
    private int gia;
    private String MaTheLoai;
    private int soLuong;
    private int soLuongMua;
    private int mucDich;
    public SachClass() {
        
    }

    public SachClass(String maSach, String tenSach, int taiBan, String nhaXuatBan, int gia, String MaTheLoai, int soLuong,int mucDich) throws Exception {
        this.taiBan = taiBan;
        this.maSach = maSach.toUpperCase();
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.MaTheLoai = MaTheLoai;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mucDich = mucDich;
    }

    public SachClass(String tenSach, int taiBan, String nhaXuatBan, int gia, String MaTheLoai, int soLuong,int mucDich) throws Exception {
        this.taiBan = taiBan;
         this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.MaTheLoai = MaTheLoai;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mucDich = mucDich;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {

        return tenSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public int getTaiBan() {
        return taiBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getGia() {
        return gia;
    }

    public int getMucDich() {
        return mucDich;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }
        
    public void setMaSach(String maSach) throws Exception {
        if (maSach.trim().equals("")) {
            throw new Exception("mã sách không hợp lệ");
        }
        this.maSach = maSach.toUpperCase();
    }

    public void setTenSach(String tenSach) throws Exception {
        if (tenSach.trim().equals("")) {
            throw new Exception("tên sách không hợp lệ");
        }
        this.tenSach = tenSach;
    }

    public void setNhaXuatBan(String nhaXuatBan) throws Exception {
        if (nhaXuatBan.trim().equals("")) {
            throw new Exception("nhà xuất bản không hợp lệ");
        }
        this.nhaXuatBan = nhaXuatBan;
    }

    public void setMaTheLoai(String MaTheLoai) throws Exception {
        if (MaTheLoai.trim().equals("")) {
            throw new Exception("thể loại bản không hợp lệ");
        }
        this.MaTheLoai = MaTheLoai;
    }

    public void setMucDich(int mucDich) throws Exception {
        this.mucDich = mucDich;
    }
    
    public void setTaiBan(int taiBan) {
        this.taiBan = taiBan;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SachClass other = (SachClass) obj;
        if(!this.maSach.equalsIgnoreCase(other.maSach))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if(soLuongMua == 0)
        return  tenSach+"(" +maSach+")";
        else return  tenSach+"(" +maSach+")x" + soLuongMua ;
    }
    
}
