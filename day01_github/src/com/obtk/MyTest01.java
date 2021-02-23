package com.obtk;

public class MyTest01 {

    public static void main(String[] args) {
        System.out.println("第一次执行");
        Student student = new Student("ls","223",20);
        sendHello();
        System.out.println("第二次执行");
        System.out.println("---------------");
        System.out.println("第三次执行");
    }

    static class Student{
        private String username;
        private String password;
        private int age;


        public Student(String username, String password,int age) {
            this.username = username;
            this.password = password;
            this.age = age;
        }
    }
    public static void sendHello(){
        System.out.println("hello Github  ^。^!");
    }
}
