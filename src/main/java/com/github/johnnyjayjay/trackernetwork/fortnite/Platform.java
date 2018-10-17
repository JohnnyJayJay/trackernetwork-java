package com.github.johnnyjayjay.trackernetwork.fortnite;

import java.io.Serializable;

/**
 * https://www.github.com/JohnnyJayJay
 *
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

    /**
     * @return The platform or Null if the name is invalid
     * @param name of a platform
     * */
    public static Platform fromName(String name) {
        switch (name.toLowerCase()) {
            case "ps4":
            case "psn":
            case "playstation":
                return Platform.PS4;
            case "xbox":
            case "xb1":
                return Platform.XBOX_ONE;
            case "pc":
                return Platform.PC;
            default:
                return null;
        }
    }
}
