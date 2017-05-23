package com.xpinjection.java8.misused.practice;

/**
 * Created by Sergey on 5/23/17.
 */
public class ConverterStrToInt<F, T> implements Converter<F, T> {
    @Override
    public T convert(F from) {
//        Converter<String, Integer> converter = (param) -> Integer.valueOf(param);
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        return (T) converted;

    }
}
