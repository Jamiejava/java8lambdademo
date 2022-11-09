package com.example.java8lambdademo;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2021/11/19 17:34
 */
public class FinalExample {
    private int i;
    private  int j;
    static FinalExample obj;

    public  void FinalExample(){
        i =1;
        j=2;
    }
    public static  void writer(){
        obj =new FinalExample();
    }
    public static  void reader(){
        FinalExample object = obj;
        int a = object.i;
        int b =object.j;
    }
}
