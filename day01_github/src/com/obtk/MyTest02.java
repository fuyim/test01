package com.obtk;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 通过反射机制来获取对象
 */
public class MyTest02 {
    public static void main(String[] args) {
        //获取类的三种方式

        try {
            //1.
            Class<?> user = Class.forName("com.obtk.User");
            System.out.println(user);
            //2.
            Class<User> u = User.class;
            System.out.println(u == user);
            //3.
            String s = "";
            Class<? extends String> s2 = s.getClass();
            System.out.println(s2);
            test2();
            test3();
            test4();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void test2() throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("classPath.properties").getPath();
        Properties pro = new Properties();
        FileReader reader = new FileReader(path);
        pro.load(reader);
        String className = pro.getProperty("ClassName");
        try {
            Class<?> aClass = Class.forName(className);
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void test3() throws IOException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("classPath.properties");
        Properties pro = new Properties();
        pro.load(in);
        String className = pro.getProperty("ClassName");
        try {
            Class<?> bClass = Class.forName(className);
            System.out.println(bClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void test4() throws ClassNotFoundException {
        ResourceBundle bundle =  ResourceBundle.getBundle("classPath");
        String className = bundle.getString("ClassName");
        Class<?> cClass = Class.forName(className);
        System.out.println(cClass);
    }

}
