package com.github.johnnyjayjay.trackernetwork.core;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class ResponseException extends RuntimeException {

    private final int code;

    public ResponseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ResponseException(String message) {
        this(message, 200);
    }

    public int getCode() {
        return code;
    }
}
