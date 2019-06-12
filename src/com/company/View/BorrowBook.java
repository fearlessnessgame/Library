package com.company.View;

import com.company.Student.StudentInfo;
import com.company.Tool.font;
import com.company.Book.BookInfo;
import com.company.Tool.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//借书界面
public class BorrowBook extends JFrame implements ActionListener {
    tool tool = new tool();


    public BorrowBook() {


        bg=new JLabel(img);
        this.setTitle("Borrow Book");
        this.setLocation(300,200);
        this.setSize(img.getIconWidth(),img.getIconHeight());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        BookId.setBounds(80,50,150,50);
        StudentId.setBounds(80,150,150,50);
        idField.setBounds(250,50,200,50);
        StudentIdField.setBounds(250,150,200,50);
        cancel.setBounds(30,250,200,50);
        borrow.setBounds(250,250,200,50);

        BookId.setFont(font.JLableFont());
        StudentId.setFont(font.JLableFont());
        idField.setFont(font.JTextFiledFont());
        StudentIdField.setFont(font.JTextFiledFont());
        cancel.setFont(font.JBottonFont());
        borrow.setFont(font.JBottonFont());

        jPanel.add(BookId);
        jPanel.add(idField);
        jPanel.add(StudentId);
        jPanel.add(StudentIdField);
        jPanel.add(cancel);
        jPanel.add(borrow);
        jPanel.add(bg);
        c.add(jPanel);

        cancel.addActionListener(this);
        borrow.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
        }
        if (e.getSource() == borrow) {
            String bookId = idField.getText();
            ArrayList<String> strArray = new ArrayList<String>();
            strArray = tool.addBookJudgement();
            int n = 0;
            int replicate = 0;
            while (n < Integer.parseInt(strArray.get(0))) {
                n++;
                if (bookId.equals(strArray.get(n))) {
                    replicate++;
                }
            }

            String StudentId = StudentIdField.getText();
            ArrayList<String> strArray1 = new ArrayList<String>();
            strArray1 = tool.addStudentJudgement();
            int n1 = 0;
            int replicate1 = 0;
            while (n1 < Integer.parseInt(strArray1.get(0))) {
                n1++;
                if (StudentId.equals(strArray1.get(n1))) {
                    replicate1++;
                }
            }

            if (replicate == 0 || replicate1 == 0) {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Please input a correct book id and a student id!",
                                "Warning", JOptionPane.INFORMATION_MESSAGE);

            } else {
                BookInfo book = new BookInfo(bookId);
                ArrayList<String> s = new ArrayList<String>();
                s = tool.outputBook(book);

                if (Integer.parseInt(s.get(7)) > 0) //判断库存总量是否大于一本
                     {
                    int s1 = tool.reBorrowCheck(idField.getText(),
                            StudentIdField.getText());
                    if (s1 == 1) //判断是否借过本书
                    {
                        JOptionPane
                                .showMessageDialog(
                                        null,
                                        "You have borrowed this book, can not reborrow it!",
                                        "Unsuccessful",
                                        JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        long currentTime = System.currentTimeMillis();
                        if (tool.deadLineCheck(StudentIdField.getText(),
                                currentTime) != 0) {
                            JOptionPane
                                    .showMessageDialog(
                                            null,
                                            "You have exceeded the deadline, please return these books first!",
                                            "Unsuccessful",
                                            JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            BookInfo book1 = new BookInfo(s.get(0), s.get(1),
                                    s.get(2), s.get(3), s.get(4), s.get(5),Integer.parseInt(s.get(6)),
                                    Integer.parseInt(s.get(7))-1)
                                   ;
                            tool.inputBook(book1);
                            String borrowTime = Long.toString(System
                                    .currentTimeMillis());
                            String deadline = Long.toString(System
                                    .currentTimeMillis() + 2592000000l);
                            tool.insertBorrow(idField.getText(),
                                    StudentIdField.getText(), borrowTime,
                                    deadline);
                            JOptionPane
                                    .showMessageDialog(
                                            null,
                                            "Borrowed this book successfully, you have 30 days to enjoy this book!",
                                            "Successful",
                                            JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "This book has been borrowed!", "Unsuccessful",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
            this.dispose();
        }
    }

    private font font=new font();
    private Container c = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel BookId = new JLabel("Book Id:");
    private JTextField idField = new JTextField();
    private JLabel StudentId = new JLabel("Student Id:");
    private JTextField StudentIdField = new JTextField();
    private JButton cancel = new JButton("Cancel");
    private JButton borrow = new JButton("Borrow");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/jframe1.jpg");
}
