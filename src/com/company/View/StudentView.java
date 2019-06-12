package com.company.View;

import com.company.Student.StudentInfo;
import com.company.Tool.font;
import com.company.Tool.tool;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class StudentView extends JFrame implements ActionListener {

public StudentView(String id){

    bg=new JLabel(img);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLocation(450,250);
    jFrame.setVisible(true);
    jFrame.setSize(img.getIconWidth(),img.getIconHeight());
    jFrame.setTitle("Student View");
    jPanel.setLayout(null);
    bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());

    search.setBounds(750,50,200,50);
    Borrow.setBounds(750,200,200,50);
    Return.setBounds(750,350,200,50);
    save.setBounds(750,500,200,50);
    Back.setBounds(750,650,200,50);

    StudentId.setBounds(50,70,200,50);
    StudentName.setBounds(50,180,250,50);
    StudentPassword.setBounds(50,290,150,50);
    sex.setBounds(50,400,200,50);
    dpt.setBounds(50,510,200,50);
    grade.setBounds(50,620,200,50);

    IdField.setBounds(400,70,200,50);
    nameField.setBounds(400,180,200,50);
    passwordField.setBounds(400,290,200,50);
    sexField.setBounds(400,400,200,50);
    dptField.setBounds(400,510,200,50);
    gradeField.setBounds(400,620,200,50);

    Borrow.setFont(font.JBottonFont());
    Return.setFont(font.JBottonFont());
    Back.setFont(font.JBottonFont());
    search.setFont(font.JBottonFont());
    save.setFont(font.JBottonFont());
    StudentId.setFont(font.Title());
    StudentName.setFont(font.Title());
    StudentPassword.setFont(font.Title());
    sex.setFont(font.Title());
    dpt.setFont(font.Title());
    grade.setFont(font.Title());

   IdField.setForeground(Color.RED);
   nameField.setForeground(Color.RED);
   passwordField.setForeground(Color.RED);
   sexField.setForeground(Color.RED);
   dptField.setForeground(Color.RED);
   gradeField.setForeground(Color.RED);
    IdField.setFont(font.Title());
    nameField.setFont(font.Title());
    passwordField.setFont(font.Title());
    sexField.setFont(font.Title());
    dptField.setFont(font.Title());
    gradeField.setFont(font.Title());

    jPanel.add(StudentId);
    jPanel.add(StudentName);
    jPanel.add(StudentPassword);
    jPanel.add(sex);
    jPanel.add(dpt);
    jPanel.add(grade);
    jPanel.add(IdField);
    jPanel.add(nameField);
    jPanel.add(passwordField);
    jPanel.add(sexField);
    jPanel.add(dptField);
    jPanel.add(gradeField);
    jPanel.add(save);
    jPanel.add(search);
    jPanel.add(Borrow);
    jPanel.add(Return);
    jPanel.add(Back);


    IdField.setText(id);
    StudentInfo student = new StudentInfo(id);
    ArrayList<String> strArray = new ArrayList<String>();
    strArray = op.outputStudent(student);

    nameField.setText(strArray.get(1));
    passwordField.setText(strArray.get(2));
    sexField.setText(strArray.get(3));
    dptField.setText(strArray.get(4));
    gradeField.setText(strArray.get(5));



    jPanel.add(bg);
    jFrame.add(jPanel);

    save.addActionListener(this);
    search.addActionListener(this);
    Borrow.addActionListener(this);
    Return.addActionListener(this);
    Back.addActionListener(this);
}




    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==search){
            new BookSearch();

        }

        if(e.getSource()==Borrow){
            new BorrowBook();

        }

        if(e.getSource()==Return){
            new ReturnBook();
        }

        if(e.getSource()==Back){
            jFrame.dispose();
            new Main();

        }

        if(e.getSource()==save){
            StudentInfo student = new StudentInfo(IdField.getText(), nameField.getText(),passwordField.getText(), sexField.getText(), dptField.getText(), Integer.parseInt(gradeField.getText()));
            if (!sexField.getText().equals("boy")
                    && !sexField.getText().equals("girl")) {
                JOptionPane
                        .showMessageDialog(null, "In the Sex field, you can only input 'boy' or 'girl'！", "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else {
                op.inputStudent(student);
                JOptionPane.showMessageDialog(null, "Edit the student successfully！", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }


    }

    private tool op = new tool();
    private  font font=new font();
    private JFrame jFrame=new JFrame();
    private JPanel jPanel=new JPanel();
    private JButton search=new JButton("Search");
    private JButton Borrow=new JButton("Borrow");
    private JButton Return=new JButton("Return");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/Student.jpg");
    private JButton Back=new JButton("Back");

    private JLabel StudentId = new JLabel("Student Id:");
    private JLabel StudentName = new JLabel("Student Name:");
    private JLabel StudentPassword=new JLabel("Password");
    private JLabel sex = new JLabel("Sex:");
    private JLabel dpt = new JLabel("Department:");
    private JLabel grade = new JLabel("Grade:");
    private JLabel IdField = new JLabel();
    private JTextField passwordField=new JTextField();
    private JLabel nameField = new JLabel();
    private JLabel sexField = new JLabel();
    private JLabel dptField = new JLabel();
    private JLabel gradeField = new JLabel();
    private JButton save = new JButton("Save");
}
