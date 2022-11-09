package com.example.java8lambdademo;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2020/10/10 14:08
 */
public class Something {
    public String startsWith(String s) {
        return  String.valueOf(s.charAt(0));
    }

    public  static  String test01() {
        System.out.println("生产了test01");
        return "生产了test01";
    }

    public String test02() {
        System.out.println("生产了test02");
        return "生产了test02";
    }
}

