/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author WIN1064
 */
public class StyleHeaderTable extends DefaultTableCellRenderer {

    public StyleHeaderTable() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        setBackground(new java.awt.Color(32, 136, 203));
        setFont(new Font("Segoe UI",Font.BOLD,12));
        setPreferredSize(new Dimension(100,25));
        setForeground(new Color(255,255,255));
        setHorizontalAlignment(JLabel.CENTER);
        return this;
    }
}
