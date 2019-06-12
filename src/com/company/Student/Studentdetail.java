package com.company.Student;

import com.company.Tool.font;
import com.company.Tool.tool;
import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Studentdetail extends JFrame implements ActionListener {

    private tool op = new tool();

    public Studentdetail(String id) {


        bg=new JLabel(img);
        this.setTitle("Student Details");
        this.setLocation(300,100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(650,700);
        this.setVisible(true);
        this.setResizable(false);
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        scrollPane.setBounds(0, 0, 800, 300);
        StudentId.setBounds(160,80,150,50);
        StudentName.setBounds(160,150,150,50);
        password.setBounds(160,220,200,50);
        sex.setBounds(160,290,150,50);
        dpt.setBounds(160,360,150,50);
        grade.setBounds(160,430,150,50);

        IdField.setBounds(360,80,150,50);
        nameField.setBounds(360,150,150,50);
        passwordField.setBounds(360,220,150,50);
        sexField.setBounds(360,290,150,50);
        dptField.setBounds(360,360,150,50);
        gradeField.setBounds(360,430,150,50);

        scrollPane.setBounds(35,520,600,200);


        StudentId.setFont(font.JLableFont());
        StudentName.setFont(font.JLableFont());
        sex.setFont(font.JLableFont());
        password.setFont(font.JLableFont());
        dpt.setFont(font.JLableFont());
        grade.setFont(font.JLableFont());

        IdField.setFont(font.JTextFiledFont());
        nameField.setFont(font.JTextFiledFont());
        passwordField.setFont(font.JTextFiledFont());
        sexField.setFont(font.JTextFiledFont());
        dptField.setFont(font.JTextFiledFont());
        gradeField.setFont(font.JTextFiledFont());

        StudentInfo student = new StudentInfo(id);
        ob1 = op.borrowListForStudent(id);
        for (int i = 0; i < 4; i++) {
            DefaultTableModel books = new DefaultTableModel(ob1, s);
            for (int n = 0; n < 6; n++) {
                for (int m = 0; m < 4; m++) {
                    ob1[n][m] = this.ob1[n][m];
                }
                table.setModel(books);
                table.invalidate();
            }
        }

        ArrayList<String> strArray = new ArrayList<String>();

        //获得对应学生编号所有信息的数组
        strArray = op.outputStudent(student);

        //赋值处理
        IdField.setText(id);
        nameField.setText(strArray.get(1));
        passwordField.setText(strArray.get(2));
        sexField.setText(strArray.get(3));
        dptField.setText(strArray.get(4));
        gradeField.setText(strArray.get(5));

        jPanel.setLayout(null);


        jPanel.add(StudentId);
        jPanel.add(IdField);
        jPanel.add(StudentName);
        jPanel.add(nameField);
        jPanel.add(password);
        jPanel.add(passwordField);
        jPanel.add(sex);
        jPanel.add(sexField);
        jPanel.add(dpt);
        jPanel.add(dptField);
        jPanel.add(grade);
        jPanel.add(gradeField);
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
    }

    private font font=new font();
    private Container container = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel StudentId = new JLabel("Student Id:");
    private JLabel StudentName = new JLabel("Student Name:");
    private JLabel password=new JLabel("Student password:");
    private JLabel sex = new JLabel("Sex:");
    private JLabel dpt = new JLabel("Department:");
    private JLabel grade = new JLabel("Grade:");
    private JLabel IdField = new JLabel();
    private JLabel nameField = new JLabel();
    private JLabel passwordField=new JLabel();
    private JLabel sexField = new JLabel();
    private JLabel dptField = new JLabel();
    private JLabel gradeField = new JLabel();
    private JLabel details = new JLabel("Borrow and reaturn details");
    private JButton cancel = new JButton("Cancel");
    private Object[] s = {"Book ID", "Borrow time", "Deadline", "Over time"};
    private Object[][] ob1 = new Object[7][5];
    private JTable table = new JTable(ob1, s);
    private JScrollPane scrollPane = new JScrollPane(table);
    private JLabel bg;
    private ImageIcon img=new ImageIcon("C:\\Users\\13278\\IdeaProjects\\library\\images\\Book.jpg");

}
