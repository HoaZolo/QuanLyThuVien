/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTVController;

import Connect.ConnectToSql;
import QLTVModel.SinhVienClass;
import view.sinhvien.ThemSinhVienThanhCong;
import Util.LuuDuLieu;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN1064
 */
public class SinhVienController {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    CallableStatement stm;

    public SinhVienController() {
        conn = ConnectToSql.connectDb();
    }

    public ArrayList<SinhVienClass> getSV() {

        ArrayList<SinhVienClass> dsSV = new ArrayList<SinhVienClass>();
        String sql = "select * from SinhVien";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                SinhVienClass sv = new SinhVienClass(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                dsSV.add(sv);
            }
            System.out.println(dsSV);
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return dsSV;
    }

    public String getTenSV(String maSV) {
        String name = "";
        String sql = "select * from SinhVien where MaSinhVien ='" + maSV + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                name = rs.getString(2);
            }
            pst.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return name;
    }

    public int themSV(SinhVienClass sv) throws Exception {
        int insert = 0;
        try {
            stm = conn.prepareCall("{call InsertSinhVien(?,?,?,?,?,?,?,?)}");
            stm.setString(1, sv.getTenSV());
            stm.setString(2, (String) sv.getNganhHoc());
            stm.setString(3, sv.getNgaySinh());
            stm.setString(4, sv.getGioiTinh());
            stm.setString(5, sv.getSDT());
            stm.setString(6, sv.getEmail());
            stm.setInt(7, 0);
            stm.registerOutParameter(8, Types.VARCHAR);
            insert = stm.executeUpdate();
            String m_count = stm.getString(8);
            LuuDuLieu.currentSV = sv;
            LuuDuLieu.currentSV.setMaSV(m_count);
            stm.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        return insert;
    }

    public int suaSV(SinhVienClass s) {
        int update = 0;
        String sql = "{call UpdateSinhVien (?, ?, ?, ?, ?, ?, ?,?)}";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, s.getTenSV());
            pst.setString(2, s.getNganhHoc());
            pst.setString(3, s.getNgaySinh());
            pst.setString(4, s.getGioiTinh());
            pst.setString(5, s.getSDT());
            pst.setString(6, s.getEmail());
            pst.setInt(7, s.getTrangThai());
            pst.setString(8, s.getMaSV());
            update = pst.executeUpdate();
            conn.commit();
            pst.close();

            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return update;
    }

    public int xoaSV(SinhVienClass s) {
        int delete = 0;
        String sql = "DELETE SinhVien WHERE MaSinhVien = ?";
        try {
            pst = conn.prepareStatement(sql);

            pst.setString(1, s.getMaSV());
            delete = pst.executeUpdate();
            conn.commit();
            pst.close();

           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return delete;
    }

    public ArrayList<SinhVienClass> timKiem(String keywords) {

        ArrayList<SinhVienClass> dsSV = new ArrayList<SinhVienClass>();
        String sql = "select * from SinhVien where MaSinhVien like '%" + keywords + "%' OR TenSinhVien like N'%" + keywords + "%'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                SinhVienClass s = new SinhVienClass(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                dsSV.add(s);
            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return dsSV;
    }

    public int kiemTraSV(String sv) {
        String sql = "select * from SinhVien where MaSinhVien = '" + sv + "' AND TrangThai = 1";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                return 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return 1;
    }

    public int kiemTraSinhVien_PhieuMuon(String sv) {
        String sql = "select * from PhieuMuon where MaSinhVien = '" + sv + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                return 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return 1;
    }

    public int kiemTraSinhVien_PhieuMua(String sv) {
        String sql = "select * from PhieuMua where MaSinhVien = '" + sv + "'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                return 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return 1;
    }
}
