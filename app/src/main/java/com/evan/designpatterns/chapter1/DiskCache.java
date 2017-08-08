package com.evan.designpatterns.chapter1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.evan.designpatterns.utils.CloseUtils;
import com.evan.designpatterns.utils.FileUtils;
import com.evan.designpatterns.utils.MyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;

/**
 Created by Evan on 2017/8/4.
*/

public class DiskCache implements ImageCache {


    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(FileUtils.createFile(MyUtils.getSpeart(url)));

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            CloseUtils.closeQuietly(outputStream);
        }
    }

    @Override
    public Bitmap get(final String url) {
        File file = FileUtils.createFileDir();
        String[] names = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.equals(MyUtils.getSpeart(url));
            }
        });
       if(names != null && names.length > 0){
          return BitmapFactory.decodeFile(file.getPath()+File.separator+names[0]);
       }
      return null;

    }

}
