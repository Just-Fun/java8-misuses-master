package com.xpinjection.java8.misused.practice;

/**
 * Created by Sergey on 5/23/17.
 */
public class Main {
    public static void main(String[] args) {
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
//        Converter<String, Integer> converter = (from) -> Integer.parseInt(from);
//        Converter<String, Integer> converter = Integer::parseInt;
        ConverterStrToInt converterStrToInt = new ConverterStrToInt();
        Integer converted = converterStrToInt.convert("123");
        System.out.println(converted);    // 123
    }
}
