package com.company.View;

import com.company.Student.StudentInfo;
import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//删除学生界面
class DeleteStudent extends JFrame implements ActionListener {

    public DeleteStudent() {

        bg=new JLabel(img);
        this.setTitle("Delete Student");
        this.setLocation(300,200);
        this.setSize(img.getIconWidth(),img.getIconHeight());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);


        jPanel.setLayout(null);
        StduentId.setBounds(80,100,150,50);
        idField.setBounds(250,100,200,50);
        cancel.setBounds(250,200,200,50);
        delete.setBounds(30,200,200,50);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
        StduentId.setFont(font.JLableFont());
        idField.setFont(font.JTextFiledFont());

        cancel.setFont(font.JBottonFont());
        delete.setFont(font.JBottonFont());

        jPanel.add(StduentId);
        jPanel.add(idField);
        jPanel.add(cancel);
        jPanel.add(delete);
        jPanel.add(bg);
        c.add(jPanel);
        cancel.addActionListener(this);
        delete.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == cancel) {
            this.dispose();
        }
        if (e.getSource() == delete) {
            StudentInfo student = new StudentInfo(idField.getText());
            this.dispose();
            if (op.deleteStudentCheck(idField.getText()) != 0) {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Delete the student unsuccessfully. Please return books first!",
                                "Warning", JOptionPane.INFORMATION_MESSAGE);

            } else {
                if (op.deleteStudent(student) == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Delete the student successfully！", "Information",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "Delete the student unsuccessfully. The student does not exist!",
                                    "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private font font=new font();
    private tool op = new tool();
    private Container c = getContentPane();
    private JPanel jPanel = new JPanel();
    private JLabel StduentId = new JLabel("Student id:");
    private JTextField idField = new JTextField();
    private JButton cancel = new JButton("Cancel");
    private JButton delete = new JButton("Delete");
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/jframe1.jpg");

}