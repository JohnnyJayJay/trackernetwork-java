package com.github.johnnyjayjay.trackernetwork.fortnite;

import com.github.johnnyjayjay.trackernetwork.core.Tracker;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.User;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.function.Consumer;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class FortniteTracker extends Tracker {

    private final String statsEndpoint = "https://api.fortnitetracker.com/v1/profile/";

    public FortniteTracker(String apiKey, OkHttpClient okHttpClient) {
        super(apiKey, okHttpClient);
    }

    public void getUser(Platform platform, String userName, Consumer<User> success, Consumer<Throwable> failure) {
        this.request(statsEndpoint + platform.name + "/" + userName, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (failure != null)
                    failure.accept(e);
            }

            @Override
            public void onResponse(Call call, Response response) {
                try (ResponseBody body = response.body()) {
                    JSONObject jsonObject = new JSONObject(body.string());
                    // TODO: 15.09.2018  
                } catch (Exception e) {
                    if (failure != null)
                        failure.accept(e);
                    else
                        e.printStackTrace();
                }
            }
        });
    }

    public enum Platform {

        PC("pc"), PS4("psn"), XBOX_ONE("xb1");

        private final String name;

        Platform(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
