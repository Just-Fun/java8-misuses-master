package com.xpinjection.java8.misused.winterberg.lambda;

import static java.lang.Math.sqrt;

/**
 * @author Benjamin Winterberg
 */
public class Interface1 {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        System.out.println(formula1.calculate(100)); // 100.0
        System.out.println(formula1.sqrt(-23));      // 0.0
        System.out.println(Formula.positive(-4));// 0.0

//        Formula formula = a -> sqrt(a * 100);
//        System.out.println(formula.calculate(100)); // 100.0
//
//        Formula formula2 = (a) -> sqrt( a * 100);
//        System.out.println(formula2.calculate(100)); // 100.0
    }

}