package com.xpinjection.java8.misused.puzzlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sergii.zagryvyi on 27.06.2017
 */
public class ListTest {

    public static final String CHUCK = "Chuck";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Arnie", CHUCK, "Slay"));

      /*  list.stream().forEach(s -> { // NullPointerException
            if (s.equals(CHUCK)) {
                list.remove(s);
            }
        });

        list.forEach(s -> { // ConcurrentModificationException
            if (s.equals(CHUCK)) {
                list.remove(s);
            }
        });*/

        list.removeIf(s -> s.equals(CHUCK));
//        or
        list.removeIf(CHUCK::equals);

        System.out.println(list);
    }
}
