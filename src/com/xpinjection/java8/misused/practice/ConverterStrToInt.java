package com.xpinjection.java8.misused.practice;

/**
 * Created by Sergey on 5/23/17.
 */
public class ConverterStrToInt implements Converter<String, Integer> {
    @Override
    public Integer convert(String from) {
//        Converter<String, Integer> converter = (param) -> Integer.parseInt(param);
//        Converter<String, Integer> converter = Integer::parseInt;
//        return converter.convert(from);
        return Integer.parseInt(from);

    }
}
