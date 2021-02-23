package com.obtk;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

public class MyTest03 {


    public static void main(String[] args) throws Exception {
        test1();

    }


    public static void test1() throws IOException, ClassNotFoundException {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("classPath.properties");
        Properties pro = new Properties();
        pro.load(in);
        String className = pro.getProperty("ClassName");
        System.out.println(className);
        //获取属性
        Class<?> userClass = Class.forName(className);
        Field[] fields = userClass.getFields();
        System.out.println(fields.length);
        Field field = fields[0];
        String name = field.getName();
        System.out.println(name);
        Field[] declaredFields = userClass.getDeclaredFields();
        System.out.println(declaredFields.length);
        System.out.println("==========================");
        for (Field declaredField : declaredFields) {
            System.out.println("属性名");
            System.out.println(declaredField.getName());
            System.out.println("数据类型");
            System.out.println(declaredField.getType());
            Class<?> type = declaredField.getType();
            System.out.println(type.getSimpleName());
            System.out.println("修饰符");
            int i = type.getModifiers();
            System.out.println(i);
            String s = Modifier.toString(i);
            System.out.println(s);

        }


    }
}

