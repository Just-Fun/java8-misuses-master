package com.xpinjection.java8.misused.lambda.collections;

import com.xpinjection.java8.misused.Permission;
import com.xpinjection.java8.misused.Role;
import com.xpinjection.java8.misused.User;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Serzh on 2/19/17.
 */
public class Helper {

    public static User setUser() {
        User user = new User(11, "Banderas");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName("edit11");

        EnumSet<Permission> permissions = EnumSet.of(Permission.SEARCH);
        permissions.add(Permission.EDIT);
//        EnumSet<Permission> permissions = EnumSet.of(Permission.EDIT);
//        permissions.add(Permission.ADD);
        role.setPermissions(permissions);
        roles.add(role);

        user.setRoles(roles);
        return user;
    }

    public static Set<User> setUsers() {
        Set<User> users = new HashSet<>();
        User user = new User(1, "Banderas3");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName("edit1");

        EnumSet<Permission> permissions = EnumSet.of(Permission.SEARCH);
        permissions.add(Permission.EDIT);
//        EnumSet<Permission> permissions = EnumSet.of(Permission.EDIT);
//        permissions.add(Permission.ADD);
        role.setPermissions(permissions);
        roles.add(role);

        user.setRoles(roles);

        User user2 = new User(2, "Banderas");

        Set<Role> roles2 = new HashSet<>();
        Role role2 = new Role();
        role2.setName("edit2");

        EnumSet<Permission> permissions2 = EnumSet.of(Permission.SEARCH);
        role2.setPermissions(permissions2);
        roles2.add(role2);

        user2.setRoles(roles2);

        users.add(user2);
        users.add(user);
        users.add(setUser());
        return users;
    }

}
