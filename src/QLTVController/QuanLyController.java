/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTVController;
import Connect.ConnectToSql;
import QLTVModel.QuanLyClass;
import Util.EmailValidate;
import Util.LuuDuLieu;
import java.sql.*;
import javax.swing.JOptionPane;
import view.quantri.Loading;
/**
 *
 * @author WIN1064
 */
public class QuanLyController {
    Connection conn;
    PreparedStatement pst;

    public QuanLyController() {
    }
    public int dangNhap(QuanLyClass ql){
        int dangNhapSc = 0;
        conn = ConnectToSql.connectDb();
        String sql = "select * from QuanLy where TaiKhoan = ? and MatKhau = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, ql.getTaiKhoan());
            pst.setString(2, ql.getMatKhau());
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                LuuDuLieu.currentQuanLy = new QuanLyClass();
                LuuDuLieu.currentQuanLy.setHoTen(rs.getString(2));
                rs.close();
                pst.close();
                
                dangNhapSc = 1;
                Loading ld = new Loading();
                ld.setLoading();
                ld.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return dangNhapSc;
    }
    public void dangKy(QuanLyClass ql)
    {
        conn = ConnectToSql.connectDb();
        EmailValidate ev = new EmailValidate();
        if (!ev.validate(ql.getEmail().trim())) {
            JOptionPane.showMessageDialog(null, "Email không hợp lệ");
        }
        else{
            try {
                String sql = "insert into QuanLy (TaiKhoan,HoTen,MatKhau,CauHoiBM,TraLoiBM,SDT,Email) values (?,?,?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, ql.getTaiKhoan());
                pst.setString(2, ql.getHoTen());
                pst.setString(3, ql.getMatKhau());
                pst.setString(4, (String) ql.getCauHoiBM());
                pst.setString(5, ql.getTraLoiBM());
                pst.setString(6, ql.getSdt());
                pst.setString(7, ql.getEmail());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công");
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
