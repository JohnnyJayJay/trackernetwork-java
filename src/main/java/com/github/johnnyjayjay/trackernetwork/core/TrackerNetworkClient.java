package com.github.johnnyjayjay.trackernetwork.core;

import com.github.johnnyjayjay.trackernetwork.fortnite.FortniteTracker;
import okhttp3.OkHttpClient;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class TrackerNetworkClient {

    private OkHttpClient okHttpClient;

    public TrackerNetworkClient() {
        this.okHttpClient = new OkHttpClient();
    }

    public FortniteTracker newFortniteTracker(String apiKey) {
        return new FortniteTracker(apiKey, okHttpClient);
    }


}
