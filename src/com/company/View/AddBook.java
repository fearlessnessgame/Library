package com.company.View;

import com.company.Book.BookInfo;
import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//添加书籍界面
public class AddBook extends JFrame implements ActionListener {
    tool op = new tool();

    public AddBook() {
        bg=new JLabel(img);
        this.setTitle("Book Add");
        this.setLocation(300,100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(650,750);
        this.setVisible(true);
        this.setResizable(false);
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());


        bookId.setBounds(140,80,150,50);
        bookName.setBounds(140,150,150,50);
        bookAuthor.setBounds(140,220,150,50);
        press.setBounds(140,290,150,50);
        pressTime.setBounds(140,360,150,50);
        bookAbstract.setBounds(140,430,150,50);
        storage.setBounds(140,500,150,50);

        idField.setBounds(360,80,200,50);
        nameField.setBounds(360,150,200,50);
        authorField.setBounds(360,220,200,50);
        pressField.setBounds(360,290,200,50);
        pressTimeField.setBounds(360,360,200,50);
        abstractField.setBounds(360,430,200,50);
        storageField.setBounds(360,500,200,50);


        confirm.setBounds(360,640,150,50);
        cancel.setBounds(160,640,150,50);



        jPanel.setLayout(null);
        bookId.setFont(font.JLableFont());
        bookName.setFont(font.JLableFont());
        bookAuthor.setFont(font.JLableFont());
        press.setFont(font.JLableFont());
        pressTime.setFont(font.JLableFont());
        bookAbstract.setFont(font.JLableFont());
        storage.setFont(font.JLableFont());
        abstractField.setFont(font.JTextFiledFont());
        idField.setFont(font.JTextFiledFont());
        nameField.setFont(font.JTextFiledFont());
        authorField.setFont(font.JTextFiledFont());
        pressField.setFont(font.JTextFiledFont());
        pressTimeField.setFont(font.JTextFiledFont());
        storageField.setFont(font.JTextFiledFont());

        cancel.setFont(font.JBottonFont());
        confirm.setFont(font.JBottonFont());

        jPanel.add(bookId);
        jPanel.add(idField);
        jPanel.add(bookName);
        jPanel.add(nameField);
        jPanel.add(bookAuthor);
        jPanel.add(authorField);
        jPanel.add(press);
        jPanel.add(pressField);
        jPanel.add(pressTime);
        jPanel.add(pressTimeField);
        jPanel.add(bookAbstract);
        jPanel.add(abstractField);
        jPanel.add(storage);
        jPanel.add(storageField);
        jPanel.add(cancel);
        jPanel.add(confirm);
        jPanel.add(bg);
        c.add(jPanel);
        cancel.addActionListener(this);
        confirm.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
        }
        if (e.getSource() == confirm) {
            this.dispose();
            BookInfo book = new BookInfo(idField.getText(), nameField.getText(), authorField.getText(), pressField.getText(), pressTimeField.getText(), abstractField.getText(), Integer.parseInt(storageField.getText()), Integer.parseInt(storageField.getText()));
            ArrayList<String> strArray = new ArrayList<String>();
            strArray = op.addBookJudgement();
            int n = 0;
            int replicate = 0;
            while (n < Integer.parseInt(strArray.get(0))) {
                n++;
                if (idField.getText().equals(strArray.get(n))) {
                    replicate++;
                }
            }
            if (replicate == 0) {
                op.addBook(book);
                JOptionPane.showMessageDialog(null, "Add a book successfully！", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "This book(id) has already existed!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    private font font=new font();
    private Container c = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel bookId = new JLabel("Book ID:");
    private JLabel bookName = new JLabel("Book Name:");
    private JLabel bookAuthor = new JLabel("Book Author:");
    private JLabel press = new JLabel("Press:");
    private JLabel pressTime = new JLabel("Press time:");
    private JLabel bookAbstract = new JLabel("Introduction:");
    private JLabel storage = new JLabel("Storage:");

    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField authorField = new JTextField();
    private JTextField pressField = new JTextField();
    private JTextField pressTimeField = new JTextField();
    private JTextField abstractField = new JTextField();
    private JTextField storageField = new JTextField();
    private JButton cancel = new JButton("Cancel");
    private JButton confirm = new JButton("Confirm");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/Book.jpg");

}
