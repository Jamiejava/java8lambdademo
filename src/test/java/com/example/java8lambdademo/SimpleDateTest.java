package com.example.java8lambdademo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @Author: kuangjie
 * @Data: 2020/5/22 11:27
 */
public class SimpleDateTest {
    @JsonProperty("BirthDate")
    private LocalDateTime birthDate;

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public static void main(String[] args) {
        Instant instant= Instant.now();//等于UTC
        System.out.println("instant:"+instant);
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate:" + localDate);
        LocalTime localTime = LocalTime.now();
        //LocalDateTime.now().plusMinutes(TimeUnit.HOURS.toMinutes(-8));  当前时间-8
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime:" + localDateTime);
        ZonedDateTime zonedDateTime =ZonedDateTime.now();
        System.out.println("zonedDateTime:" + zonedDateTime);
//获取时间戳
        Instant instant1 = Instant.now();
        System.out.println("毫秒:"+instant1.toEpochMilli());
        System.out.println("秒:"+instant1.getEpochSecond());
        Instant instant2 = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println("+8毫秒:"+instant2.toEpochMilli());
        System.out.println("+8秒:"+instant2.getEpochSecond());
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("localDateTime1毫秒:" + localDateTime1.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println("localDateTime1秒:" + localDateTime1.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());

//获取当前的年月日时分秒
        //获取当前的时间，包括毫秒
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("当前年:"+ldt.getYear());   //2018
        System.out.println("当前年份天数:"+ldt.getDayOfYear());//172
        System.out.println("当前月:"+ldt.getMonthValue());
        System.out.println("当前时:"+ldt.getHour());
        System.out.println("当前分:"+ldt.getMinute());
        System.out.println("当前时间:" + ldt.toString());
//      格式化时间
        System.out.println("格式化时间：" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
//时间增减
        System.out.println("后5天时间:"+ldt.plusDays(5));
        System.out.println("前5天时间并格式化:"+ldt.minusDays(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))); //2018-06-16
        System.out.println("前一个月的时间:"+ldt.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMM"))); //2018-06-16
        System.out.println("后一个月的时间:"+ldt.plusMonths(1)); //2018-06-16
        System.out.println("指定2099年的当前时间:"+ldt.withYear(2099));
//        创建指定时间
        LocalDateTime ldtnew = LocalDateTime.of(2020, 8, 14, 19, 59, 59);
        System.out.println(" 创建指定时间:"+ldtnew);
//        时间相差比较
        LocalDate ld=LocalDate.parse("2017-11-17");
        LocalDate ld2=LocalDate.parse("2018-01-05");
        Period p= Period.between(ld, ld2);
        System.out.println("相差年: "+p.getYears()+" 相差月 :"+p.getMonths() +" 相差天:"+p.getDays());
        System.out.println("相差月份:"+ ChronoUnit.MONTHS.between(ld, ld2));
        System.out.println("两月之间的相差的天数   : " + ChronoUnit.DAYS.between(ld, ld2));
        Instant inst1 = Instant.now();
        System.out.println("当前时间戳 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("增加之后的时间 : " + inst2);
        System.out.println("相差毫秒 : " + Duration.between(inst1, inst2).toMillis());
        System.out.println("相毫秒 : " + Duration.between(inst1, inst2).getSeconds());

        LocalDateTime ldt4 = LocalDateTime.now();
        LocalDateTime ldt5 = ldt4.plusMinutes(10);
        System.out.println("当前时间是否大于:"+ldt4.isAfter(ldt5));
        System.out.println("当前时间是否小于" + ldt4.isBefore(ldt5));
//        时区时间计算



        Clock clock = Clock.systemUTC();
        System.out.println("当前时间搓：" + clock.millis());
        Clock clock3 = Clock.system(ZoneId.of("America/New_York")); //非当前系统时区计算慢
        System.out.println("美国纽约此时的时间戳:"+clock3.millis());
        Clock clock1 = Clock.system(ZoneId.of("Asia/Shanghai"));
        System.out.println("亚洲上海此时的时间戳:"+clock1.millis());

        ZoneId zoneId= ZoneId.of("America/New_York");
        ZonedDateTime dateTime=ZonedDateTime.now(zoneId);
        System.out.println("美国纽约此时的时间 : " + dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        System.out.println("美国纽约此时的时间 和时区: " + dateTime);
    }
}
