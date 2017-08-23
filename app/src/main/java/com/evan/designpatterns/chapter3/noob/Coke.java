package com.evan.designpatterns.chapter3.noob;

/**
 * Created by Evan on 2017/8/15.
 */

public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "coke";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
