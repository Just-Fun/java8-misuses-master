package com.xpinjection.java8.misused.practice;

/**
 * Created by Sergey on 5/23/17.
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}