package com.example.java8lambdademo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SpringBootTest
class Java8lambdademoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test11() {
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean foo0 = predicate.test("foo");
        boolean foo1 = predicate.negate().test("foo");
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println(foo0);
        System.out.println(foo1);

        System.out.println( nonNull.test(true));

        System.out.println(isNull.test(true));

        System.out.println( isEmpty.test("tt"));
        System.out.println(isNotEmpty.test("notString"));
    }
    @Test
    public void test12() {
        Function<String, Integer> toIngeger = Integer::valueOf; //转Integer
        Function<String, String> backToString = toIngeger.andThen(String::valueOf); //转String
        Function<String, String> afterToStartsWith = backToString.andThen(new Something()::startsWith); //截取第一位
        Function<String, Integer> toInteger = afterToStartsWith.andThen(Integer::valueOf);
        Integer apply = toInteger.apply("123");
        System.out.println(apply);
    }
    @Test
    public void test13() {
        Supplier<Person8> person8Supplier0 = Person8::new;
        person8Supplier0.get();
        Supplier<String> stringSupplier1= Something::test01;
        stringSupplier1.get();
        Supplier<String> stringSupplier2= new Something()::test02;
        stringSupplier2.get();
    }
    @Test
    public void test14() {
        Consumer<Person8> greeter01 =new Consumer<Person8>() {
            @Override
            public void accept(Person8 person) {
                System.out.println("Hello,"+person.firstName);
            }
        };
        Consumer<Person8> greeter02 = person8 -> System.out.println("hello," + person8.firstName);
        Person8 person8=  new Person8("Luke","Skywalker");
        greeter01.accept(person8);
        greeter02.accept(person8);
        Consumer<Person8> greeter03 =new MyConsumer<Person8>()::accept;
        greeter03.accept(person8);
    }
    @Test
    public void test15() {
        Comparator<Person8> comparator01 = (p1, p2) -> p1.firstName.compareToIgnoreCase(p2.firstName);
        Comparator<Person8> comparator02 = Comparator.comparing(p -> p.firstName); //等同于上面的方式
        Person8 p1= new Person8("j","Doe");
        Person8 p2 = new Person8("J", "Wonderland");
        System.out.println( comparator01.compare(p1, p2));
        System.out.println(comparator02.reversed().compare(p1, p2));
    }
    @Test
    public void test16() {
        String b="bam";
        //of（）：为非null的值创建一个Optional
        Optional<String> optional =Optional.ofNullable(b); //Optional.of(b);
        // isPresent（）： 如果值存在返回true，否则返回false
        System.out.println( optional.isPresent()); //true

        //orElse（）：如果有值则将其返回，否则返回指定的其它值
        System.out.println( optional.orElse("fallback")); //"bam"
        //ifPresent（）：如果Optional实例有值则为其调用consumer，否则不做处理
        optional.ifPresent(s -> System.out.println(s.charAt(0))); //"b"
        //get()：如果Optional有值则将其返回，否则抛出NoSuchElementException
        System.out.println( optional.get()); //"bam"
        Optional<Person8> optionalPerson8 = Optional.of(new Person8());
        optionalPerson8.ifPresent(s-> System.out.println(s.firstName));

        Person8 person8=  new Person8("Luke","Skywalker");
        Optional<Person8> opt= Optional.ofNullable(person8);

    }

    public  void  test18(){
        String b="bam";
        System.out.println("dd");

    }

    @Test
    public void test17() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");


    }
}
