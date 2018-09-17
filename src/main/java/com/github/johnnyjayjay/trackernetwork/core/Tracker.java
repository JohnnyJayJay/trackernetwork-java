package com.github.johnnyjayjay.trackernetwork.core;

import okhttp3.*;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

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

    protected void request(String endpoint, Callback callback) {
        Request request = new Request.Builder().header("TRN-Api-Key", apiKey).get().url(endpoint).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

    protected <T> T execute(String endpoint, Function<ResponseBody, T> function, Consumer<Exception> failure) {
        Request request = new Request.Builder().header("TRN-Api-Key", apiKey).get().url(endpoint).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            // TODO: 17.09.2018  
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
