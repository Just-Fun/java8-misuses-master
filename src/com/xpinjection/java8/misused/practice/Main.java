package com.xpinjection.java8.misused.practice;

/**
 * Created by Sergey on 5/23/17.
 */
public class Main {
    public static void main(String[] args) {
        Converter<String, Integer> converter = new ConverterStrToInt<>();
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }
}
