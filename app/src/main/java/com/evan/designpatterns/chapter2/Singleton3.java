package com.evan.designpatterns.chapter2;

/**
 * Created by Evan on 2017/8/7.
 */

public enum Singleton3 {

    INSTANCE;

    public void dosomething(){
        System.out.println("Singleton3:"+INSTANCE.hashCode());
    }

}
