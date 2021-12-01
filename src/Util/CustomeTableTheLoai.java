/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import QLTVModel.TheLoaiClass;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WIN1064
 */
public class CustomeTableTheLoai extends AbstractTableModel{
     private String name[]={"Mã sách","Tên sách"};
    
    private Class classes[]={String.class,String.class};
    ArrayList<TheLoaiClass> dsTL=new ArrayList<TheLoaiClass>();
    public CustomeTableTheLoai(){
        this.dsTL = LuuDuLieu.dsTL;
    }
    @Override
    public int getRowCount() {
        return dsTL.size();
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
            case 0: return dsTL.get(rowIndex).getMaTheLoai();
            //Cột b
            case 1: return dsTL.get(rowIndex).getTenTheLoai();
            //cột c
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
