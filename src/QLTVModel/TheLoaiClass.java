/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTVModel;

import java.util.Objects;

/**
 *
 * @author WIN1064
 */
public class TheLoaiClass {
    private String maTheLoai,tenTheLoai;

    public TheLoaiClass() {
    }
    
    public TheLoaiClass(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }
    
    public TheLoaiClass(String maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) throws Exception {
         if(maTheLoai.trim().equals(""))
        {
            throw new Exception("mã thể loại không đúng");
        }
        this.maTheLoai = maTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) throws Exception {
        if(tenTheLoai.trim().equals(""))
        {
            throw new Exception("tên thể loại không đúng");
        }
        this.tenTheLoai = tenTheLoai;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    @Override
    public String toString() {
        return maTheLoai + "-" +  tenTheLoai ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final TheLoaiClass other = (TheLoaiClass) obj;
        if (!Objects.equals(this.maTheLoai, other.maTheLoai)) {
            return false;
        }
        return true;
    }
    
    
}
