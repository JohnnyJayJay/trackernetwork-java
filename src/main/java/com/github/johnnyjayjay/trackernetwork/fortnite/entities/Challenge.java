package com.github.johnnyjayjay.trackernetwork.fortnite.entities;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class Challenge implements FortniteEntity {

    private final int amount;
    private final String name, rewardPictureUrl, rewardName;

    public Challenge(String name, int amount, String rewardPictureUrl, String rewardName) {
        this.name = name;
        this.amount = amount;
        this.rewardPictureUrl = rewardPictureUrl;
        this.rewardName = rewardName;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getRewardPictureUrl() {
        return rewardPictureUrl;
    }

    public String getRewardName() {
        return rewardName;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                ", rewardPictureUrl='" + rewardPictureUrl + '\'' +
                ", rewardName='" + rewardName + '\'' +
                '}';
    }
}
