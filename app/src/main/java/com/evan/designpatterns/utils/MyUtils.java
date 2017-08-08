package com.evan.designpatterns.utils;

import java.util.StringTokenizer;

/**
 * Created by Evan on 2017/8/4.
 */

public class MyUtils {
    public static String getSpeart(String path){

        String name = null;
        StringTokenizer strToken = new StringTokenizer(path,"/");
        while (strToken.hasMoreTokens()){
            name = strToken.nextToken();
        }

        return name;
    }

}
