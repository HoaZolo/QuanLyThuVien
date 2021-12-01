/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTVModel;

import Util.EmailValidate;
import Util.PhoneValidate;

/**
 *
 * @author WIN1064
 */
public class SinhVienClass {
    private String maSV,tenSV,nganhHoc,ngaySinh,gioiTinh,SDT,Email;
    private int trangThai;
    public SinhVienClass() {
    }

    public SinhVienClass(String maSV, String tenSV, String nganhHoc, String ngaySinh, String gioiTinh, String SDT, String Email,int trangThai) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.nganhHoc = nganhHoc;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.Email = Email;
        this.trangThai = trangThai;
    }
     public SinhVienClass( String tenSV, String nganhHoc, String ngaySinh, String gioiTinh, String SDT, String Email,int trangThai) {
        this.tenSV = tenSV;
        this.nganhHoc = nganhHoc;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.Email = Email;
        this.trangThai = trangThai;
    }
    public String getMaSV() {
        return maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public String getEmail() {
        return Email;
    }

    public int getTrangThai() {
        return trangThai;
    }
    
    public void setMaSV(String maSV) throws Exception {
        if (maSV.trim().equals("")) {
            throw new Exception("mã sinh viên không hợp lệ");
        }
        this.maSV = maSV.toUpperCase();
    }

    public void setTenSV(String tenSV) throws Exception {
        if (tenSV.trim().equals("")) {
            throw new Exception("tên sinh viên không hợp lệ");
        }
        this.tenSV = tenSV;
    }

    public void setNganhHoc(String nganhHoc) throws Exception {
        if (nganhHoc.trim().equals("")) {
            throw new Exception("ngàng học không hợp lệ");
        }
        this.nganhHoc = nganhHoc;
    }

    public void setNgaySinh(String ngaySinh) throws Exception {
        if (ngaySinh.trim().equals("")) {
            throw new Exception("ngày sinh không hợp lệ");
        }
        this.ngaySinh = ngaySinh;
    }

    public void setGioiTinh(String gioiTinh) throws Exception {
        if (gioiTinh.trim().equals("")) {
            throw new Exception("giới tính không hợp lệ");
        }
        this.gioiTinh = gioiTinh;
    }

    public void setSDT(String SDT) throws Exception {
        PhoneValidate pv = new PhoneValidate();
        if(!pv.validate(SDT))
        {
            throw new Exception("số điện thoại không hợp lệ");
        }
        this.SDT = SDT;
    }

    public void setEmail(String Email) throws Exception {
        EmailValidate ev = new EmailValidate();
        if(!ev.validate(Email))
        {
            throw new Exception("email không hợp lệ");
        }
        this.Email = Email;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SinhVienClass{" + "maSV=" + maSV + ", tenSV=" + tenSV + ", nganhHoc=" + nganhHoc + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", SDT=" + SDT + ", Email=" + Email + ", trangThai=" + trangThai + '}';
    }
    
    
    
}
