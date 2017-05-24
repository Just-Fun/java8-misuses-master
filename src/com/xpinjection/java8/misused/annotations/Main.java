package com.xpinjection.java8.misused.annotations;

/**
 * Created by Sergey on 5/24/17.
 */
public class Main {
    public static void main(String[] args) {
//        Hint hint = Person.class.getAnnotation(Hint.class);
//        System.out.println(hint);                   // null
//
//        Hints hints1 = Person.class.getAnnotation(Hints.class);
//        System.out.println(hints1.value().length);  // null

        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);          // 0
    }
}
