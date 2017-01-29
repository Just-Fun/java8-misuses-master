package com.xpinjection.java8.misused.optional;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.Optional;

public class StrictCheckOfValuePresence {
    public static void main(String[] args) {
        User userNull = null;
//        Optional<User> userNull1 = Optional.of(userNull);// NullPointerException
//        System.out.println(userNull1);
        Optional<User> userNull2 = Optional.ofNullable(userNull);
        System.out.println(userNull2);
        StrictCheckOfValuePresence presence = new StrictCheckOfValuePresence();
    }

    @Ugly
    class ManualCheckForPresenceToThrowException {
        public String getUserName(Long userId) {
            Optional<User> user = findById(userId);
            if (user.isPresent()) {
                return user.get().getName();
            }
            throw new IllegalStateException("User not found");
        }
    }

    @Good
    class OrElseThrowUsage {
        public String getUserName(Long userId) {
            return findById(userId)
                    .orElseThrow(() -> new IllegalStateException("User not found")) //@throws X if there is no value present
                    .getName();
        }
    }

    private Optional<User> findById(Long userId) {
        //search in DB
        return Optional.of(new User(5L, "Mikalai"));
    }
}
