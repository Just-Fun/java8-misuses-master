package com.xpinjection.java8.misused.puzzlers.casting;

import java.util.Optional;

/**
 * @author sergii.zagryvyi on 27.06.2017
 */
public class CastToTypeWithoutDeclaringIt {
    public static void main(String[] args) {
        class DogCat implements Dog, Cat { }
        test(new DogCat());
    }

    private static void test(Object obj) {
        Optional.of((Dog & Cat) obj)
                .ifPresent(x -> {
                    x.meow();
                    x.bark();
                });
    }
}

interface Cat {
    default void meow() {
        System.out.println("meow");
    }
}

interface Dog {
    default void bark() {
        System.out.println("woof");
    }
}
