package com.example.listener.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/10/10 11:41
 */
public class Watcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update() called,count is "+((Integer)arg).intValue());
    }
}
