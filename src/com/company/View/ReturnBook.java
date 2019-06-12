package com.company.View;

import com.company.Book.BookInfo;
import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//还书界面
public class ReturnBook extends JFrame implements ActionListener {



    public ReturnBook() {
        c.add(jPanel);
        bg=new JLabel(img);
        this.setTitle("Return Book");
        this.setLocation(300,200);
        this.setSize(img.getIconWidth(),img.getIconHeight());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        bookId.setBounds(80,50,150,50);
        studentId.setBounds(80,150,150,50);
        idField.setBounds(250,50,200,50);
        studentIdField.setBounds(250,150,200,50);
        returnBook.setBounds(30,250,200,50);
        cancel.setBounds(250,250,200,50);

        bookId.setFont(font.JLableFont());
        idField.setFont(font.JTextFiledFont());
        studentId.setFont(font.JLableFont());
        studentIdField.setFont(font.JTextFiledFont());
        cancel.setFont(font.JBottonFont());
        returnBook.setFont(font.JBottonFont());


        jPanel.add(bookId);
        jPanel.add(idField);
        jPanel.add(studentId);
        jPanel.add(studentIdField);
        jPanel.add(cancel);
        jPanel.add(returnBook);
        jPanel.add(bg);

        cancel.addActionListener(this);
        returnBook.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
        }
        if (e.getSource() == returnBook) {
            String bookId = idField.getText();
            ArrayList<String> strArray = new ArrayList<String>();
            strArray = op.addBookJudgement();
            int n = 0;
            int replicate = 0;
            while (n < Integer.parseInt(strArray.get(0))) {
                n++;
                if (bookId.equals(strArray.get(n))) {
                    replicate++;
                }
            }

            String studentId = studentIdField.getText();
            ArrayList<String> strArray1 = new ArrayList<String>();
            strArray1 = op.addStudentJudgement();
            int n1 = 0;
            int replicate1 = 0;
            while (n1 < Integer.parseInt(strArray1.get(0))) {
                n1++;
                if (studentId.equals(strArray1.get(n1))) {
                    replicate1++;
                }
            }

            if (replicate == 0 || replicate1 == 0) {
                JOptionPane.showMessageDialog(null, "Please input a correct book id and a student id!", "Warning", JOptionPane.INFORMATION_MESSAGE);

            } else {
                if (op.returnCheck(idField.getText(),
                        studentIdField.getText()) == 1) {
                    JOptionPane.showMessageDialog(null, "No result found!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    BookInfo book = new BookInfo(bookId);
                    ArrayList<String> s = new ArrayList<String>();
                    s = op.outputBook(book);
                    BookInfo book1 = new BookInfo(s.get(0), s.get(1),
                            s.get(2), s.get(3), s.get(4), s.get(5),
                            Integer.parseInt(s.get(6)), Integer.parseInt(s.get(7)) + 1);
                    op.inputBook(book1);
                    if(op.deleteResult(idField.getText(), studentIdField.getText())==1){
                        JOptionPane.showMessageDialog(null, "Return the book successful!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();

                    }else{
                        JOptionPane.showMessageDialog(null, "Failed to return the book!", "Unsuccessful", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }

        }
    }

    private font font=new font();
    private tool op = new tool();
    private Container c = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel bookId = new JLabel("Book Id:");
    private JTextField idField = new JTextField();
    private JLabel studentId = new JLabel("Student Id:");
    private JTextField studentIdField = new JTextField();
    private JButton cancel = new JButton("Cancel");
    private JButton returnBook = new JButton("Return");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/jframe1.jpg");

}
