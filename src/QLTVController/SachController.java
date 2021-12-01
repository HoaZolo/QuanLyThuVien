/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTVController;

import Connect.ConnectToSql;
import QLTVModel.SachClass;
import QLTVModel.SinhVienClass;
import view.sach.ThemSachThanhCong;
import view.sinhvien.ThemSinhVienThanhCong;
import Util.LuuDuLieu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN1064
 */
public class SachController {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    CallableStatement stm;

    public SachController() {
        conn = ConnectToSql.connectDb();
    }

    public ArrayList<SachClass> getSach() {

        ArrayList<SachClass> dsSach = new ArrayList<SachClass>();
        String sql = "select * from Sach";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                SachClass s;
                try {
                    s = new SachClass(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(6), rs.getString(5), rs.getInt(7), rs.getInt(8));
                    dsSach.add(s);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return dsSach;
    }

    public String getTenSach(String maSach) {

        String name = "";
        String sql = "select * from Sach where MaSach ='" + maSach + "'";
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

    public int themSach(SachClass s) throws Exception {
        int insert = 0;
        try {
            stm = conn.prepareCall("{call InsertSach(?,?,?,?,?,?,?,?)}");
            stm.setString(1, s.getTenSach());
            stm.setInt(2, s.getTaiBan());
            stm.setString(3, s.getNhaXuatBan());
            stm.setInt(4, s.getGia());
            stm.setString(5, s.getMaTheLoai());
            stm.setInt(6, s.getSoLuong());
            stm.setInt(7, s.getMucDich());
            stm.registerOutParameter(8, Types.VARCHAR);
            insert = stm.executeUpdate();
            String m_count = stm.getString(8);
            stm.close();
            LuuDuLieu.currentSach = s;
            LuuDuLieu.currentSach.setMaSach(m_count);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return insert;
    }

    public int suaSach(SachClass s) {
        int update = 0;
        String sql = "{call UpdateSach (?, ?, ?, ?, ?, ?, ?)}";
        try {
            pst = conn.prepareStatement(sql);
            pst.setNString(1, s.getTenSach());
            pst.setInt(2, s.getTaiBan());
            pst.setNString(3, s.getNhaXuatBan());
            pst.setInt(4, s.getGia());
            pst.setString(5, s.getMaTheLoai());
            pst.setInt(6, s.getSoLuong());
            pst.setString(7, s.getMaSach());
            update = pst.executeUpdate();
            conn.commit();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return update;
    }

    public int xoaSach(SachClass s) {
        int delete = 0;
        String sql = "DELETE Sach WHERE MaSach = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, s.getMaSach());
            delete = pst.executeUpdate();
            conn.commit();
            pst.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return delete;
    }

    public ArrayList<SachClass> timKiem(String keywords) {

        ArrayList<SachClass> dsSach = new ArrayList<SachClass>();
        String sql = "select * from Sach where MaSach like '%" + keywords + "%' OR TenSach like N'%" + keywords + "%'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                SachClass s;
                try {
                    s = new SachClass(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(6), rs.getString(5), rs.getInt(7), rs.getInt(8));
                    dsSach.add(s);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
            pst.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return dsSach;
    }

    public SachClass timKiemSachMuon(String idSach) {
        String sql = "select * from Sach where MaSach='" + idSach + "' AND MucDich = 1";
        SachClass sach = new SachClass();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                sach.setMaSach(idSach);
                sach.setTenSach(rs.getString(2));
                sach.setTaiBan(Integer.parseInt(rs.getString(3)));
                sach.setNhaXuatBan(rs.getString(4));
                sach.setMaTheLoai(rs.getString(5));
                sach.setGia(Integer.parseInt(rs.getString(6)));
                sach.setSoLuong(Integer.parseInt(rs.getString(7)));
                rs.close();
                pst.close();

            } else {
                rs.close();
                pst.close();
                JOptionPane.showMessageDialog(null, "Không có quyển sách này");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return sach;
    }

    public SachClass timKiemSachMua(String idSach) {

        String sql = "select * from Sach where MaSach='" + idSach + "' AND MucDich = 0";
        SachClass sach = new SachClass();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                sach.setMaSach(idSach);
                sach.setTenSach(rs.getString(2));
                sach.setTaiBan(Integer.parseInt(rs.getString(3)));
                sach.setNhaXuatBan(rs.getString(4));
                sach.setMaTheLoai(rs.getString(5));
                sach.setGia(Integer.parseInt(rs.getString(6)));
                sach.setSoLuong(Integer.parseInt(rs.getString(7)));
                rs.close();
                pst.close();

            } else {
                rs.close();
                pst.close();

                JOptionPane.showMessageDialog(null, "Không có quyển sách này");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return sach;
    }
}
