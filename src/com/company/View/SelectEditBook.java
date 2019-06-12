package com.company.View;

import com.company.Tool.font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//编辑图书界面
public class SelectEditBook extends JFrame implements ActionListener {


    public SelectEditBook() {
        bg=new JLabel(img);
        this.setTitle("Borrow Book");
        this.setLocation(300,200);
        this.setSize(img.getIconWidth(),img.getIconHeight());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        bookId.setBounds(80,100,150,50);
        idField.setBounds(250,100,200,50);

        cancel.setBounds(30,200,200,50);
        select.setBounds(250,200,200,50);

        bookId.setFont(font.JLableFont());
        idField.setFont(font.JTextFiledFont());
        cancel.setFont(font.JBottonFont());
        select.setFont(font.JBottonFont());

        jPanel.setLayout(null);
        jPanel.add(bookId);
        jPanel.add(idField);
        jPanel.add(cancel);
        jPanel.add(select);
        jPanel.add(bg);
        container.add(jPanel);
        cancel.addActionListener(this);
        select.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
        }
        if (e.getSource() == select) {

            this.dispose();
            try {
                 new EditBook(idField.getText());

            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Please input the book id correctly!",
                        "Warning", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    private font font=new font();
    private Container container = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel bookId = new JLabel("Book Id:");
    private JTextField idField = new JTextField();
    private JButton cancel = new JButton("Cancel");
    private JButton select = new JButton("Select");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/jframe1.jpg");

}

