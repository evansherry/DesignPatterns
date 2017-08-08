package com.evan.designpatterns.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created by Evan on 2017/8/4.
 */

public class Base64Utils {
    public static String encode(String data){
        try {
            byte[] encode = Base64.encode(data.getBytes("UTF-8"), 0);
            return new String(encode, Charset.defaultCharset());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String decode(String data){
        byte[] bytes = data.getBytes(Charset.defaultCharset());
        byte[] decode = Base64.decode(bytes, 0);
        return new String(decode,Charset.defaultCharset());
    }




}
