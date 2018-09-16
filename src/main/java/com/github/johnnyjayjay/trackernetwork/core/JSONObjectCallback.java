package com.github.johnnyjayjay.trackernetwork.core;

import okhttp3.ResponseBody;
import org.json.JSONObject;

import java.util.function.Consumer;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class JSONObjectCallback extends AbstractCallback<JSONObject> {

    public JSONObjectCallback(Consumer<Exception> failure, Consumer<JSONObject> success) {
        super(failure, success);
    }

    @Override
    protected JSONObject provide(ResponseBody responseBody) throws Exception {
        JSONObject object =  new JSONObject(responseBody.string());
        if (object.has("error")) {
            throw new ResponseException(object.getString("error"));
        }
        return object;
    }
}
