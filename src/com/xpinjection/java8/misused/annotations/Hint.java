package com.xpinjection.java8.misused.annotations;

import java.lang.annotation.Repeatable;

@Repeatable(Hints.class)
@interface Hint {
    String value();
}
