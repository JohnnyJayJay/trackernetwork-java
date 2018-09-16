package com.github.johnnyjayjay.trackernetwork.core;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * https://www.github.com/JohnnyJayJay
 *
 * @author Johnny_JayJay
 */
public abstract class AbstractCallback<T> implements Callback {

    private final Consumer<Exception> failure;
    private final Consumer<T> success;

    public AbstractCallback(Consumer<Exception> failure, Consumer<T> success) {
        this.failure = failure;
        this.success = success;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        if (failure != null)
            failure.accept(e);
        else
            e.printStackTrace();
    }

    @Override
    public void onResponse(Call call, Response response) {
        if (response.isSuccessful()) {
            try (ResponseBody body = response.body()) {
                success.accept(provide(body));
            } catch (Exception e) {
                if (failure != null)
                    failure.accept(e);
                else
                    e.printStackTrace();
            }
        } else if (failure != null) {
            failure.accept(new ResponseException("HTTP Request failed: " + response.message(), response.code()));
        } else {
            System.out.println("Response failed. " + response.message());
        }
    }

    protected abstract T provide(ResponseBody responseBody) throws Exception;


}
