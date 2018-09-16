package com.github.johnnyjayjay.trackernetwork.core;

import okhttp3.OkHttpClient;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class TrackerNetworkClient {

    private final OkHttpClient okHttpClient;
    private final String apiKey;

    private final FortniteTracker fortniteTracker;

    public TrackerNetworkClient(String apiKey) {
        this.okHttpClient = new OkHttpClient();
        this.apiKey = apiKey;
        this.fortniteTracker = new FortniteTracker(apiKey, okHttpClient);
    }

    public FortniteTracker getFortniteTracker() {
        return fortniteTracker;
    }


}
