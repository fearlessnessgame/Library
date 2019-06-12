package com.company.View;


import com.company.Tool.tool;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BookTable extends JFrame {

    public BookTable(String id,String name){

        ob1=op.NameBook(name);
        for (int i = 0; i < 5; i++) {
            DefaultTableModel books = new DefaultTableModel(ob1, s);
            for (int n = 0; n < 20; n++) {
                for (int m = 0; m < 8; m++) {
                    ob1[n][m] = this.ob1[n][m];
                }
                table.setModel(books);
                table.invalidate();
            }
        }
        jPanel1.setLayout(new GridLayout(1,1,10,10));

        jPanel1.add(scrollPane);
        container.add(jPanel1, BorderLayout.CENTER);

    }

    private Container container = getContentPane();
    private JPanel jPanel1 = new JPanel();
    private tool op=new tool();
    private Object[] s={"Id","Name","Author","Press","Press Time","Introduction","Storage", "Remain"};
    private Object[][] ob1 = new Object[200][8];
    private JTable table = new JTable(ob1, s);
    private JScrollPane scrollPane = new JScrollPane(table);
}
