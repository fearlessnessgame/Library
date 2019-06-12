package com.company.Tool;

public interface SQL {
    String Url="jdbc:mysql://localhost:3306/library?useSSL=false&useUnicode=true&characterEncoding=utf8";
    String User="root";//数据库用户名
    String Password="1234";//数据库密码
    String Driver ="com.mysql.jdbc.Driver";//驱动


    //SQL功能语句
    String sql1="select * from manger where mgname=? and mgpassword=?;";
    String sql2 = "select bkid FROM book;";
    String sql3 = "select bkname FROM book;";
    String sql4 = "select stid From student;";
    String sql5 = "select stname FROM student;";
    String sql6 = "iNSERT INTO student(stid,stname,stpassword,sex,department,grade) VALUES (?,?,?,?,?,?);";
    String sql7 = "iNSERT INTO book(bkid,bkname,author,press,bkdate,introduction,sum,num) VALUES (?,?,?,?,?,?,?,?);";
    String sql8 = "select bkid FROM book where bkname=?;";
    String sql9 = "select stid FROM student where stname=?;";
    String sql10 = "delete FROM book where bkid=?;";
    String sql11 = "delete FROM student where stid=?;";
    String sql12 = "select * FROM book where bkid=?;";
    String sql13 = "select * FROM student where stid=?;";
    String sql14 = "update book set bkname=?,author=?,press=?,bkdate=?,introduction=?,sum=?,num=?  where bkid=?;";
    String sql15 = "update student set stname=?,stpassword=?,sex=?,department=?,grade=?  where stid=?;";
    String sql16 = "select * FROM book;";
    String sql17 = "select * FROM student;";
    String sql18 = "insert Into borrow ( bkid , stid,brdate, redate) values(?,?,?,?)";
    String sql19 = "select *  FROM borrow  where bkid=? and stid=?;";
    String sql20 = "select *  FROM borrow  where stid=?;";
    String sql21 = "select *  FROM borrow  where bkid=? and stid=?;";
    String sql22 = "delete FROM borrow where bkid=? and stid=?;";
    String sql23 = "select * FROM borrow;";
    String sql24 = "select * FROM borrow where bkid=?;";
    String sql25 = "select * From student where stname=?;";
    String sql26 = "select * From book where bkname=?;";
    String sql27 = "select * from student where stid=? and stpassword=?;";
}
