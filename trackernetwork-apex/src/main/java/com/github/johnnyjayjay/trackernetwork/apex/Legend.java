package com.github.johnnyjayjay.trackernetwork.apex;

import org.immutables.value.Value;

@Value.Immutable
public interface Legend {

    String getName();

    String getIconUrl();

    String getBigImageUrl();

}
