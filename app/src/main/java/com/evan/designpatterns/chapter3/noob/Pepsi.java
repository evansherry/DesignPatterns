package com.evan.designpatterns.chapter3.noob;

/**
 * Created by Evan on 2017/8/15.
 */

public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 3.0f;
    }
}
