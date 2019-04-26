package com.github.johnnyjayjay.trackernetwork.apex;

import org.immutables.value.Value;

@Value.Immutable
public interface ApexProfile {

    String getId();

    Platform getPlatform();

    int getLevel();

}
