package com.xpinjection.java8.misused.annotations;

import java.lang.annotation.Repeatable;

@interface Hints {
    Hint[] value();
}

//@Repeatable(Hints.class)
//@interface Hint {
//    String value();
//}
