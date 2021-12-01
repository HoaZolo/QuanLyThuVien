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
public class QuanLyClass {
    private String taiKhoan,matKhau,hoTen,cauHoiBM,traLoiBM,sdt,email;

    public QuanLyClass() {
    }

    public QuanLyClass(String taiKhoan,String matKhau, String hoTen, String cauHoiBM, String traLoiBM, String sdt, String email) {
        this.taiKhoan = taiKhoan;
        this.hoTen = hoTen;
        this.cauHoiBM = cauHoiBM;
        this.traLoiBM = traLoiBM;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
    }

    public void setTaiKhoan(String taiKhoan) throws Exception {
        if(taiKhoan.trim().equals(""))
        {
            throw new Exception(" tài khoản không được trống");
        }
        this.taiKhoan = taiKhoan;
    }

    public void setHoTen(String hoTen) throws Exception {
        if(hoTen.trim().equals(""))
        {
            throw new Exception(" họ tên không được trống");
        }
        this.hoTen = hoTen;
    }

    public void setCauHoiBM(String cauHoiBM) throws Exception {
        if(cauHoiBM.trim().equals(""))
        {
            throw new Exception(" câu hỏi bảo mật không được trống");
        }
        this.cauHoiBM = cauHoiBM;
    }

    public void setTraLoiBM(String traLoiBM) throws Exception 
    {
        if(traLoiBM.trim().equals(""))
        {
            throw new Exception(" câu trả lời bảo mật không được trống");
        }
        this.traLoiBM = traLoiBM;
    }

    public void setSdt(String sdt) throws Exception {
        PhoneValidate pv = new PhoneValidate();
        if(!pv.validate(sdt))
        {
            throw new Exception("số điện thoại không hợp lệ");
        }
        this.sdt = sdt;
    }

    public void setEmail(String email) throws Exception {
        EmailValidate ev = new EmailValidate();
        if(!ev.validate(email))
        {
            throw new Exception("email không hợp lệ");
        }
        this.email = email;
    }

    public void setMatKhau(String matKhau) throws Exception {
        if(matKhau.trim().equals(""))
        {
            throw new Exception(" mật khẩu không được trống");
        }
        this.matKhau = matKhau;
    }
    
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getCauHoiBM() {
        return cauHoiBM;
    }

    public String getTraLoiBM() {
        return traLoiBM;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getMatKhau() {
        return matKhau;
    }
    
    
}
