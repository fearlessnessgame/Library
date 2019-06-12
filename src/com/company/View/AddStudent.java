package com.company.View;

import com.company.Tool.font;
import com.company.Student.StudentInfo;
import com.company.Tool.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//添加学生界面
public class AddStudent extends JFrame implements ActionListener {

    tool op = new tool();


    public AddStudent() {

        bg=new JLabel(img);
        this.setTitle("Add Student");
        this.setLocation(300,200);
        this.setSize(img.getIconWidth(),650);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());

        jPanel.setLayout(null);
        StudentId.setBounds(130,80,150,50);
        StudentName.setBounds(130,150,150,50);
        StudentPassword.setBounds(130,220,200,50);
        sex.setBounds(130,290,150,50);
        dpt.setBounds(130,360,150,50);
        grade.setBounds(130,430,150,50);


        IdField.setBounds(360,80,250,50);
        nameField.setBounds(360,150,250,50);
        passwordField.setBounds(360,220,250,50);
        sexField.setBounds(360,290,250,50);
        dptField.setBounds(360,360,250,50);
        gradeField.setBounds(360,430,250,50);
        confirm.setBounds(360,520,150,50);
        cancel.setBounds(160,520,150,50);

        StudentId.setFont(font.JLableFont());
        StudentName.setFont(font.JLableFont());
        StudentPassword.setFont(font.JLableFont());
        sex.setFont(font.JLableFont());
        dpt.setFont(font.JLableFont());
        grade.setFont(font.JLableFont());

        IdField.setFont(font.JTextFiledFont());
        nameField.setFont(font.JTextFiledFont());
        passwordField.setFont(font.JTextFiledFont());
        sexField.setFont(font.JTextFiledFont());
        dptField.setFont(font.JTextFiledFont());
        gradeField.setFont(font.JTextFiledFont());

        cancel.setFont(font.JBottonFont());
        confirm.setFont(font.JBottonFont());

        jPanel.add(StudentId);
        jPanel.add(IdField);
        jPanel.add(StudentName);
        jPanel.add(nameField);
        jPanel.add(StudentPassword);
        jPanel.add(passwordField);
        jPanel.add(sex);
        jPanel.add(sexField);
        jPanel.add(dpt);
        jPanel.add(dptField);
        jPanel.add(grade);
        jPanel.add(gradeField);
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
            StudentInfo student = new StudentInfo(IdField.getText(),nameField.getText(),passwordField.getText(),sexField.getText(),dptField.getText(),Integer.parseInt(gradeField.getText()));
            ArrayList<String> strArray = new ArrayList<String>();
            strArray = op.addStudentJudgement();
            int n = 0;
            int replicate = 0;
            while (n < Integer.parseInt(strArray.get(0))) {
                n++;
                if (IdField.getText().equals(strArray.get(n))) {
                    replicate++;
                }
            }
            if (replicate == 0) {
                if (!sexField.getText().equals("boy")
                        && !sexField.getText().equals("girl")) {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "In the Sex field, you can only input 'boy' or 'girl'！",
                                    "Warning", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    op.addStudent(student);
                    JOptionPane.showMessageDialog(null,
                            "Add a student successfully！", "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null,
                        "This student(id) has already existed!", "Warning",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private font font=new font();
    private Container c = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel StudentId = new JLabel("Student ID:");
    private JLabel StudentName = new JLabel("Student Name:");
    private JLabel StudentPassword =new JLabel("Student Password:");
    private JLabel sex = new JLabel("Sex:");
    private JLabel dpt = new JLabel("Department:");
    private JLabel grade = new JLabel("Grade:");
    private JTextField IdField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField passwordField =new JTextField();
    private JTextField sexField = new JTextField();
    private JTextField dptField = new JTextField();
    private JTextField gradeField = new JTextField();
    private JButton cancel = new JButton("Cancel");
    private JButton confirm = new JButton("Confirm");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/Book.jpg");

}
