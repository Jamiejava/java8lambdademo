package com.example.java8lambdademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SpringBootApplication
public class Java8lambdademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Java8lambdademoApplication.class, args);
        Predicate<Integer> predicate = x -> x > 185;
        Student student =new Student("9龙",23,175);
        System.out.println("高于185吗？"+predicate.test(student.getStature()));

        Consumer<String> consumer = System.out::println;
        consumer.accept("命运由我不由天");



        Function<Student,String> function =Student::getName;
        String name = function.apply(student);
        consumer.accept(name);

        Supplier<Integer> supplier=()->Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());

    }

}
