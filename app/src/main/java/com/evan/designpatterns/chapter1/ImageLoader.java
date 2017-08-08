package com.evan.designpatterns.chapter1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.evan.designpatterns.utils.BitmapUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.ResponseBody;

/**
 * Created by Evan on 2017/8/3.
 */

public class ImageLoader {
    public static final ImageLoader imageLoader = new ImageLoader();

    private final ExecutorService mExecutorService;

    private ImageCache imageCache = new MemoryCache();

    public ImageLoader() {
        // 创建线程池，数量为CPU数
        mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void displayImageView(final ImageView iv, final String url) {
        Bitmap bitmap = imageCache.get(url);
        if (bitmap != null) {
            iv.setImageBitmap(bitmap);
            return;
        }
        iv.setTag(url);

        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = downLoadImage(url);
                if (bitmap == null) return;
                if (iv.getTag().equals(url)) {
                    iv.post(new Runnable() {
                        @Override
                        public void run() {
                            iv.setImageBitmap(bitmap);
                        }
                    });
                }
                imageCache.put(url, bitmap);
            }
        });
    }

    /**
     * 必须采用byte再次存储一下，无法直接两次decodeStream
     * @param url
     * @return
     */
    private Bitmap downLoadImage(String url) {
        try {
            ResponseBody body = OkHttpClientUtils.mInstance.getBody(url);
            byte[] bytes = body.bytes();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bytes, 0,bytes.length, options);

            options.inSampleSize = BitmapUtils.calculateInSampleSize(options, 600, 600);
            options.inJustDecodeBounds = false;

            return BitmapFactory.decodeByteArray(bytes,0,bytes.length,options);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

    public void setImageCache(ImageCache imageCache) {
        this.imageCache = imageCache;
    }
}
