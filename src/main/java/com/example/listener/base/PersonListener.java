package com.example.listener.base;

/**
 * @description:监听器(观察者) 接口
 * @Author: kuangjie
 * @Date: 2022/10/9 17:22
 */
public interface PersonListener {
    public void dorun(Event event);

    public void doeat(Event event);
}
