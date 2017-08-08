package com.evan.designpatterns.chapter1;

import android.graphics.Bitmap;

/**
 * Created by Evan on 2017/8/4.
 */

public interface ImageCache {
    void put(String url, Bitmap bitmap);
    Bitmap get(String url);
}
