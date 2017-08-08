package com.evan.designpatterns.chapter2;

import java.io.ObjectStreamException;

/**
 * Created by Evan on 2017/8/4.
 */

public class Singleton1 {

    private volatile static Singleton1 mInstance;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (mInstance == null) {
            synchronized (Singleton1.class) {
                if (mInstance == null) {
                    mInstance = new Singleton1();
                }
            }
        }

        System.out.println("Singleton1:"+mInstance.toString());
        return mInstance;
    }

    /**
     * 如果反序列化需要实现下面方法
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return mInstance;
    }
}
