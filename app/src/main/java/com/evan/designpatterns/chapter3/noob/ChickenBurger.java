package com.evan.designpatterns.chapter3.noob;

/**
 * Created by Evan on 2017/8/15.
 */

public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.f;
    }
}
