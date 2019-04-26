package com.github.johnnyjayjay.trackernetwork.apex;

import com.github.johnnyjayjay.trackernetwork.ApiClient;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author Johnny_JayJay (https://www.github.com/JohnnyJayJay)
 */
public class ApexClient extends ApiClient {

    private static final String PROFILE_ENDPOINT = "https://public-api.tracker.gg/apex/v1/standard/profile/%d/%s";

    private ApexClient(String apiKey, OkHttpClient client) {
        super(apiKey, client);
    }

    public static ApexClient create(String apiKey) {
        return new ApexClient(apiKey, new OkHttpClient.Builder().build());
    }

    public CompletableFuture<ApexProfile> getProfile(Platform platform, String name) {
        return get(PROFILE_ENDPOINT, platform.getId(), name).thenApply((response) -> {
            try {
                return new JSONObject(response.body().string());
            } catch (IOException e) {
                throw new RuntimeException(e); // TODO better handling
            }
        }).thenApply(this::parseFromJsonObject);
    }

    private ApexProfile parseFromJsonObject(JSONObject object) {
        object = object.getJSONObject("data");
        String id = object.getString("id");
        JSONArray children = object.getJSONArray("children");
        for (Object element : children) {
            JSONObject child = (JSONObject) element;
            Legend legend = getLegend(child);
        }
        return null;
    }

    private Legend getLegend(JSONObject child) {
        JSONObject metadata = child.getJSONObject("metadata");
        String legendName = metadata.getString("legend_name");
        String icon = metadata.getString("icon");
        String bgimage = metadata.getString("bgimage");
        // FIXME: 26.04.2019 generated immutables not accessible
    }

}
