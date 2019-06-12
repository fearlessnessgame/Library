package com.company.View;

import com.company.Tool.font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//程序主界面
public class Home {
}
class MainJFrame extends JFrame implements ActionListener {

    public MainJFrame() {

        bg=new JLabel(img);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Library Management System");
        this.setLocation(430,350);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(img.getIconWidth(),img.getIconHeight());
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());

        book.setBounds(180,50,400,80);
        student.setBounds(180,180,400,80);
        list.setBounds(180,300,400,80);
        back.setBounds(180,420,400,80);



        jPanel.add(student);
        jPanel.add(list);
        jPanel.add(back);
        jPanel.add(book);
        jPanel.add(bg);
        container.add(jPanel);

        welcome.setFont(font.JBottonFont());
        book.setFont(font.JBottonFont());
        student.setFont(font.JBottonFont());
        list.setFont(font.JBottonFont());
        back.setFont(font.JBottonFont());
        list.addActionListener(this);
        book.addActionListener(this);
        student.addActionListener(this);
        back.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == book) {
            this.dispose();
            BookRetrieval page1 = new BookRetrieval();
            page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            page1.setTitle("Book Retrieval");
            page1.setLocation(500,300);
            page1.setSize(815, 600);
            page1.setVisible(true);
        }
        if (e.getSource() == student) {
            this.dispose();
            StudentRetrieval page2 = new StudentRetrieval();
            page2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            page2.setTitle("Student Retrieval");
            page2.setLocation(500,400);
            page2.setSize(615, 600);
            page2.setVisible(true);
        }
        if (e.getSource() == list) {
            this.dispose();
            BorrowList page2 = new BorrowList();
            page2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            page2.setTitle("Borrow List");
            page2.setLocation(300,200);
            page2.setSize(495, 515);
            page2.setVisible(true);
        }
        if(e.getSource()==back){
            this.dispose();
            new Main();
        }
    }

    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/Manger.jpg");
    private com.company.Tool.font font=new com.company.Tool.font();
    private Container container = getContentPane();
    private JPanel jPanel=new JPanel();

    private JLabel welcome = new JLabel("Welcome to my library management system");
    private JButton book = new JButton("Book Retrieval");
    private JButton student = new JButton("Student Retrieval");
    private JButton list = new JButton("Borrow List");
    private JButton back=new JButton("Back");

}

