package com.example.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/9/26 15:54
 */
@Component
public class EventPublisher  {
    @Autowired
    private ApplicationContext applicationContext;
    public  void publish(Object o) {
        applicationContext.publishEvent(new OrderEvent(this,o));
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
