package com.xpinjection.java8.misused.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Sergey on 5/23/17.
 */
public class PredicateInterfaceDemo {

    public static void main(String[] args) {

        int num = -10;
        Predicate<Integer> gt_lt = i -> i > 0;
        boolean result = gt_lt.test(num);
        System.out.println(num + " greater than zero : " + result);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumAll = sumAll(numbers, n -> true);
        int sumAll1 = sumAll(numbers, n -> n % 2 == 0);
        int sumAll2 = sumAll(numbers, n -> n > 3);
        System.out.println(sumAll);
        System.out.println(sumAll1);
        System.out.println(sumAll2);

        System.out.println(filterIntegers(numbers, isAdultMale()));

        System.out.println(filterIntegers(numbers, isAgeMoreThan(1)));

    }

    private static Predicate<Integer> isAdultMale() {
        return p -> p > 3;
    }

    private static Predicate<Integer> isAgeMoreThan(Integer age) {
        return p -> p > age;
    }

    private static List<Integer> filterIntegers(List<Integer> employees, Predicate<Integer> predicate) {
        return employees.stream().filter(predicate).collect(Collectors.toList());
    }

    private static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }
}
