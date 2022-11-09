/*
package com.example.listener.observer.Thread;

import java.util.Iterator;
import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

*/
/**
 * @description:
 * @Author: kuangjie
 * @Date: 2022/10/10 15:37
 *//*

public class FlyLoggerThread<T extends > extends Observable implements  Runnable {

    private Queue<T> tasks;
    private Object object;
    private Boolean isLocked;
    private int times = 0;
    public void doBusiness() {
        if (true) {
            super.setChanged();
        }
        notifyObservers();
    }
    public  FlyLoggerThread(){
        super();
        object = 1;
        isLocked = false;
    }
    @Override
    public void run() {
        try {
            while (true) {
                if (tasks.size() > 0) {
                    Iterator iterater = tasks.iterator();
                    while (iterater.hasNext()) {
                        T t = (T) iterater.next();

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
*/
