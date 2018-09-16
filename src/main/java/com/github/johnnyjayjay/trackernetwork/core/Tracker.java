package com.github.johnnyjayjay.trackernetwork.core;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public abstract class Tracker {

    private final String apiKey;
    private final OkHttpClient okHttpClient;

    protected Tracker(String apiKey, OkHttpClient okHttpClient) {
        this.apiKey = apiKey;
        this.okHttpClient = okHttpClient;
    }

    protected void request(String url, Callback callback) {
        Request request = new Request.Builder().header("TRN-Api-Key", apiKey).get().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

}
