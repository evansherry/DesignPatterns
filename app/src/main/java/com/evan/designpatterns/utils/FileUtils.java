package com.evan.designpatterns.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by Evan on 2017/8/4.
 */

public class FileUtils {

    public static String IMAGE_PATH = "DesignPatterns/imageCache";

    public static File createFile(String path){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File file = new File(Environment.getExternalStorageDirectory()+getPath(), path);
            return file;
        }
        return null;
    }

    public static File createFileDir() {
        File file = null;
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            file = new File(Environment.getExternalStorageDirectory(),
                    IMAGE_PATH);
        }

        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String getPath(){
        return File.separator+IMAGE_PATH;
    }

}
