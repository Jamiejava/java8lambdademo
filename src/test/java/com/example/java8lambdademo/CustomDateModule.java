package com.example.java8lambdademo;

import com.fasterxml.jackson.databind.module.SimpleModule;

import java.time.LocalDateTime;

/**
 * @description:
 * @Author: kuangjie
 * @Data: 2020/5/22 13:36
 */
public class CustomDateModule extends SimpleModule {
    public CustomDateModule() {
        addDeserializer(LocalDateTime.class, new CustomDateDeserializer());
    }
}
