package com.example.java8lambdademo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @description:
 * @Author: kuangjie
 * @Data: 2020/5/22 11:33
 */
public class CustomDateDeserializer extends JsonDeserializer<LocalDateTime> {


    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String s = p.getText(); // s is "/Date(591321600000)/"

        // assuming the format is always /Date(number)/
        long millis = Long.parseLong(s.replaceAll("\\/Date\\((\\d+)\\)\\/", "$1"));

        Instant instant = Instant.ofEpochMilli(millis); // 1988-09-27T00:00:00Z

        // instant is in UTC (no timezone assigned to it)
        // to get the local datetime, you must provide a timezone
        // I'm just using system's default, but you must use whatever timezone your system uses
        return instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

}

