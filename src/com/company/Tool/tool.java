package com.company.Tool;

import com.company.Student.StudentInfo;
import com.company.Book.BookInfo;

import java.sql.*;
import java.util.ArrayList;

public class tool implements SQL{

    static PreparedStatement preparedStatement=null;
    static Connection connection=null;
    static ResultSet resultSet=null;

    //加载驱动+连接数据库
    public tool() {
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(Url, User, Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //检测管理员登录
    public ResultSet mglogCheck(String name, String password) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setString(1,name);
            ps.setString(2,password);
            resultSet = ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //检测学生登录
    public ResultSet stlogCheck(String id,String password) throws SQLException {

        try {
            PreparedStatement ps = connection.prepareStatement(sql27);
            ps.setString(1,id);
            ps.setString(2,password);
            resultSet = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //返回包含所有图书编号的数组
    public ArrayList addBookJudgement() {
        ArrayList<String> strArray = new ArrayList<String>();
        ArrayList<String> strArray1 = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                String s = resultSet.getString("bkid");
                strArray.add(s);
                count++;
            }
            strArray.add(Integer.toString(count));
            for (; count >= 0; count--) {
                strArray1.add(strArray.get(count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArray1;
    }

    //返回包含所有书名的数组
    public ArrayList addBookJudgement1() {
        ArrayList<String> strArray = new ArrayList<String>();
        ArrayList<String> strArray1 = new ArrayList<String>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql3);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                String s = resultSet.getString("bkname");
                strArray.add(s);
                count++;
            }
            strArray.add(Integer.toString(count));
            for (; count >= 0; count--) {
                strArray1.add(strArray.get(count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArray1;
    }

    //返回包含所有学生编号的数组
    public ArrayList addStudentJudgement() {
        ArrayList<String> strArray = new ArrayList<String>();
        ArrayList<String> strArray1 = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql4);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                String s = resultSet.getString("stid");
                strArray.add(s);
                count++;
            }
            strArray.add(Integer.toString(count));
            for (; count >= 0; count--) {
                strArray1.add(strArray.get(count));
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return strArray1;
    }

    //返回包含所有学生姓名的数组
    public ArrayList addStudentJudgement1() {
        ArrayList<String> strArray = new ArrayList<String>();
        ArrayList<String> strArray1 = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql5);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                String s = resultSet.getString("stname");
                strArray.add(s);
                count++;
            }
            strArray.add(Integer.toString(count));
            for (; count >= 0; count--) {
                strArray1.add(strArray.get(count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArray1;
    }

    //增加学生
    public void addStudent(StudentInfo student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql6);
            preparedStatement.setString(1, student.getID());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3,student.getPassword());
            preparedStatement.setString(4, student.getSex());
            preparedStatement.setString(5, student.getDpt());
            preparedStatement.setInt(6, student.getGrade());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //增加图书
    public void addBook(BookInfo book) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql7);
            preparedStatement.setString(1, book.getId());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getPress());
            preparedStatement.setString(5, book.getPressTime());
            preparedStatement.setString(6, book.getBookIntroduction());
            preparedStatement.setInt(7, book.getTotal());
            preparedStatement.setInt(8, book.getRemain());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //返回对应书名的图书编号
    public String searchBookByName(BookInfo book) {
        String s = null;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql8);
            preparedStatement.setString(1, book.getName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s = resultSet.getString("bkid");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    //返回对应的学生名字的学生编号
    public String searchStudentByName(StudentInfo student) {
        String s = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql9);
            preparedStatement.setString(1, student.getName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s = resultSet.getString("stid");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return s;
    }

    //删除图书
    public int deleteBook(BookInfo book) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql10);
            preparedStatement.setString(1, book.getId());
            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //删除学生
    public int deleteStudent(StudentInfo student) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql11);
            preparedStatement.setString(1, student.getID());
            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //返回包含对应图书编号的所有图书信息的数组
    public ArrayList outputBook(BookInfo book) {
        ArrayList<String> strArray = new ArrayList<String>();
        try {
            String s=null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql12);
            preparedStatement.setString(1, book.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s = resultSet.getString("bkid");
                strArray.add(s);
                s = resultSet.getString("bkname");
                strArray.add(s);
                s = resultSet.getString("author");
                strArray.add(s);
                s = resultSet.getString("press");
                strArray.add(s);
                s = resultSet.getString("bkdate");
                strArray.add(s);
                s = resultSet.getString("introduction");
                strArray.add(s);
                s = resultSet.getString("sum");
                strArray.add(s);
                s = resultSet.getString("num");
                strArray.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArray;
    }

    //返回对应学生编号的所有学生信息的数组
    public ArrayList outputStudent(StudentInfo student) {
        ArrayList<String> strArray = new ArrayList<String>();
        try {
            String s=null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql13);
            preparedStatement.setString(1, student.getID());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                s = resultSet.getString("stid");
                strArray.add(s);
                s = resultSet.getString("stname");
                strArray.add(s);
                s= resultSet.getString("stpassword");
                strArray.add(s);
                s = resultSet.getString("sex");
                strArray.add(s);
                s = resultSet.getString("department");
                strArray.add(s);
                s = resultSet.getString("grade");
                strArray.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArray;
    }

    //更新图书信息
    public void inputBook(BookInfo book) {
        ArrayList<String> strArray = new ArrayList<String>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql14);

            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getPress());
            preparedStatement.setString(4, book.getPressTime());
            preparedStatement.setString(5, book.getBookIntroduction());
            preparedStatement.setInt(6, book.getTotal());
            preparedStatement.setInt(7, book.getRemain());
            preparedStatement.setString(8, book.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //更新学生信息
    public void inputStudent(StudentInfo student) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql15);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getPassword());
            preparedStatement.setString(3, student.getSex());
            preparedStatement.setString(4, student.getDpt());
            preparedStatement.setInt(5, student.getGrade());
            preparedStatement.setString(6, student.getID());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //返回图书详细信息的表格
    public Object[][] allBook() {
        Object[][] ob = new Object[60][8];
        int n = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql16);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ob[n][0] = resultSet.getString("bkid");
                ob[n][1] = resultSet.getString("bkname");
                ob[n][2] = resultSet.getString("author");
                ob[n][3] = resultSet.getString("press");
                ob[n][4] = resultSet.getString("bkdate");
                ob[n][5] = resultSet.getString("introduction");
                ob[n][6] = resultSet.getString("sum");
                ob[n][7] = resultSet.getString("num");
                n++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }

    //返回对应名字图书的详细信息表格
    public Object[][] NameBook(String bookName) {
        Object[][] ob = new Object[60][8];
        int n = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql26);
            preparedStatement.setString(1,bookName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ob[n][0] = resultSet.getString("bkid");
                ob[n][1] = resultSet.getString("bkname");
                ob[n][2] = resultSet.getString("author");
                ob[n][3] = resultSet.getString("press");
                ob[n][4] = resultSet.getString("bkdate");
                ob[n][5] = resultSet.getString("introduction");
                ob[n][6] = resultSet.getString("sum");
                ob[n][7] = resultSet.getString("num");
                n++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }

    //返回学生详细信息的表格
    public Object[][] allStudent() {
        Object[][] ob = new Object[60][6];
        int n = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql17);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ob[n][0] = resultSet.getString("stid");
                ob[n][1] = resultSet.getString("stname");
                ob[n][2]= resultSet.getString("stpassword");
                ob[n][3] = resultSet.getString("sex");
                ob[n][4] = resultSet.getString("department");
                ob[n][5] = resultSet.getString("grade");
                n++;
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return ob;
    }

