package com.github.johnnyjayjay.trackernetwork.fortnite.entities;

import org.json.JSONObject;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class User implements FortniteEntity {

    private final String accountId, platform, handle;
    private final int top5, top3, top6, top10, top12, top25, matchesPlayed, wins, kills;
    private final float winrate, kdRatio;
    private final Stats soloStats, duoStats, squadStats;

    public User(String accountId, String platform, String handle, int top5, int top3, int top6, int top10, int top12, int top25, int matchesPlayed,
                int wins, int kills, float winrate, float kdRatio, Stats soloStats, Stats duoStats, Stats squadStats, Stats lifeTimeStats) {
        this.accountId = accountId;
        this.platform = platform;
        this.handle = handle;
        this.top3 = top3;
        this.top5 = top5;
        this.top6 = top6;
        this.top10 = top10;
        this.top12 = top12;
        this.top25 = top25;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.kills = kills;
        this.winrate = winrate;
        this.kdRatio = kdRatio;
        this.soloStats = soloStats;
        this.duoStats = duoStats;
        this.squadStats = squadStats;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getPlatform() {
        return platform;
    }

    public String getHandle() {
        return handle;
    }

    public int getTop5() {
        return top5;
    }

    public int getTop3() {
        return top3;
    }

    public int getTop6() {
        return top6;
    }

    public int getTop10() {
        return top10;
    }

    public int getTop12() {
        return top12;
    }

    public int getTop25() {
        return top25;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getKills() {
        return kills;
    }

    public float getWinrate() {
        return winrate;
    }

    public float getKdRatio() {
        return kdRatio;
    }

    public Stats getSoloStats() {
        return soloStats;
    }

    public Stats getDuoStats() {
        return duoStats;
    }

    public Stats getSquadStats() {
        return squadStats;
    }

    public static class Stats {
        private final int top5, top3, top6, top10, top12, top25, matchesPlayed, wins, kills;
        private final float winrate, kdRatio;

        private Stats(int top3, int top5, int top6, int top10, int top12, int top25, int matchesPlayed, int wins, int kills, float winrate, float kdRatio) {
            this.top5 = top5;
            this.top3 = top3;
            this.top6 = top6;
            this.top10 = top10;
            this.top12 = top12;
            this.top25 = top25;
            this.matchesPlayed = matchesPlayed;
            this.wins = wins;
            this.kills = kills;
            this.winrate = winrate;
            this.kdRatio = kdRatio;
        }

        public int getTop5() {
            return top5;
        }

        public int getTop3() {
            return top3;
        }

        public int getTop6() {
            return top6;
        }

        public int getTop10() {
            return top10;
        }

        public int getTop12() {
            return top12;
        }

        public int getTop25() {
            return top25;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public int getWins() {
            return wins;
        }

        public int getKills() {
            return kills;
        }

        public float getWinrate() {
            return winrate;
        }

        public float getKdRatio() {
            return kdRatio;
        }

        public static Stats parse(JSONObject object) {
            return new Stats(getInt(object, "top3"), getInt(object, "top5"), getInt(object, "top6"),
                    getInt(object, "top10"), getInt(object, "top12"), getInt(object, "top25"), getInt(object, "matches"),
                    getInt(object, "top1"), getInt(object, "kills"), getFloat(object, "winRatio"), getFloat(object, "kd"));
        }

        private static int getInt(JSONObject jsonObject, String jsonObjectKey) {
            return jsonObject.getJSONObject(jsonObjectKey).getInt("valueInt");
        }

        private static float getFloat(JSONObject jsonObject, String jsonObjectKey) {
            return jsonObject.getJSONObject(jsonObjectKey).getFloat("valueDec");
        }

    }

}
