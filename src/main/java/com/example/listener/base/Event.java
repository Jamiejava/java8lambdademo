package com.example.listener.base;

/**
 * @description:事件(通知)
 * @Author: kuangjie
 * @Date: 2022/10/9 17:23
 */
public class Event {
    private  Person person;
    public  Event(Person person) {
        super();
        this.person = person;
    }

    public Event() {
        super();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
