package com.xpinjection.java8.misused.winterberg.nashorn;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Working with java types from javascript.
 *
 * @author Benjamin Winterberg
 */
public class Nashorn3 {

    public static void main(String[] args) throws Exception {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("load('res/nashorn3.js')");
    }

}