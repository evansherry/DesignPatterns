package com.evan.designpatterns.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.evan.designpatterns.R;
import com.evan.designpatterns.chapter2.Singleton1;
import com.evan.designpatterns.chapter2.Singleton2;
import com.evan.designpatterns.chapter2.Singleton3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void chapter1(View view){
        startActivity(new Intent(this, Chapter1Activity.class));
    }

    public void chapter2(View view){
        /**
         * 三种单例模式的创建
         */
        for (int i = 0; i < 2; i++) {
            Singleton1 instance1 = Singleton1.getInstance();
            Singleton2 instance2 = Singleton2.getmInstance();
            Singleton3.INSTANCE.dosomething();
        }

    }



}
