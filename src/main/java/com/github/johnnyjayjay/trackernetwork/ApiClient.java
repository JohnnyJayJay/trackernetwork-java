package com.github.johnnyjayjay.trackernetwork;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public abstract class ApiClient {

    private final String apiKey;
    private final OkHttpClient client;

    protected ApiClient(String apiKey, OkHttpClient client) {
        this.apiKey = apiKey;
        this.client = client;
    }

    protected CompletableFuture<Response> get(String endpoint, Object... args) {
        Request request = buildRequest(endpoint, args);
        return CompletableFuture.supplyAsync(() -> execute(request)).thenApply((response) -> {
            if (!response.isSuccessful())
                throw new ResponseException(response.code());
            return response;
        });
    }

    private Response execute(Request request) {
        try (Response response = client.newCall(request).execute()) {
            return response;
        } catch (IOException e) {
            // TODO exception
            return null;
        }
    }

    private Request buildRequest(String endpoint, Object... args) {
        String url = String.format(endpoint, args);
        return new Request.Builder().get().url(url).addHeader("TRN-Api-Key", apiKey).build();
    }
}
