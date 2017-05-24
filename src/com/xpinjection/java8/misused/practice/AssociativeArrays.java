package com.xpinjection.java8.misused.practice;

import java.util.HashMap;
import java.util.Map;

public class AssociativeArrays {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(0, "some");
        map.put(1, null);

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((key, val) -> System.out.println(key + " : " + val));
        System.out.println();

        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3)); // val33

        map.computeIfPresent(9, (num, val) -> null);
        System.out.println(map.containsKey(9)); // false

        map.computeIfAbsent(23, num -> "val" + num);
        System.out.println(map.containsKey(23)); // true

        map.computeIfAbsent(3, num -> "bam");
        System.out.println(map.get(3)); // val33

        System.out.println();

        map.forEach((key, val) -> System.out.println(key + " : " + val));

//        удалить объект по ключу, только если этот объект ассоциирован с ключом:

        map.remove(3, "val3");
        map.get(3);             // val33

        map.remove(3, "val33");
        map.get(3);             // null

        System.out.println(map.getOrDefault(42, "not found"));   // not found)

//        Объединить записи двух массивов:
        System.out.println(map.get(9)); // null

//        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        map.merge(9, "val9", String::concat);
        System.out.println(map.get(9)); // val9

//        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        map.merge(9, "concat", String::concat);
        System.out.println(map.get(9)); // val9concat

    }
}
