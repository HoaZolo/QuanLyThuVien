/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import QLTVModel.SachClass;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN1064
 */
public class CustomTableSach extends AbstractTableModel {

    private String name[] = {"Mã sách", "Tên sách", "Mục đích", "Tái bản", "Nhà xuất bản", "Giá", "Thể loại", "Số lượng"};

    private Class classes[] = {String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, Integer.class};
    ArrayList<SachClass> dsSach = new ArrayList<SachClass>();

    public CustomTableSach() {
        this.dsSach = LuuDuLieu.dsSach;
    }

    @Override
    public int getRowCount() {
        return dsSach.size();
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
                return dsSach.get(rowIndex).getMaSach();
            //Cột b
            case 1:
                return dsSach.get(rowIndex).getTenSach();
            case 2:
                if (dsSach.get(rowIndex).getMucDich() == 1) {
                    return "Sách mượn";
                } else {
                    return "Sách bán";
                }
            case 3:
                return dsSach.get(rowIndex).getTaiBan();
            //cột kq
            case 4:
                return dsSach.get(rowIndex).getNhaXuatBan();
            case 5:
                return dsSach.get(rowIndex).getGia();
            case 6:
                return dsSach.get(rowIndex).getMaTheLoai();
            case 7:
                return dsSach.get(rowIndex).getSoLuong();
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
