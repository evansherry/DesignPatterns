package com.evan.designpatterns.chapter3.noob;

/**
 * Created by Evan on 2017/8/15.
 */

public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
