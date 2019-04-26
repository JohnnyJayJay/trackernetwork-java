package com.github.johnnyjayjay.trackernetwork.apex;

import org.immutables.value.Value;

@Value.Immutable
public interface ApexStats {

    Legend getLegend();

    int getKills();

    double getDamage();

    int getHeadshots();

    int getPistolKills();

    int getWins();

    int getFinishers();

    int getSeasonWins();

    int getMatchesPlayed();

    int getKillsAsKillLeader();

    double getDamagePerMatch();

    double getKillsPerMatch();

    double getPassiveValue();

}
