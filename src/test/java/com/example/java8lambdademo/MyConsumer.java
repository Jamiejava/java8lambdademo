package com.example.java8lambdademo;

import java.util.function.Consumer;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2020/10/10 14:53
 */
public class MyConsumer<T extends Person8> implements Consumer<T> {




    @Override
    public void accept(Person8 t) {

            System.out.println("Hello, My is " +t.firstName);
    }
}
