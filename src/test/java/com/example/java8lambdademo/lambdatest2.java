package com.example.java8lambdademo;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/11/2 18:33
 */
public class lambdatest2 {
    @Test
    public  void  lambdaexample2() {
        BinaryOperator<Integer> add =(x, y) -> x+y;
        BinaryOperator<Integer> subtract  =(x,y) -> x-y;
        BinaryOperator<Integer> multiply  =(x,y) -> x*y;
        BinaryOperator<Integer> divide  =(x,y) -> x/y;
        BinaryOperator<Integer> surplus =(x,y) -> x%y;
        System.out.println(add.apply(2,1));
        System.out.println(subtract.apply(3,1));
        System.out.println(multiply.apply(3, 2));
        System.out.println(divide.apply(4, 2));
        System.out.println(surplus.apply(5,2));
    }
}
