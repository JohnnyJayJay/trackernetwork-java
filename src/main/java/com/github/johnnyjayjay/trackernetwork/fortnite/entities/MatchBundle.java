package com.github.johnnyjayjay.trackernetwork.fortnite.entities;

import com.github.johnnyjayjay.trackernetwork.fortnite.GameMode;

import java.time.LocalDateTime;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class Matches implements FortniteEntity {

    private final String accountId;
    private final long id;
    private final LocalDateTime dateTime;
    private final int kills, matches, wins, top10, top12, top25, top3, top5, top6;
    private final GameMode mode;

    public Matches(String accountId, long id, LocalDateTime dateTime, int kills, int matches, int wins, int top10,
                   int top12, int top25, int top3, int top5, int top6, GameMode mode) {
        this.accountId = accountId;
        this.id = id;
        this.dateTime = dateTime;
        this.kills = kills;
        this.matches = matches;
        this.wins = wins;
        this.top10 = top10;
        this.top12 = top12;
        this.top25 = top25;
        this.top3 = top3;
        this.top5 = top5;
        this.top6 = top6;
        this.mode = mode;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getKills() {
        return kills;
    }

    public int getMatches() {
        return matches;
    }

    public int getWins() {
        return wins;
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

    public int getTop3() {
        return top3;
    }

    public int getTop5() {
        return top5;
    }

    public int getTop6() {
        return top6;
    }

    public GameMode getMode() {
        return mode;
    }

    public String getAccountId() {
        return accountId;
    }
}
