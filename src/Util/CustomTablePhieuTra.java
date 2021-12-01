/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import QLTVModel.PhieuMuonChiTiet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN1064
 */
public class CustomTablePhieuTra extends AbstractTableModel{
    private String name[]={"Mã phiếu","Sinh viên","Sách","Ngày mượn","Ngày trả","Tiền cọc","Ghi chú"};
    
    private Class classes[]={String.class,String.class,String.class,String.class,String.class,Double.class,String.class};
    ArrayList<PhieuMuonChiTiet> dsPM=new ArrayList<PhieuMuonChiTiet>();
    public CustomTablePhieuTra(){
        this.dsPM = LuuDuLieu.dsPTCT;
    }
    @Override
    public int getRowCount() {
        return dsPM.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex)
        {
            //Cột số a
            case 0: return dsPM.get(rowIndex).getMaPhieu();
            //Cột b
            case 1: return dsPM.get(rowIndex).getMaSV().toUpperCase();
            //cột c
            //cột kq
            case 2:
                String str = "";
                for(int i = 0;i < dsPM.get(rowIndex).getArrSach().size();i++)
                {
                    str += dsPM.get(rowIndex).getArrSach().get(i) + ",";
                }
                String result = str.substring(0, str.length() - 1);
                return result;
            case 3: return FormatDate.format(dsPM.get(rowIndex).getNgayMuon());
            case 4: return FormatDate.format(dsPM.get(rowIndex).getNgayTra());
            case 5: return dsPM.get(rowIndex).getTienCoc();
            case 6: return dsPM.get(rowIndex).getGhiChu();
            default :return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }
}
