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
        ResponseException exception = new ResponseException("Call failed", e);
        if (failure != null)
            failure.accept(exception);
        else
            throw exception;
    }

    @Override
    public void onResponse(Call call, Response response) {
        if (response.isSuccessful()) {
            try (ResponseBody body = response.body()) {
                success.accept(provide(body));
            } catch (Exception e) {
                ResponseException exception = new ResponseException("Accepting response failed", e);
                if (failure != null)
                    failure.accept(exception);
                else
                    throw exception;
            }
        } else if (failure != null) {
            failure.accept(new ResponseException("HTTP Request failed: " + response.message(), response.code()));
        } else {
            throw new ResponseException("HTTP Request failed: " + response.message(), response.code());
        }
    }

    protected abstract T provide(ResponseBody responseBody) throws Exception;


}
