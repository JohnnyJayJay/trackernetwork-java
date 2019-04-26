package com.github.johnnyjayjay.trackernetwork;

import java.util.List;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public class ResponseException extends RuntimeException {

    private final int responseCode;

    public ResponseException(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
