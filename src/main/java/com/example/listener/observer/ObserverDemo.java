package com.example.listener.observer;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/10/10 14:52
 */
public class ObserverDemo {
    public static void main(String[] args) {
        MyObservable myObservable = new MyObservable();
        Watcher watcher = new Watcher();
        myObservable.addObserver(watcher);
        myObservable.counter(10);
    }
}
