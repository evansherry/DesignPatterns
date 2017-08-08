package com.evan.designpatterns.chapter1;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by Evan on 2017/8/3.
 */

public class MemoryCache implements ImageCache{

    private LruCache<String, Bitmap> mImageCache;

    public MemoryCache() {
        initImageCache();
    }

    private void initImageCache() {
        int maxMemory = (int)( Runtime.getRuntime().maxMemory() / 1024);
        int cacheMemory = maxMemory / 4; // 取运行时最大内存的1/4作为缓存
        // maxsize 表示整个缓存空间的大小  size of 表示每个缓存条目的大小
        mImageCache = new LruCache<String, Bitmap>(cacheMemory){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() /1024;
            }
        };
    }

    @Override
    public void put(String url,Bitmap bitmap){
        mImageCache.put(url,bitmap);
    }

    @Override
    public Bitmap get(String url){
       return mImageCache.get(url);
    }
}
