package com.evan.designpatterns.chapter2;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by Evan on 2017/8/4.
 */

public class Singleton2 implements Serializable{

    private Singleton2() {
    }

    public static Singleton2 getmInstance(){

        System.out.println("Singleton2:"+SingletonHolder.mInstance.toString());
        return SingletonHolder.mInstance;
    }

    public static class SingletonHolder{
        private static Singleton2 mInstance = new Singleton2();
    }

    private Object readResolve() throws ObjectStreamException{
        return getmInstance();
    }

}
