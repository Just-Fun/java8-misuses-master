package com.xpinjection.java8.misused.practice;

import java.util.function.Function;

/**
 * Created by Sergey on 5/23/17.
 */
public class FunctionInterfaceDemo {

    public static void main(String[] args) {

//        Function<String, Integer> length = str -> str.length();
        Function<String, Integer> length = String::length;

        System.out.println("Length of string 'Hello World' is " + length.apply("Hello World"));

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123"));

    }

}