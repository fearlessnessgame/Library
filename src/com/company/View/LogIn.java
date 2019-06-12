package com.company.View;


import com.company.Tool.tool;
import com.company.Tool.font;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;



//登录界面
public class LogIn {

    public static void main(String[] args) {

        new Main();

    }
}

class Main extends JFrame  implements ActionListener{


    public Main() {

        bg = new JLabel(img);
        jFrame.setTitle("Log in");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(img.getIconWidth(),img.getIconHeight());
        jPanel.setLayout(null);
        bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());

        userName.setBounds(50,30,150,30);
        password.setBounds(50,80,150,30);
        nameField.setBounds(220,30,200,30);
        passField.setBounds(220,80,200,30);
        Student.setBounds(290,170,150,30);
        Manger.setBounds(290,220,150,30);
        displayArea.setBounds(50,200,300,50);

        nameField.setFont(font.JTextFiledFont());
        passField.setFont(font.JTextFiledFont());
        userName.setFont(font.JLableFont());
        password.setFont(font.JLableFont());
        Student.setFont(font.JBottonFont());
        Manger.setFont(font.JBottonFont());


        Student.addActionListener(this);
        Manger.addActionListener(this);

        jPanel.add(userName);
        jPanel.add(nameField);
        jPanel.add(password);
        jPanel.add(passField);
        jPanel.add(Student);
        jPanel.add(Manger);
        jPanel.add(displayArea);
        jPanel.add(bg);
        jFrame.add(jPanel);




    }


    private JFrame jFrame=new JFrame();
    private JLabel bg;
    private ImageIcon img=new ImageIcon("images/Log.jpg");
    private font font=new font();
    private JPanel jPanel = new JPanel();
    private JLabel displayArea=new JLabel();


    private JLabel userName = new JLabel("User name:");
    private JLabel password = new JLabel("Password:");
    private JTextField nameField = new JTextField();
    private JPasswordField passField = new JPasswordField();
    private JButton Manger = new JButton("Manger");
    private JButton Student=new JButton("Student");


    @Override
    public void actionPerformed(ActionEvent e) {


        tool op=new tool();
        if(e.getSource()==Student){
            ResultSet resultSet = null;
            try {
                resultSet = op.stlogCheck(nameField.getText(),passField.getText());
                if(resultSet.next()==true){
                    jFrame.dispose();
                    new StudentView(nameField.getText());
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter a validated student's name and password!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    passField.setText("");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }


        if(e.getSource()==Manger){
            ResultSet resultSet = null;
            try {
                resultSet=op.mglogCheck(nameField.getText(),passField.getText());
                if(resultSet.next()==true){
                    jFrame.dispose();
                    new MainJFrame();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter a validated manger's name and password!", "Warning", JOptionPane.INFORMATION_MESSAGE);
                    nameField.setText("");
                    passField.setText("");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

    }
}


}
