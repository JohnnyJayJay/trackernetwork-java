package com.github.johnnyjayjay.trackernetwork.core;

import com.github.johnnyjayjay.trackernetwork.fortnite.GameMode;
import com.github.johnnyjayjay.trackernetwork.fortnite.Platform;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.Challenge;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.Item;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.Item.Category;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.Item.Rarity;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.MatchBundle;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.User;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.User.Season;
import com.github.johnnyjayjay.trackernetwork.fortnite.entities.User.Stats;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class FortniteTracker extends Tracker {

    private final String statsEndpoint = "https://api.fortnitetracker.com/v1/profile/%s/%s";
    private final String matchHistoryEndpoint = "https://api.fortnitetracker.com/v1/profile/account/%s/matches";
    private final String storeEndpoint = "https://api.fortnitetracker.com/v1/store";
    private final String challengeEndpoint = "https://api.fortnitetracker.com/v1/challenges";

    protected FortniteTracker(String apiKey, OkHttpClient okHttpClient) {
        super(apiKey, okHttpClient);
    }

    public void getUser(Platform platform, String userName, Consumer<User> success, Consumer<Exception> failure) {
        this.request(String.format(statsEndpoint, platform.getName(), userName), new JSONObjectCallback(failure, (object) -> {
            JSONArray array = object.getJSONArray("lifeTimeStats");
            JSONObject stats = object.getJSONObject("stats");

            User user = new User(object.getString("accountId"), platform, userName, getIntFromArray(array, 0), getIntFromArray(array, 1),
                    getIntFromArray(array, 2), getIntFromArray(array, 3), getIntFromArray(array, 4), getIntFromArray(array, 5),
                    getIntFromArray(array, 7), getIntFromArray(array, 8),
                    Float.parseFloat(array.getJSONObject(9).getString("value").replace("%", "")) / 100F, getIntFromArray(array, 10),
                    array.getJSONObject(11).optFloat("value"), Stats.parse(stats.optJSONObject("p2")), Stats.parse(stats.optJSONObject("p10")),
                    Stats.parse(stats.optJSONObject("p9")), new Season(Stats.parse(stats.optJSONObject("curr_p2")), Stats.parse(stats.optJSONObject("curr_p10")),
                    Stats.parse(stats.optJSONObject("curr_p9"))));
            success.accept(user);
        }));
    }

    public void getMatchHistory(String accountId, Consumer<List<MatchBundle>> success, Consumer<Exception> failure) {
        this.request(String.format(matchHistoryEndpoint, accountId), new JSONArrayCallback(failure, (array) -> {
            List<MatchBundle> matches = new ArrayList<>();
            JSONObject object;
            for (int i = 0; i < array.length(); i++) {
                object = array.getJSONObject(i);
                matches.add(new MatchBundle(accountId, object.getLong("id"), LocalDateTime.parse(object.getString("dateCollected")),
                        object.getInt("kills"), object.getInt("matches"), object.getInt("top1"), object.getInt("top10"),
                        object.getInt("top12"), object.getInt("top25"), object.getInt("top3"), object.getInt("top5"),
                        object.getInt("top6"), GameMode.ofIdentifier(object.getString("playlist"))));
            }
            success.accept(matches);
        }));
    }

    public void getStore(Consumer<List<Item>> success, Consumer<Exception> failure) {
        this.request(storeEndpoint, new JSONArrayCallback(failure, (array) -> {
            List<Item> store = new ArrayList<>();
            JSONObject object;
            for (int i = 0; i < array.length(); i++) {
                object = array.getJSONObject(i);
                store.add(new Item(Category.forName(object.getString("storeCategory")), Rarity.forName(object.getString("rarity")),
                        object.getString("name"), object.getString("imageUrl"), object.getInt("manifestId"), object.getInt("vBucks")));
            }
            success.accept(store);
        }));
    }

    public void getChallenges(Consumer<List<Challenge>> success, Consumer<Exception> failure) {
        this.request(challengeEndpoint, new JSONObjectCallback(failure, (object) -> {
            JSONArray array = object.getJSONArray("items");
            List<Challenge> challenges = new ArrayList<>();
            JSONArray metadata;
            for (int i = 0; i < array.length(); i++) {
                metadata = array.getJSONObject(i).getJSONArray("metadata");
                challenges.add(new Challenge(getStringFromArray(metadata, 1), getIntFromArray(array, 3),
                        getStringFromArray(array, 4), getStringFromArray(array, 5)));
            }
            success.accept(challenges);
        }));
    }

    public void getUser(Platform platform, String userName, Consumer<User> success) {
        this.getUser(platform, userName, success, null);
    }

    public void getMatchHistory(String accountId, Consumer<List<MatchBundle>> success) {
        this.getMatchHistory(accountId, success, null);
    }

    public void getMatchHistory(Platform platform, String userName, Consumer<List<MatchBundle>> success, Consumer<Exception> failure) {
        this.getUser(platform, userName, (user) -> this.getMatchHistory(user.getAccountId(), success, failure), failure);
    }

    public void getMatchHistory(Platform platform, String userName, Consumer<List<MatchBundle>> success) {
        this.getUser(platform, userName, (user) -> this.getMatchHistory(user.getAccountId(), success, null), null);
    }

    public void getStore(Consumer<List<Item>> success) {
        this.getStore(success, null);
    }

    public void getChallenges(Consumer<List<Challenge>> success) {
        this.getChallenges(success, null);
    }

   /* public User getUserBlocking(Platform platform, String userName, Consumer<Exception> failure) {
        return this.execute(String.format(statsEndpoint, platform.getName(), userName), (body, user) -> {

        }, failure);
    }*/

    private String getStringFromArray(JSONArray array, int index) {
        return array.getJSONObject(index).optString("value");
    }

    private int getIntFromArray(JSONArray array, int index) {
        return array.getJSONObject(index).optInt("value");
    }

}
