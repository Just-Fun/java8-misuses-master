package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.Permission;
import com.xpinjection.java8.misused.User;
import com.xpinjection.java8.misused.lambda.collections.Helper;

import java.util.*;

import static java.util.stream.Collectors.*;

public class ExternalCollectionForGrouping {
    private static /*final*/ Set<User> users = new HashSet<>();

    public static void main(String[] args) {
        users = Helper.setUsers();
        System.out.println(users.size());
//        ExternalStateIsUsedForStreamOperations operations = new ExternalStateIsUsedForStreamOperations();
        TuplesAreUsedWhenStateIsNeededOnLaterPhase operations = new TuplesAreUsedWhenStateIsNeededOnLaterPhase();

        Map<String, Set<User>> editors = operations.findEditors();
        System.out.println(editors.size());
        for (Map.Entry<String, Set<User>> entry : editors.entrySet()) {
            System.out.println("entry.getKey()" + entry.getKey());
            Set<User> users = entry.getValue();
            System.out.println(Collections.singletonList(users));
        }
        System.out.println("--------------------------");

//        Map<String, Boolean> whoLetDogsOut = new ConcurrentHashMap<>();
        Map<String, Boolean> whoLetDogsOut = new HashMap<>();
        whoLetDogsOut.put("snoop", null);
        System.out.println(whoLetDogsOut.size());
        System.out.println(whoLetDogsOut + "\n");

        whoLetDogsOut.computeIfAbsent("snoop", k -> f(k));
        System.out.println(whoLetDogsOut.size());
        System.out.println(whoLetDogsOut + "\n");

        whoLetDogsOut.computeIfAbsent("snoop", k -> f(k));
        System.out.println(whoLetDogsOut.size());
        System.out.println(whoLetDogsOut + "\n");

        whoLetDogsOut = new HashMap<>();

        whoLetDogsOut.computeIfAbsent("snoop", k -> f(k));
        System.out.println(whoLetDogsOut.size());
        System.out.println(whoLetDogsOut + "\n");
    }

    static boolean f(String s) {
        System.out.println("creating a value for \"" + s + '"');
        return s.isEmpty();
    }

    @Ugly
    static class ExternalStateIsUsedForStreamOperations {
        public Map<String, Set<User>> findEditors() {
            Map<String, Set<User>> editors = new HashMap<>();
            users.forEach(u -> u.getRoles().stream()
                    .filter(r -> r.getPermissions().contains(Permission.EDIT))
                    .forEach(r -> {
                        //is it better to use Multiset and avoid this complex code
                        /*Set<User> usersInRole = editors.get(r.getName());
                        if (usersInRole == null) {
                            usersInRole = new HashSet<>();
                            editors.put(r.getName(), usersInRole);
                        }
                        usersInRole.add(u);*/
                        Set<User> usersInRole = editors.computeIfAbsent(r.getName(), k -> new HashSet<>());
                        usersInRole.add(u);
                    })
            );
            return editors;
        }
    }

    @Good
    static class TuplesAreUsedWhenStateIsNeededOnLaterPhase {
        public Map<String, Set<User>> findEditors() {
            return users.stream()
                    .flatMap(u -> u.getRoles().stream()
                            .filter(r -> r.getPermissions().contains(Permission.EDIT))
                            .map(r -> new Pair<>(r, u))
                    ).collect(groupingBy(p -> p.getKey().getName(),
                            mapping(Pair::getValue, toSet())));
        }
    }

    //any tuple implementation from 3rd party libraries
    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
            System.out.println("key: " + key + ", value: " + value);
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
