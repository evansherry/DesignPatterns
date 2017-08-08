package com.evan.designpatterns.chapter1;

import android.graphics.Bitmap;

/**
 * Created by Evan on 2017/8/4.
 */

public class DoubleCache implements ImageCache{

    private DiskCache diskCache;
    private MemoryCache memoryCache;

    public DoubleCache() {
        diskCache = new DiskCache();
        memoryCache = new MemoryCache();
    }

    /**
     * 双重缓存机制
     * @param url
     * @param bitmap
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url,bitmap);
        diskCache.put(url,bitmap);
    }

    /**
     * 先从内存获取，内存没有再从本地获取
     * @param url
     * @return
     */
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if(bitmap == null){
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }
}
