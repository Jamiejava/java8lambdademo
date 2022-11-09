package com.example.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/9/26 15:52
 */
@Component
public class OrderEventListenr implements ApplicationListener<OrderEvent> {
    @Async
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
      String s=  orderEvent.getObject().toString();
        System.out.println("执行："+s);
    }
}
