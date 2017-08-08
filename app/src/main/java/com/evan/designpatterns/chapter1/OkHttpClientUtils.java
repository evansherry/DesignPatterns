package com.evan.designpatterns.chapter1;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Evan on 2017/8/3.
 */

public class OkHttpClientUtils {

    public final static OkHttpClientUtils mInstance = new OkHttpClientUtils();
    private final OkHttpClient client;

    public OkHttpClientUtils() {
      client = new OkHttpClient();
    }


    public String getString(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResponseBody getBody(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response;
        try {
            response  = client.newCall(request).execute();
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
