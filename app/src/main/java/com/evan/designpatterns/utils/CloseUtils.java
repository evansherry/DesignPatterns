package com.evan.designpatterns.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Evan on 2017/8/4.
 */

public class CloseUtils {

    public static void closeQuietly(Closeable  closeable){
        if(closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
