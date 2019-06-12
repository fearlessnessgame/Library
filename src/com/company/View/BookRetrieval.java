package com.company.View;

import com.company.Book.BookDetails;
import com.company.Book.BookInfo;
import com.company.Tool.SQL;
import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
//图书检索界面
class BookRetrieval extends JFrame implements ActionListener, SQL {
    private tool op = new tool();

    public BookRetrieval() {

        ob = op.allBook();
        for (int i = 0; i < 5; i++) {
            DefaultTableModel books = new DefaultTableModel(ob, s);
            for (int n = 0; n < 40; n++) {
                for (int m = 0; m < 8; m++) {
                    ob[n][m] = this.ob[n][m];
                }
                table.setModel(books);
                table.invalidate();
            }
        }
        jFrame.add(jPanel2, BorderLayout.NORTH);
        jFrame.add(jPanel1, BorderLayout.CENTER);
        jFrame.add(jPanel3, BorderLayout.SOUTH);

        bookId.setFont(font.JLableFont());
        bookName.setFont(font.JLableFont());

        id.setFont(font.JTextFiledFont());
        name.setFont(font.JTextFiledFont());

        search.setFont(font.JBottonFont());
        fresh.setFont(font.JBottonFont());
        search1.setFont(font.JBottonFont());


        jPanel2.setLayout(new GridLayout(2, 4, 20, 10));
        jPanel2.add(back);
        jPanel2.add(addBook);
        jPanel2.add(editBook);
        jPanel2.add(deleteBook);
        jPanel2.add(borrowBook);
        jPanel2.add(returnBook);
        jPanel1.setLayout(new GridLayout(1,1,10,10));

        jPanel1.add(scrollPane);
        jPanel3.setLayout(new GridLayout(7, 1, 0, 0));
        jPanel3.add(bookId);
        jPanel3.add(id);
        jPanel3.add(bookName);
        jPanel3.add(name);
        jPanel3.add(search);
        jPanel3.add(search1);
        jPanel3.add(fresh);
        table.setPreferredScrollableViewportSize(new Dimension(400, 300));


        fresh.addActionListener(this);
        addBook.addActionListener(this);
        search.addActionListener(this);
        search1.addActionListener(this);
        back.addActionListener(this);
        deleteBook.addActionListener(this);
        editBook.addActionListener(this);
        borrowBook.addActionListener(this);
        returnBook.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {
            ArrayList<String> strArray = new ArrayList<String>();
            strArray = op.addBookJudgement();
            String s1 = id.getText();
            String s2 = name.getText();
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

        if(e.getSource()==search1){
           new BookTable(id.getText(),name.getText());

        }

        if (e.getSource() == back) {
            this.dispose();
           new MainJFrame();
        }
        if (e.getSource() == addBook) {
            new AddBook();
        }
        if (e.getSource() == deleteBook) {
            new DeleteBook();

        }
        if (e.getSource() == borrowBook) {
           new BorrowBook();
        }
        if (e.getSource() == returnBook) {
         new ReturnBook();

        }
        if (e.getSource() == editBook) {
           new SelectEditBook();
        }
        if(e.getSource()==fresh){
            this.dispose();
            BookRetrieval page1 = new BookRetrieval();
            page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            page1.setTitle("Book Retrieval");
            page1.setLocation(500,300);
            page1.setSize(815, 600);
            page1.setVisible(true);
        }
    }
    private font font=new font();
    private Container jFrame = getContentPane();
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private JPanel jPanel3 = new JPanel();
    private JLabel bookId = new JLabel("Book Id:");
    private JLabel bookName = new JLabel("Book Name:");
    private JTextField id = new JTextField();
    private JTextField name = new JTextField();
    private JButton back = new JButton("Back ");
    private JButton addBook = new JButton("Add a book");
    private JButton deleteBook = new JButton("Delete a book");
    private JButton editBook = new JButton("Edit a book");
    private JButton search = new JButton("Search for details");
    private JButton search1=new JButton("Search");
    private JButton fresh=new JButton("Fresh");
    private JButton borrowBook = new JButton("Borrow a book");
    private JButton returnBook = new JButton("Return a book");
    private Object[] s = { "Id", "Name", "Author", "Press", "Press Time",
            "Introduction", "Storage", "Remain" };
    private Object[][] ob = new Object[200][8];
    private JTable table = new JTable(ob, s);
    private JScrollPane scrollPane = new JScrollPane(table);
}

