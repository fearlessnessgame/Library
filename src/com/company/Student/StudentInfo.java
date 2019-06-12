package com.company.Student;

public class StudentInfo {

    //不含参数的构造函数
    public StudentInfo(){
    };

    //以学生所有信息为形参的构造函数
    public StudentInfo(String ID, String name, String password, String sex, String dpt, int grade) {
        this.ID =ID;
        this.name = name;
        this.password=password;
        this.sex = sex;
        this.dpt = dpt;
        this.grade = grade;
    }

    //以学生编号和姓名为形参的构造函数
    public StudentInfo(String id, String name) {
        this.ID = id;
        this.name = name;
    }

    //以学生编号为形参的构造函数
    public StudentInfo(String id) {
        this.ID = id;
    }

    //以下函数返回学生的各种信息
    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getDpt() {
        return dpt;
    }

    public String getPassword() {
        return password;
    }

    public int getGrade() {
        return grade;
    }

    private String ID;//学生编号
    private String password;//学生密码
    private String name;//学生名字
    private String sex;//学生性别
    private String dpt;//学生专业
    private int grade;//学生年级
}
