package com.example.java8lambdademo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.joda.time.DateTime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @description:
 * @Author: kuangjie
 * @Data: 2020/5/20 16:21
 */
public class Person {
    public String Name;
    public int Age ;
    public DateTime LastLoginTime;

    public static void main(String[] args) {
        Person p = new Person();
        p.Name = "张三";
        p.Age = 28;
        p.LastLoginTime = DateTime.now();
      //  String jsonString = JsonHelper.JsonSerializer<Person>(p);



     String json = "{ \"BirthDate\": \"\\/Date(1590139038)\\/\" }";
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
// add my custom module
        mapper.registerModule(new CustomDateModule());

        SimpleDateTest value = null;
        try {
            value = mapper.readValue(json, SimpleDateTest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(value.getBirthDate()); // 1988-09-26T21:00
        LocalDateTime birthDate = value.getBirthDate();
      /*  ZonedDateTime z=ZonedDateTime.now();


        System.out.println(z.getOffset());
// you must know in what zone you are to convert it to epoch milli (using default as an example)
        Instant instant =  z.toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant();
        String msFormat = "/Date(" + instant.toEpochMilli() +"-"+"时区"+ ")/";
        System.out.println(msFormat); // /Date(591321600000)/
        System.out.println(ZoneId.systemDefault().getId());
        System.out.println(ZoneId.of(ZoneId.systemDefault().getId()));
        System.out.println(ZoneId.getAvailableZoneIds());

        System.out.println( DateTime.now());*/
        ZonedDateTime z=ZonedDateTime.now();
        //LocalDateTime birthDate= LocalDateTime.now();
        Instant instant =  birthDate.atZone(ZoneId.systemDefault()).toInstant();

        String msFormat = "/Date(" + instant.toEpochMilli() +z.getOffset()+ ")/";
        String newFormat = "/Date(" + z.toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() +z.getOffset()+ ")/";
        System.out.println(msFormat);
        System.out.println(newFormat +  z.toLocalDateTime().toEpochSecond(z.getOffset()));
    }

}
