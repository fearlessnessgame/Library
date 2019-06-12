package com.company.View;

import com.company.Student.Studentdetail;
import com.company.Student.StudentInfo;
import com.company.Tool.font;
import com.company.Tool.SQL;
import com.company.Tool.tool;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//学生检索界面
class StudentRetrieval extends JFrame implements ActionListener, SQL {


    public StudentRetrieval() {
        op.allStudent();
        ob = op.allStudent();
        for (int i = 0; i < 5; i++) {
            DefaultTableModel students = new DefaultTableModel(ob, s);
            for (int n = 0; n < 40; n++) {
                for (int m = 0; m < 5; m++) {
                    ob[n][m] = this.ob[n][m];
                }
                table.setModel(students);
                table.invalidate();
            }
        }

        container.add(jPanel, BorderLayout.NORTH);
        container.add(jPanel1, BorderLayout.CENTER);
        container.add(jPanel2, BorderLayout.SOUTH);
        jPanel.setLayout(new GridLayout(2, 5, 20, 10));
        jPanel.add(back);
        jPanel.add(addStudent);
        jPanel.add(editStudent);
        jPanel.add(deleteStudent);
        jPanel1.setLayout(new GridLayout(1,1,10,10));

        jPanel1.add(scrollPane);

        studentID.setFont(font.JLableFont());
        studentName.setFont(font.JLableFont());

        id.setFont(font.JTextFiledFont());
        name.setFont(font.JTextFiledFont());

        search.setFont(font.JBottonFont());
        search1.setFont(font.JBottonFont());
        fresh.setFont(font.JBottonFont());


        jPanel2.setLayout(new GridLayout(7, 1, 0, 0));
        jPanel2.add(studentID);
        jPanel2.add(id);
        jPanel2.add(studentName);
        jPanel2.add(name);
        jPanel2.add(search);
        jPanel2.add(search1);
        jPanel2.add(fresh);
        fresh.addActionListener(this);
        addStudent.addActionListener(this);
        search.addActionListener(this);
        search1.addActionListener(this);
        back.addActionListener(this);
        deleteStudent.addActionListener(this);
        editStudent.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //搜索事件
        if (e.getSource() == search) {
            ArrayList<String> strArray = new ArrayList<String>();
            strArray = op.addStudentJudgement();
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
            strArray1 = op.addStudentJudgement1();
            int n1 = 0;
            int replicate1 = 0;
            while (n1 < Integer.parseInt(strArray1.get(0))) {
                n1++;
                if (s2.equals(strArray1.get(n1))) {
                    replicate1++;
                }
            }

            if (replicate == 0 && replicate1 == 0) {
                JOptionPane.showMessageDialog(null,
                        "Please input a correct student id or name!",
                        "Warning", JOptionPane.INFORMATION_MESSAGE);
            } else if (replicate != 0 || replicate1 != 0) {
                if (replicate == 0 && replicate1 != 0) {
                    StudentInfo student = new StudentInfo(s1, s2);
                    String s=op.searchStudentByName(student);
                   new Studentdetail(s);

                } else if (replicate != 0) {
                    new Studentdetail(s1);
                }
            }

        }
        if(e.getSource()==search1) {
            StudentTable f = new StudentTable(id.getText(), name.getText());
            f.setVisible(true);
            f.setSize(600, 400);
            f.setLocationRelativeTo(null);
            f.setTitle("Student Table");
        }
        //返回时发生的事件
        if (e.getSource() == back) {
            this.dispose();
         new MainJFrame();

        }

        //添加学生事件
        if (e.getSource() == addStudent) {
            new AddStudent();
        }

        //删除学生事件
        if (e.getSource() == deleteStudent) {
           new DeleteStudent();

        }

        //编辑学生事件
        if (e.getSource() == editStudent) {
            new SelectEditStudent();
        }
        //刷新事件
        if(e.getSource()==fresh){
            this.dispose();
            StudentRetrieval page2 = new StudentRetrieval();
            page2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            page2.setTitle("Student Retrieval");
            page2.setLocation(500,400);
            page2.setSize(615, 600);
            page2.setVisible(true);
        }
    }

    private font font=new font();
   private tool op = new tool();
   private Container container = getContentPane();
   private JPanel jPanel1 = new JPanel();
   private JPanel jPanel = new JPanel();
   private JPanel jPanel2 = new JPanel();
   private JLabel studentID = new JLabel("Student Id:");
   private JLabel studentName = new JLabel("Student Name:");
   private JTextField id= new JTextField();
   private JTextField name = new JTextField();
   private JButton back = new JButton("Back");
   private JButton addStudent = new JButton("Add a student");
   private JButton deleteStudent = new JButton("Delete a student");
   private JButton editStudent = new JButton("Edit a student");
   private JButton fresh =new JButton("Fresh");
   private JButton search1=new JButton("Search");
   private JButton search = new JButton("Search for details");
   private Object[] s = { "Id", "Name","Password","Sex", "Department", "Grade" };
   private Object[][] ob = new Object[200][6];
   private JTable table = new JTable(ob, s);
   private JScrollPane scrollPane = new JScrollPane(table);
}
