package com.xpinjection.java8.misused.winterberg.nashorn;

/**
 * @author Benjamin Winterberg
 */
public class SuperRunner implements Runnable {

    @Override
    public void run() {
        System.out.println("super run");
    }

}