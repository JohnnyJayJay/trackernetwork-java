package com.github.johnnyjayjay.trackernetwork.fortnite.entities;

import com.github.johnnyjayjay.trackernetwork.fortnite.Platform;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Represents a Fortnite BR player.
 * Instances of this class are immutable and will not be updated in any case.
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class Player implements FortniteEntity {

    private final String accountId, handle;
    private final Platform platform;
    private final Season season;
    private final int top5, top3, top6, top10, top12, top25, matchesPlayed, wins, kills;
    private final float winrate, kdRatio;
    private final Stats soloStats, duoStats, squadStats;

    public Player(String accountId, Platform platform, String handle, int top5, int top3, int top6, int top10, int top12, int top25, int matchesPlayed,
                  int wins, float winrate, int kills, float kdRatio, Stats soloStats, Stats duoStats, Stats squadStats, Season season) {
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
        this.season = season;
    }

    /**
     * The account ID of this player. May be used to get the match history.
     * @return The account id
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * The platform this player is bound to
     * @return the platform
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * The Epic Games Handle of this player
     * @return the player's name in game
     */
    public String getHandle() {
        return handle;
    }

    /**
     * Lifetime stats - Top 5
     * @return how often this player has been in the top 5 (lifetime)
     */
    public int getTop5() {
        return top5;
    }

    /**
     * Lifetime stats - Top 3
     * @return how often this player has been in the top 3 (lifetime)
     */
    public int getTop3() {
        return top3;
    }

    /**
     * Lifetime stats - Top 6
     * @return how often this player has been in the top 6 (lifetime)
     */
    public int getTop6() {
        return top6;
    }

    /**
     * Lifetime stats - Top 10
     * @return how often this player has been in the top 10 (lifetime)
     */
    public int getTop10() {
        return top10;
    }

    /**
     * Lifetime stats - Top 12
     * @return how often this player has been in the top 12 (lifetime)
     */
    public int getTop12() {
        return top12;
    }

    /**
     * Lifetime stats - Top 25
     * @return how often this player has been in the top 25 (lifetime)
     */
    public int getTop25() {
        return top25;
    }

    /**
     * Lifetime stats - Top 5
     * @return how many matches this player has played in his entire Fortnite history.
     */
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    /**
     * Lifetime stats - Wins
     * @return how many matches this player has won in his entire Fortnite history.
     */
    public int getWins() {
        return wins;
    }

    /**
     * Lifetime stats - Kills
     * @return how many kills this player has made in his entire Fortnite history.
     */
    public int getKills() {
        return kills;
    }

    /**
     * Lifetime stats - Winrate
     * @return the relative amount of matches this player wins for each match
     */
    public float getWinrate() {
        return winrate;
    }

    /**
     * Lifetime stats - K/D
     * @return the quotient of lifetime kills / lifetime deaths
     */
    public float getKdRatio() {
        return kdRatio;
    }

    /**
     * Gets the lifetime solo stats of this player
     * @return the solo stats object
     */
    public Stats getSoloStats() {
        return soloStats;
    }

    /**
     * Gets the lifetime duo stats of this player
     * @return the duo stats object
     */
    public Stats getDuoStats() {
        return duoStats;
    }

    /**
     * Gets the lifetime squad stats of this player
     * @return the squad stats object
     */
    public Stats getSquadStats() {
        return squadStats;
    }

    /**
     * Gets the current season which itself contains again 3 Stats objects
     * @return the season object
     */
    public Season getSeason() {
        return season;
    }

    /**
     *
     */
    public static class Stats implements Serializable {
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

        /**
         * The amount of matches the corresponding player has been in the top 5 for these stats
         * @return how often the player has been in the top 5
         */
        public int getTop5() {
            return top5;
        }

        /**
         * The amount of matches the corresponding player has been in the top 3 for these stats
         * @return how often the player has been in the top 3
         */
        public int getTop3() {
            return top3;
        }

        /**
         * The amount of matches the corresponding player has been in the top 6 for these stats
         * @return how often the player has been in the top 6
         */
        public int getTop6() {
            return top6;
        }

        /**
         * The amount of matches the corresponding player has been in the top 10 for these stats
         * @return how often the player has been in the top 10
         */
        public int getTop10() {
            return top10;
        }

        /**
         * The amount of matches the corresponding player has been in the top 12 for these stats
         * @return how often the player has been in the top 12
         */
        public int getTop12() {
            return top12;
        }

        /**
         * The amount of matches the corresponding player has been in the top 25 for these stats
         * @return how often the player has been in the top 25
         */
        public int getTop25() {
            return top25;
        }

        /**
         * The amount of matches the corresponding player has played for these stats
         * @return how many matches the player has played
         */
        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        /**
         * The amount of matches the corresponding player has won for these stats
         * @return how many matches the player has won
         */
        public int getWins() {
            return wins;
        }

        /**
         * The amount of kills the corresponding player has made for these stats
         * @return how many kills the player has made
         */
        public int getKills() {
            return kills;
        }
        /**
         * The amount of matches the corresponding player has played for these stats
         * @return how many matches the player has played
         */

        public float getWinrate() {
            return winrate;
        }

        public float getKdRatio() {
            return kdRatio;
        }

        @Override
        public String toString() {
            return "Stats{" +
                    "top5=" + top5 +
                    ", top3=" + top3 +
                    ", top6=" + top6 +
                    ", top10=" + top10 +
                    ", top12=" + top12 +
                    ", top25=" + top25 +
                    ", matchesPlayed=" + matchesPlayed +
                    ", wins=" + wins +
                    ", kills=" + kills +
                    ", winrate=" + winrate +
                    ", kdRatio=" + kdRatio +
                    '}';
        }

        public static Stats parse(JSONObject object) {
            if (object == null)
                return null;
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

    public static class Season implements Serializable {
        private final Stats soloStats, duoStats, squadStats;

        public Season(Stats soloStats, Stats duoStats, Stats squadStats) {
            this.soloStats = soloStats;
            this.duoStats = duoStats;
            this.squadStats = squadStats;
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

        @Override
        public String toString() {
            return "Season{" +
                    "soloStats=" + soloStats +
                    ", duoStats=" + duoStats +
                    ", squadStats=" + squadStats +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "accountId='" + accountId + '\'' +
                ", handle='" + handle + '\'' +
                ", platform=" + platform.getName() +
                ", season=" + season +
                ", top5=" + top5 +
                ", top3=" + top3 +
                ", top6=" + top6 +
                ", top10=" + top10 +
                ", top12=" + top12 +
                ", top25=" + top25 +
                ", matchesPlayed=" + matchesPlayed +
                ", wins=" + wins +
                ", kills=" + kills +
                ", winrate=" + winrate +
                ", kdRatio=" + kdRatio +
                ", soloStats=" + soloStats +
                ", duoStats=" + duoStats +
                ", squadStats=" + squadStats +
                '}';
    }
}
