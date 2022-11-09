package com.example.listener.base;

/**
 * @description:事件源(被观察者)
 * @Author: kuangjie
 * @Date: 2022/10/9 16:03
 */

public class Person {
    private  PersonListener personListener;
    public  void registerPersonListener(PersonListener personListener) {
        this.personListener=personListener;
    }
    public void run() {
        if (personListener!=null){
            Event event = new Event(this);
            this.personListener.dorun(event);
        }
        System.out.println("开始跑");
    }

    public void eat() {
        if (personListener!=null){
            Event event = new Event(this);
            this.personListener.doeat(event);
        }
        System.out.println("开始吃");
    }

}
