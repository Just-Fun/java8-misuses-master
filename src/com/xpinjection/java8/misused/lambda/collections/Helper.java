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
        User user = new User(1, "Banderas");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName("edit");

        EnumSet<Permission> permissions = EnumSet.of(Permission.SEARCH);
        permissions.add(Permission.EDIT);
//        EnumSet<Permission> permissions = EnumSet.of(Permission.EDIT);
//        permissions.add(Permission.ADD);
        role.setPermissions(permissions);
        roles.add(role);

        user.setRoles(roles);
        return user;
    }

}
