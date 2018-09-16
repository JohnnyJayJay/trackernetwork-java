package com.github.johnnyjayjay.trackernetwork.fortnite;

import java.io.Serializable;

public enum GameMode implements Serializable {

    SOLO("p2"), DUO("p10"), SQUAD("p9");

    private final String playlistIdentifier;

    GameMode(String playlistIdentifier) {
        this.playlistIdentifier = playlistIdentifier;
    }

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
