package com.company.View;

import com.company.Book.BookInfo;
import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//删除图书界面
public class DeleteBook extends JFrame implements ActionListener {


    public DeleteBook() {
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
        delete.setBounds(250,200,200,50);
        jPanel.setLayout(null);

        bookId.setFont(font.JLableFont());
        idField.setFont(font.JTextFiledFont());
        cancel.setFont(font.JBottonFont());
        delete.setFont(font.JBottonFont());

        jPanel.add(bookId);
        jPanel.add(idField);
        jPanel.add(cancel);
        jPanel.add(delete);
        jPanel.add(bg);
        container.add(jPanel);
        cancel.addActionListener(this);
        delete.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == cancel) {
            this.dispose();
        }
        if (e.getSource() == delete) {
            BookInfo book = new BookInfo(idField.getText());
            this.dispose();
            if (op.deleteBookCheck(idField.getText()) != 0) {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Delete the book unsuccessfully. The book bas been borrowed!",
                                "Warning", JOptionPane.INFORMATION_MESSAGE);

            } else {
                if (op.deleteBook(book) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Delete the book successfully！", "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Delete the book unsuccessfully. The book does not exist!",
                                    "Warning", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        }
    }


    private font font=new font();
    private tool op = new tool();
    private Container container = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel bookId = new JLabel("Book Id:");
    private JTextField idField = new JTextField();
    private JButton cancel = new JButton("Cancel");
    private JButton delete = new JButton("Delete");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/jframe1.jpg");


}
