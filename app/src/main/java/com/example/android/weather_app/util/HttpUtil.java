package com.example.android.weather_app.util;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by kevinsun on 11/2/17.
 */

public class HttpUtil {

    public static void sendHttpRequest(String url, Callback callback){

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(callback);

    }
}
