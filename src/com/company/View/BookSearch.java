package com.company.View;

import com.company.Book.BookDetails;
import com.company.Book.BookInfo;
import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookSearch extends JFrame implements ActionListener {

    public BookSearch(){
        bg=new JLabel(img);
        this.setTitle("Search Book");
        this.setLocation(300,200);
        this.setSize(img.getIconWidth(),img.getIconHeight());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        bookId.setBounds(80,50,150,50);
        bookname.setBounds(80,150,150,50);
        idField.setBounds(250,50,200,50);
        nameField.setBounds(250,150,200,50);
        select.setBounds(30,250,200,50);
        select1.setBounds(250,250,200,50);
        bookId.setFont(font.JLableFont());
        idField.setFont(font.JTextFiledFont());
        bookname.setFont(font.JLableFont());
        nameField.setFont(font.JTextFiledFont());
        select.setFont(font.JBottonFont());
        select1.setFont(font.JBottonFont());



        jPanel.add(bookId);
        jPanel.add(idField);
        jPanel.add(bookname);
        jPanel.add(nameField);
        jPanel.add(select1);
        jPanel.add(select);
        jPanel.add(bg);
        container.add(jPanel);

        select.addActionListener(this);
        select1.addActionListener(this);

    }
    private font font=new font();
    private tool op=new tool();
    private Container container = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel bookId = new JLabel("Book Id:");
    private JLabel bookname=new JLabel("Book Name:");
    private JTextField idField = new JTextField();
    private JTextField nameField=new JTextField();
    private JButton select1 = new JButton("Select Detail");
    private JButton select = new JButton("Select");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/jframe1.jpg");

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==select){
            BookTable f=new BookTable(idField.getText(),nameField.getText());
            f.setVisible(true);
            f.setSize(800, 400);
            f.setLocationRelativeTo(null);
            f.setTitle("Book Table");
        }
        if(e.getSource()==select1){
            ArrayList<String> strArray = new ArrayList<String>();
            strArray = op.addBookJudgement();
            String s1 = idField.getText();
            String s2 = nameField.getText();
            int n = 0;
            int replicate = 0;
            while (n < Integer.parseInt(strArray.get(0))) {
                n++;
                if (s1.equals(strArray.get(n))) {
                    replicate++;
                }
            }
            ArrayList<String> strArray1 = new ArrayList<String>();
            strArray1 = op.addBookJudgement1();
            int n1 = 0;
            int replicate1 = 0;
            while (n1 < Integer.parseInt(strArray1.get(0))) {
                n1++;
                if (s2.equals(strArray1.get(n1))) {
                    replicate1++;
                }
            }
            if (replicate == 0 && replicate1 == 0) {
                JOptionPane.showMessageDialog(null, "Please input a correct book id or name!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (replicate != 0 || replicate1 != 0) {
                if (replicate == 0 && replicate1 != 0) {
                    BookInfo book = new BookInfo(s1, s2);
                    String s = op.searchBookByName(book);
                    new BookDetails(s);

                } else if (replicate != 0) {

                    new BookDetails(s1);

                }
            }

        }
    }
}
