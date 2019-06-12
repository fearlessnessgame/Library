package com.company.Book;

import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//获得图书详细信息界面
public class BookDetails extends JFrame implements ActionListener {

    tool op = new tool();

    //创建图书搜索表格
    public BookDetails(String id) {
        bg=new JLabel(img);
        this.setTitle("Book Details");
        this.setLocation(300,100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(650,900);
        this.setVisible(true);
        this.setResizable(false);
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());


        BookInfo book = new BookInfo(id);
        ob1 = op.borrowListForBook(id);
        for (int i = 0; i < 5; i++) {
            DefaultTableModel books = new DefaultTableModel(ob1, s);
            for (int n = 0; n < 7; n++) {
                for (int m = 0; m < 4; m++) {
                    ob1[n][m] = this.ob1[n][m];
                }
                table.setModel(books);
                table.invalidate();
            }
        }
        ArrayList<String> strArray = new ArrayList<String>();
        strArray = op.outputBook(book);
        idField.setText(id);
        nameField.setText(strArray.get(1));
        authorField.setText(strArray.get(2));
        pressField.setText(strArray.get(3));
        pressTimeField.setText(strArray.get(4));
        abstractField.setText(strArray.get(5));
        storageField.setText(strArray.get(6));
        remainField.setText(strArray.get(7));
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());

        bookid.setBounds(160,80,150,50);
        bookName.setBounds(160,150,150,50);
        author.setBounds(160,220,150,50);
        press.setBounds(160,290,150,50);
        pressTime.setBounds(160,360,150,50);
        bookIntroduction.setBounds(160,430,150,50);
        storage.setBounds(160,500,150,50);
        remain.setBounds(160,570,150,50);
        details.setBounds(100,640,500,50);

        idField.setBounds(360,80,150,50);
        nameField.setBounds(360,150,150,50);
        authorField.setBounds(360,220,150,50);
        pressField.setBounds(360,290,150,50);
        pressTimeField.setBounds(360,360,150,50);
        abstractField.setBounds(360,430,150,50);
        storageField.setBounds(360,500,150,50);
        remainField.setBounds(360,570,150,50);

        scrollPane.setBounds(35,700,600,200);

        bookid.setFont(font.JLableFont());
        bookName.setFont(font.JLableFont());
        author.setFont(font.JLableFont());
        press.setFont(font.JLableFont());
        pressTime.setFont(font.JLableFont());
        bookIntroduction.setFont(font.JLableFont());
        storage.setFont(font.JLableFont());
        remain.setFont(font.JLableFont());
        details.setFont(font.Title());
        idField.setFont(font.JTextFiledFont());
        nameField.setFont(font.JTextFiledFont());
        authorField.setFont(font.JTextFiledFont());
        pressField.setFont(font.JTextFiledFont());
        pressTimeField.setFont(font.JTextFiledFont());
        abstractField.setFont(font.JTextFiledFont());
        storageField.setFont(font.JTextFiledFont());
        remainField.setFont(font.JTextFiledFont());



        jPanel.add(bookid);
        jPanel.add(idField);
        jPanel.add(bookName);
        jPanel.add(nameField);
        jPanel.add(author);
        jPanel.add(authorField);
        jPanel.add(press);
        jPanel.add(pressField);
        jPanel.add(pressTime);
        jPanel.add(pressTimeField);
        jPanel.add(bookIntroduction);
        jPanel.add(abstractField);
        jPanel.add(storage);
        jPanel.add(storageField);
        jPanel.add(remain);
        jPanel.add(remainField);
        jPanel.add(details);
        jPanel.add(scrollPane);
        jPanel.add(bg);
        container.add(jPanel);

        table.setPreferredScrollableViewportSize(new Dimension(400, 100));
        cancel.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancel) {
            this.dispose();
    }
    }//设置行为监听器

    private font font=new font();
    private Container container = getContentPane();
    private JPanel jPanel= new JPanel();
    private JLabel bookid = new JLabel("Book Id:");
    private JLabel bookName = new JLabel("Book Name:");
    private JLabel author = new JLabel("Author:");
    private JLabel press = new JLabel("Press:");
    private JLabel pressTime = new JLabel("Press time:");
    private JLabel bookIntroduction = new JLabel("Introduction:");
    private JLabel storage = new JLabel("Storage:");
    private JLabel remain = new JLabel("Remain:");
    private JLabel idField = new JLabel();
    private JLabel nameField = new JLabel();
    private JLabel authorField = new JLabel();
    private JLabel pressField = new JLabel();
    private JLabel pressTimeField = new JLabel();
    private JLabel abstractField = new JLabel();
    private JLabel storageField = new JLabel();
    private JLabel remainField = new JLabel();
    private JButton cancel = new JButton("Cancel");
    private JLabel details = new JLabel("Borrow and reaturn details");
    private Object[] s = { "Student Id", "Borrow time", "Deadline", "Over time" };
    private Object[][] ob1 = new Object[7][4];
    private JTable table = new JTable(ob1, s);
    private JScrollPane scrollPane = new JScrollPane(table);
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/Book.jpg");


}
