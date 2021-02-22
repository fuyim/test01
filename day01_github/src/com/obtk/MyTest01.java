package com.obtk;

public class MyTest01 {

    public static void main(String[] args) {
        System.out.println("第一次执行");
        Student student = new Student("ls","223");
        sendHello();
        System.out.println("第二次执行");
    }

    static class Student{
        private String username;
        private String password;

        public Student(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    public static void sendHello(){
        System.out.println("hello Github  ^。^!");
    }
}
