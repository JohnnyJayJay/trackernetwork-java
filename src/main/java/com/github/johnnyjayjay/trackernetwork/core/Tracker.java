package com.github.johnnyjayjay.trackernetwork.core;

import okhttp3.*;

import java.io.IOException;
import java.util.function.Function;

/**
 * https://www.github.com/JohnnyJayJay
 *
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

    /**
     * @return The body of the request
     * @throws ResponseException if the request failed
     */
    protected String requestSync(String endpoint) {
        Request request = new Request.Builder().header("TRN-Api-Key", apiKey).get().url(endpoint).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw new ResponseException("Synchronous request failed", e);
        }
    }

    /**
     * @return The body of the request
     * @throws ResponseException if the request failed
     */
    protected <T> T requestSync(String endpoint, Function<String, T> function) {
        Request request = new Request.Builder().header("TRN-Api-Key", apiKey).get().url(endpoint).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            String body = response.body().string();
            return function.apply(body);
        } catch (IOException e) {
            throw new ResponseException("Synchronous request failed", e);
        }
    }

    /*protected <T, C> T execute(String endpoint, AbstractCallback<C> provider, Function<C, T> function, Consumer<Exception> failure) {
        Request request = new Request.Builder().header("TRN-Api-Key", apiKey).get().url(endpoint).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return function.apply(provider.provide(response.body()));
        } catch (Exception e) {
            if (failure != null)
                failure.accept(e);
        }
        return null;

    }*/

}
