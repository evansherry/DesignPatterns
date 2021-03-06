package com.evan.designpatterns;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Evan on 2017/7/3.
 */

public class App extends Application {
    public static App mRef;

    public static App getInstance() {
        return mRef;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mRef = this;
        Stetho.initializeWithDefaults(this);

    }
}
