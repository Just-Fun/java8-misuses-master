package com.xpinjection.java8.misused.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Serzh on 2/19/17.
 */
//The method Map.computeIfAbsent(key, Function) computes the new value and associates it with the key
// if there is no mapping for the given key or the mapping is null. Returns the new value associated with the key.
public class ComputeIfAbsentExamle {

    public static void main(String[] args) {
        Map<String, Collection<String>> multimap = new HashMap<>();

        multimap.computeIfAbsent("names", key -> new ArrayList<>()).add("Kajko");
        System.out.println("multimap: " + multimap);

        multimap.computeIfAbsent("names", key -> new ArrayList<>()).add("Kokosz");
        System.out.println("multimap: " + multimap);

        System.out.println("-------------------");
        // updates:
        Map<Integer,String> nameForId = new HashMap<>();
        nameForId.put(1, "Java");
        nameForId.put(2, null);
        System.out.println("Original map: " + nameForId);

        nameForId.computeIfAbsent(1, key -> "Java at " + key);
        System.out.println("No changes: " + nameForId);

        nameForId.computeIfAbsent(2, key -> "Esperanto at " + key);
        System.out.println("Null updated: " + nameForId);

        nameForId.computeIfAbsent(3, key -> "Clojure at "+ key);
        System.out.println("New key: " + nameForId);
    }
}
