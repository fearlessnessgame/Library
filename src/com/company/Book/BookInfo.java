package com.company.Book;


//图书概况
public class BookInfo {

    //不含参数的构造函数
    public BookInfo(){
    }

    //以图书编号为形参的构造函数
    public BookInfo(String Id) {
        this.Id = Id;
    }

    //以图书编号和书名为形参的构造函数
    public BookInfo(String Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    //以所以图书信息为形参的构造函数
    public BookInfo(String Id, String name, String author, String press,
                    String pressTime, String bookIntroduction, int total, int remain) {
        this.Id = Id;
        this.name = name;
        this.author = author;
        this.press = press;
        this.pressTime = pressTime;
        this.bookIntroduction = bookIntroduction;
        this.total = total;
        this.remain = remain;
    }

    //返回图书各类信息的函数
    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPress() {
        return press;
    }

    public String getPressTime() {
        return pressTime;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public int getTotal() {
        return total;
    }

    public int getRemain() {
        return remain;
    }

    private String Id;//图书编号
    private String name;//书名
    private String author;//作者
    private String press;//出版社
    private String pressTime;//出版时间
    private String bookIntroduction;//图书简介
    private int total;//图书总量
    private int remain;//图书库存量

}
