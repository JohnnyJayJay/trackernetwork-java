package com.github.johnnyjayjay.trackernetwork.core;

import okhttp3.ResponseBody;
import org.json.JSONArray;

import java.util.function.Consumer;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class JSONArrayCallback extends AbstractCallback<JSONArray> {

    public JSONArrayCallback(Consumer<Exception> failure, Consumer<JSONArray> success) {
        super(failure, success);
    }

    @Override
    protected JSONArray provide(ResponseBody responseBody) throws Exception {
        return new JSONArray(responseBody.string());
    }
}
