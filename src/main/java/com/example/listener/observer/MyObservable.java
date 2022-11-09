package com.example.listener.observer;

import java.util.Observable;

/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/10/10 14:45
 */
public class MyObservable  extends Observable {
    void counter(int period) {
        for (;period >= 0;period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Sleep interrupeted");
            }
        }
    }
}