    //返回对应姓名的学生详细信息表格
    public Object[][] NameStudent(String studentName) {
        Object[][] ob = new Object[60][6];
        int n = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql25);
            preparedStatement.setString(1,studentName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ob[n][0] = resultSet.getString("stid");
                ob[n][1] = resultSet.getString("stname");
                ob[n][2]= resultSet.getString("stpassword");
                ob[n][3] = resultSet.getString("sex");
                ob[n][4] = resultSet.getString("department");
                ob[n][5] = resultSet.getString("grade");
                n++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }

    //借阅时候往数据库library的borrow表添加数据
    public void insertBorrow(String bookId, String studentId, String borrowTime, String deadline) {
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql18);
            preparedStatement.setString(1, bookId);
            preparedStatement.setString(2, studentId);
            preparedStatement.setString(3, borrowTime);
            preparedStatement.setString(4, deadline);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //查询图书借阅情况
    public int reBorrowCheck(String bookId, String studentId) {
        int i = 0;
        ArrayList<String> strArray = new ArrayList<String>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql19);
            preparedStatement.setString(1, bookId);
            preparedStatement.setString(2, studentId);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                String s = resultSet.getString("bkid");
                strArray.add(s);
                s = resultSet.getString("stid");
                strArray.add(s);
                count++;
            }
            System.out.println(strArray);
            if (count >= 1) {
                i = 1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //查询图书归还日期
    public int deadLineCheck(String StudentId, long currentTime) {
        int i = 0;
        ArrayList<String> strArray = new ArrayList<String>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql20);
            preparedStatement.setString(1, StudentId);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                String s = resultSet.getString("redate");
                strArray.add(s);
                count++;
            }
            for (; count > 0; count--) {
                if (Long.parseLong(strArray.get(count - 1)) <= currentTime) {
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //查询图书归还情况
    public int returnCheck(String bookId, String studentId) {
        int i = 0;
        ArrayList<String> strArray = new ArrayList<String>();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql21);
            preparedStatement.setString(1, bookId);
            preparedStatement.setString(2, studentId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String s = resultSet.getString("bkid");
                strArray.add(s);
                s = resultSet.getString("stid");
                strArray.add(s);
            }
            System.out.println(strArray);
            if (strArray.get(0) != bookId
                    || strArray.get(1) != studentId) {
                i = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        return i;
    }

    //删除学生
    public int deleteResult(String bookNumber, String studentId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql22);
            preparedStatement.setString(1, bookNumber);
            preparedStatement.setString(2, studentId);
            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    //创建借阅表
    public Object[][] borrowList() {
        Date dateCal = new Date();
        Object[][] ob = new Object[100][5];
        int n = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql23);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ob[n][0] = resultSet.getString("bkid");
                ob[n][1] = resultSet.getString("stid");
                String s = dateCal.borrowTimeInterface(Long.parseLong(resultSet
                        .getString("brdate")));
                ob[n][2] = s;
                long re = Long.parseLong(resultSet.getString("redate"));
                s = dateCal.borrowTimeInterface(re);
                ob[n][3] = s;
                long re1 = System.currentTimeMillis();
                if (re1 > re) {
                    ob[n][4] = Long.toString(((re1 - re) / 86400000)+1) + " Days";
                } else {
                    ob[n][4] = "NOT";
                }
                n++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }

    //返回学生的借阅表（显示学生借阅信息）
    public Object[][] borrowListForStudent(String studentId) {
        Date dateCal = new Date();
        Object[][] ob = new Object[100][4];
        int n = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql20);
            preparedStatement.setString(1, studentId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ob[n][0] = resultSet.getString("bkid");
                String s = dateCal.borrowTimeInterface(Long.parseLong(resultSet
                        .getString("brdate")));
                ob[n][1] = s;
                long re = Long.parseLong(resultSet.getString("redate"));
                s = dateCal.borrowTimeInterface(re);
                ob[n][2] = s;
                long re1 = System.currentTimeMillis();
                if (re1 > re) {
                    ob[n][3] = Long.toString(((re1 - re) / 86400000)+1) + " Days";
                } else {
                    ob[n][3] = "NOT";
                }
                n++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }

    //创建图书借阅表（显示图书的借阅情况）
    public Object[][] borrowListForBook(String bookId) {
        Date dateCal = new Date();
        Object[][] ob = new Object[100][8];
        int n = 0;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql24);
            preparedStatement.setString(1, bookId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ob[n][0] = resultSet.getString("stid");
                String s = dateCal.borrowTimeInterface(Long.parseLong(resultSet
                        .getString("brdate")));
                ob[n][1] = s;
                long re = Long.parseLong(resultSet.getString("redate"));
                s = dateCal.borrowTimeInterface(re);
                ob[n][2] = s;
                long re1 = System.currentTimeMillis();
                if (re1 > re) {
                    ob[n][3] = Long.toString(((re1 - re) / 86400000)+1) + " Days";
                } else {
                    ob[n][3] = "NOT";
                }
                n++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }

    //返回借阅表的对应图书信息
    public int deleteBookCheck(String bookId) {
        int i = 0;
        ArrayList<String> strArray = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql23);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                String s = resultSet.getString("bkid");
                strArray.add(s);
                count++;
            }
            for (; count > 0; count--) {
                if (strArray.get(count - 1).equals(bookId)) {
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    //返回借阅表的对应学生信息
    public int deleteStudentCheck(String studentId) {
        int i = 0;
        ArrayList<String> strArray = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql23);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                String s = resultSet.getString("stid");
                strArray.add(s);
                count++;
            }
            for (; count > 0; count--) {
                if (strArray.get(count - 1).equals(studentId)) {
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}