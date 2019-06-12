package com.company.View;

import com.company.Book.BookInfo;
import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//图书信息修改界面
public class EditBook extends JFrame implements ActionListener {



    public EditBook(String id) {

        bg=new JLabel(img);
        this.setTitle("Book Edit");
        this.setLocation(300,100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(650,750);
        this.setVisible(true);
        this.setResizable(false);
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());

        remain1.setBounds(170,30,350,50);
        bookId.setBounds(160,80,150,50);
        bookName.setBounds(160,150,150,50);
        author.setBounds(160,220,150,50);
        press.setBounds(160,290,150,50);
        pressTime.setBounds(160,360,150,50);
        bookAbstract.setBounds(160,430,150,50);
        storage.setBounds(160,500,150,50);
        remain.setBounds(160,570,150,50);


        idField.setBounds(360,80,250,50);
        nameField.setBounds(360,150,250,50);
        authorField.setBounds(360,220,250,50);
        pressField.setBounds(360,290,250,50);
        pressTimeField.setBounds(360,360,250,50);
        introductionField.setBounds(360,430,250,50);
        storageField.setBounds(360,500,250,50);
        jTextField1.setBounds(360,570,250,50);


        save.setBounds(360,640,150,50);
        cancel.setBounds(160,640,150,50);

        BookInfo book = new BookInfo(id);
        ArrayList<String> strArray = new ArrayList<String>();
        strArray = op.outputBook(book);
        idField.setText(id);
        nameField.setText(strArray.get(1));
        authorField.setText(strArray.get(2));
        pressField.setText(strArray.get(3));
        pressTimeField.setText(strArray.get(4));
        introductionField.setText(strArray.get(5));
        storageField.setText(strArray.get(6));
        jTextField.setText(strArray.get(6));
        jTextField1.setText(strArray.get(7));


        bookId.setFont(font.JLableFont());
        bookName.setFont(font.JLableFont());
        author.setFont(font.JLableFont());
        press.setFont(font.JLableFont());
        pressTime.setFont(font.JLableFont());
        bookAbstract.setFont(font.JLableFont());
        storage.setFont(font.JLableFont());
        remain.setFont(font.JLableFont());
        remain1.setFont(font.Title());
        idField.setFont(font.JTextFiledFont());
        nameField.setFont(font.JTextFiledFont());
        authorField.setFont(font.JTextFiledFont());
        pressField.setFont(font.JTextFiledFont());
        pressTimeField.setFont(font.JTextFiledFont());
        introductionField.setFont(font.JTextFiledFont());
        storageField.setFont(font.JTextFiledFont());
        jTextField1.setFont(font.JTextFiledFont());

        cancel.setFont(font.JBottonFont());
        save.setFont(font.JBottonFont());


        jPanel.setLayout(null);
        jPanel.add(bookId);
        jPanel.add(idField);
        jPanel.add(bookName);
        jPanel.add(nameField);
        jPanel.add(author);
        jPanel.add(authorField);
        jPanel.add(press);
        jPanel.add(pressField);
        jPanel.add(pressTime);
        jPanel.add(pressTimeField);
        jPanel.add(bookAbstract);
        jPanel.add(introductionField);
        jPanel.add(storage);
        jPanel.add(storageField);
        jPanel.add(remain);
        jPanel.add(remain1);
        jPanel.add(jTextField1);
        jPanel.add(cancel);
        jPanel.add(save);
        jPanel.add(bg);
        c.add(jPanel);
        cancel.addActionListener(this);
        save.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();

        }
        if (e.getSource() == save) {

            int i = Integer.parseInt(storageField.getText())
                    - Integer.parseInt(jTextField.getText())
                    + Integer.parseInt(jTextField1.getText());
            BookInfo book = new BookInfo(idField.getText(),
                    nameField.getText(), authorField.getText(),
                    pressField.getText(), pressTimeField.getText(),
                    introductionField.getText(), Integer.parseInt(storageField
                    .getText()), i);
            op.inputBook(book);
            JOptionPane.showMessageDialog(null, "Edit the book successfully！",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    private font font=new font();
    private Container c = getContentPane();
    private JPanel jPanel = new JPanel();
    private tool op = new tool();
    private JLabel bookId = new JLabel("Book Id:");
    private JLabel bookName = new JLabel("Book Name:");
    private JLabel author = new JLabel("Book Author:");
    private JLabel press = new JLabel("Press:");
    private JLabel pressTime = new JLabel("Press time:");
    private JLabel bookAbstract = new JLabel("Abstract:");
    private JLabel storage = new JLabel("Storage:");
    private JLabel remain = new JLabel("Remain:");
    private JLabel remain1 = new JLabel("Update with storage");
    private JLabel idField = new JLabel();
    private JTextField nameField = new JTextField();
    private JTextField authorField = new JTextField();
    private JTextField pressField = new JTextField();
    private JTextField pressTimeField = new JTextField();
    private JTextField introductionField = new JTextField();
    private JTextField storageField = new JTextField();

    private JTextField jTextField = new JTextField();
    private JTextField jTextField1 = new JTextField();

    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/Book.jpg");

    private JButton cancel = new JButton("Cancel");
    private JButton save = new JButton("Save");
}

