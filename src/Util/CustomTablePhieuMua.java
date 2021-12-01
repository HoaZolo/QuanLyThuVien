/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import QLTVModel.PhieuMuaChiTiet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN1064
 */
public class CustomTablePhieuMua extends AbstractTableModel{
    private String name[]={"Mã mua","Sinh viên","Sách","Ngày đặt","Tiền phải trả","Ghi chú","Trạng thái"};
    
    private Class classes[]={String.class,String.class,String.class,String.class,Integer.class,String.class,String.class};
    ArrayList<PhieuMuaChiTiet> dsPM=new ArrayList<PhieuMuaChiTiet>();
    public CustomTablePhieuMua(){
        this.dsPM = LuuDuLieu.dsPhieuMuaCT;
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
            case 0: return dsPM.get(rowIndex).getMaMua();
            //Cột b
            case 1: return dsPM.get(rowIndex).getMaSV();
            //cột c
            //cột kq
            case 2:
                String str = "";
                for(int i = 0;i < dsPM.get(rowIndex).getArrSach().size();i++)
                {
                    str += dsPM.get(rowIndex).getArrSach().get(i)  +",";
                }
                String result = str.substring(0, str.length() - 1);
                return result;
            case 3: return FormatDate.format(dsPM.get(rowIndex).getNgayDat());
       
            case 4: return dsPM.get(rowIndex).getTienPhaiTra();
            case 5: return dsPM.get(rowIndex).getGhiChu();
            case 6: 
                if(dsPM.get(rowIndex).getDaTra() == 0) return "Chưa trả";
                else return "Đã trả";
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
