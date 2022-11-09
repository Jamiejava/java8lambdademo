package com.example.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/9/26 15:50
 */
public class OrderEvent extends ApplicationEvent {

    private  Object object;
    public OrderEvent(Object source,Object t) {
        super(source);
        this.object=t;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
