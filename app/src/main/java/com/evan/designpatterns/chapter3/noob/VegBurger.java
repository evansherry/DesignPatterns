package com.evan.designpatterns.chapter3.noob;

/**
 * Created by Evan on 2017/8/15.
 */

public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 35.5f;
    }
}
