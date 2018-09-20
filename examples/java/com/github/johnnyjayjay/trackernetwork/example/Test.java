package com.github.johnnyjayjay.trackernetwork.example;

import com.github.johnnyjayjay.trackernetwork.core.FortniteTracker;
import com.github.johnnyjayjay.trackernetwork.core.TrackerNetworkClient;
import com.github.johnnyjayjay.trackernetwork.fortnite.Platform;

import java.util.Scanner;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class Test {

    private static TrackerNetworkClient client = new TrackerNetworkClient("");
    private static FortniteTracker tracker = client.getFortniteTracker();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Account");
        String userName = scanner.nextLine();
        tracker.getPlayer(Platform.PC, userName, (user) -> {
            System.out.println("Account-ID: " + user.getAccountId() + "\tMatches played: " + user.getMatchesPlayed());
            main(null);
        });
    }

}
