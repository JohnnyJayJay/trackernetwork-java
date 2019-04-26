package com.github.johnnyjayjay.trackernetwork.apex;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Platform {

    PC(5), XBOX(1), PSN(2);

    private final int id;

    Platform(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Platform forId(int id) {
        return Arrays.stream(values())
                .filter((p) -> p.id == id)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
