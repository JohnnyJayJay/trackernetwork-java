package com.github.johnnyjayjay.trackernetwork.fortnite;

import java.io.Serializable;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public enum Platform implements Serializable {

    PC("pc"), PS4("psn"), XBOX_ONE("xb1");

    private final String name;

    Platform(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
