package com.example.java8lambdademo;

import com.example.listener.EventConfig;
import com.example.listener.EventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/9/26 15:58
 */
public class EventlistenerTest {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(EventConfig.class);
        EventPublisher publisher = new EventPublisher();
        publisher.setApplicationContext(applicationContext);
        publisher.publish("1234567");

       /* Thread parentParent = new Thread(() ->{
                ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        threadLocal.set(1);
        InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set(2);
        new Thread(() -> {
            System.out.println("threadLocal=" + threadLocal.get());
            System.out.println("inheritableThreadLocal=" + inheritableThreadLocal.get());
        }).start();
    }, "父线程");
 parentParent.start();*/
    }
}
