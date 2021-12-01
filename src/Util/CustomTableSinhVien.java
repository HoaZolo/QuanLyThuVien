/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import QLTVModel.SinhVienClass;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN1064
 */
public class CustomTableSinhVien extends AbstractTableModel {

    private String name[] = {"Mã sinh viên", "Tên sinh viên", "Ngành học", "Ngày sinh", "Giới tính", "Số điện thoại", "Email","Tình trạng"};

    private Class classes[] = {String.class, String.class, String.class, String.class, String.class, String.class, String.class,String.class};
    ArrayList<SinhVienClass> dsSV = new ArrayList<SinhVienClass>();

    public CustomTableSinhVien() {
        this.dsSV = LuuDuLieu.dsSV;
    }

    @Override
    public int getRowCount() {
        return dsSV.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            //Cột số a
            case 0:
                return dsSV.get(rowIndex).getMaSV();
            //Cột b
            case 1:
                return dsSV.get(rowIndex).getTenSV();
            //cột c
            case 2:
                return dsSV.get(rowIndex).getNganhHoc();
            //cột kq
            case 3:
                String s = dsSV.get(rowIndex).getNgaySinh();
                Date date;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    return sdf.format(date);
                    
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }     
                return "";
            case 4:
                return dsSV.get(rowIndex).getGioiTinh();
            case 5:
                return dsSV.get(rowIndex).getSDT();
            case 6:
                return dsSV.get(rowIndex).getEmail();
             case 7:
                 System.out.println(dsSV.get(rowIndex).getTrangThai());
                 if(dsSV.get(rowIndex).getTrangThai() == 0)
                    return "Kích hoạt";
                 else return "Tắt";
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return name[column];
    }
}
