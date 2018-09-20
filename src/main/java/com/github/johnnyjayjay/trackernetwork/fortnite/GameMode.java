package com.github.johnnyjayjay.trackernetwork.fortnite;

import java.io.Serializable;

/**
 * Represents a Fortnite BR Gamemode
 */
public enum GameMode implements Serializable {

    /**
     * The solo BR mode
     */
    SOLO("p2"),
    /**
     * The duo BR mode
     */
    DUO("p10"),
    /**
     * The squad BR mode
     */
    SQUAD("p9");

    private final String playlistIdentifier;

    GameMode(String playlistIdentifier) {
        this.playlistIdentifier = playlistIdentifier;
    }

    /**
     * @return The identifier used by this API to describe game modes.
     */
    public String getPlaylistIdentifier() {
        return playlistIdentifier;
    }

    
    public static GameMode ofIdentifier(String playlistIdentifier) {
        GameMode ret = null;
        switch (playlistIdentifier) {
            case "p2":
                ret = SOLO;
                break;
            case "p10":
                ret = DUO;
                break;
            case "p9":
                ret = SQUAD;
                break;
        }
        return ret;
    }
}
