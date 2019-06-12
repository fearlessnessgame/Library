package com.company.View;

import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//借阅列表界面
public class BorrowList extends JFrame implements ActionListener {

    public BorrowList() {
        Object[][] ob1 = op.borrowList();
        for (int i = 0; i < 5; i++) {
            DefaultTableModel list = new DefaultTableModel(ob, s);
            for (int n = 0; n < 100; n++) {
                for (int m = 0; m < 5; m++) {
                    ob[n][m] = ob1[n][m];
                }
                table.setModel(list);
                table.invalidate();
            }
        }

        jPanel.setLayout(new GridLayout(1,1,10,10));
        back.setFont(font.JBottonFont());
        container.add(jPanel, BorderLayout.CENTER);
        container.add(jPanel1,BorderLayout.SOUTH);

        jPanel.add(scrollPane);

        jPanel1.setLayout(new GridLayout(1,1,10,10));
        jPanel1.add(back);
        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
        back.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.dispose();
           new MainJFrame();
        }
    }

    private font font=new font();
    private tool op = new tool();
    private Container container = getContentPane();
    private JPanel jPanel = new JPanel();
    private JPanel jPanel1 = new JPanel();
    private JButton back=new JButton("Back");
    private Object[] s = { "Book id", "Student id", "Borrow time", "Deadline","OverTime"};
    private Object[][] ob = new Object[100][5];
    private JTable table = new JTable(ob, s);
    private JScrollPane scrollPane = new JScrollPane(table);
}

