package com.example.java8lambdademo;

import com.example.listener.base.Event;
import com.example.listener.base.Person;
import com.example.listener.base.PersonListener;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/10/9 16:28
 */
public class Testlistener {
    public static void main(String[] args) {
        Person person =new Person();
        person.registerPersonListener(new MyPersonListener());
        person.run();
        person.eat();
    }
}
/**
  * @description:监听器（观察者）：实现了监听器接口的实现类。要做的事在接口方法中实现
  * @Author: kuangjie
  * @Date : 2022/10/10 10:14
   */
class MyPersonListener implements PersonListener {
    @Override
    public void dorun(Event event) {
        Person person= event.getPerson();
        System.out.println("跑之前提醒：");
    }

    @Override
    public void doeat(Event event) {
        Person person= event.getPerson();
        System.out.println("吃之前提醒：洗手");
    }
}


