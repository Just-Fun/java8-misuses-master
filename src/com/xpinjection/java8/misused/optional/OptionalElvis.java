package com.xpinjection.java8.misused.optional;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.Optional;

import static java.util.Optional.ofNullable;

public class OptionalElvis {

    public static void main(String[] args) {
        User user = new User(1, "Vasia");
        User userNull = null;

        OptionalElvis elvis  = new OptionalElvis();
        UsingOptionalIsPresent uop = elvis.new UsingOptionalIsPresent();
        String name1 = uop.getUserName(user);
        System.out.println(name1);

        String name2 = uop.getUserName(userNull);
        System.out.println(name2);

        Optional<User> user21 = ofNullable(userNull);
        System.out.println(user21);

        UsingOrElse uoe = elvis.new UsingOrElse();
        String userName = uoe.getUserName(user);
        System.out.println(userName);

        String userNameNull = uoe.getUserName(userNull);
        System.out.println(userNameNull);

        String name = ofNullable(userNull).map(User::getName).orElse("default Value");
    }
    @Ugly
    class BeforeJava8 {
        public String getUserName(User user) {
            return (user != null && user.getName() != null) ? user.getName() : "default";
        }
    }

    @Ugly
    class UsingOptionalIsPresent {
        public String getUserName(User user) {
            if (ofNullable(user).isPresent()) {
                if (ofNullable(user.getName()).isPresent()) {
                    return user.getName();
                }
            }
            return "default";
        }
    }

    @Good
    class UsingOrElse {
        public String getUserName(User user) {
            return ofNullable(user)
                    .map(User::getName)
                    .orElse("default");
        }
    }
}
