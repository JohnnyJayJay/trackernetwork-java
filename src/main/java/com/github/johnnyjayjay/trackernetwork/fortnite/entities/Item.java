package com.github.johnnyjayjay.trackernetwork.fortnite.entities;

import java.io.Serializable;

/**
 * https://www.github.com/JohnnyJayJay
 * @author Johnny_JayJay
 */
public class Item implements FortniteEntity {

    private final Category storeCategory;
    private final Rarity rarity;
    private final String name, imageUrl;
    private final int manifestId, price;

    public Item(Category storeCategory, Rarity rarity, String name, String imageUrl, int manifestId, int price) {
        this.storeCategory = storeCategory;
        this.rarity = rarity;
        this.name = name;
        this.imageUrl = imageUrl;
        this.manifestId = manifestId;
        this.price = price;
    }

    public Category getStoreCategory() {
        return storeCategory;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getManifestId() {
        return manifestId;
    }

    public int getPrice() {
        return price;
    }

    public enum Rarity implements Serializable {
        STURDY("Sturdy"), HANDMADE("Handmade"), QUALITY("Quality"), FINE("Fine");

        private final String name;

        Rarity(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Rarity forName(String name) {
            Rarity ret = null;
            switch (name) {
                case "Sturdy":
                    ret = STURDY;
                    break;
                case "Handmade":
                    ret = HANDMADE;
                    break;
                case "Quality":
                    ret = QUALITY;
                    break;
                case "Fine":
                    ret = FINE;
                    break;
            }
            return ret;
        }
    }

    public enum Category implements Serializable {
        DAILY("BRDailyStorefront"), FEATURED("BRWeeklyStorefront");

        private final String name;

        Category(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static Category forName(String name) {
            Category ret = null;
            switch (name) {
                case "BRDailyStorefront":
                    ret = DAILY;
                    break;
                case "BrWeeklyStorefront":
                    ret = FEATURED;
                    break;
            }
            return ret;
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "storeCategory=" + storeCategory +
                ", rarity=" + rarity +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", manifestId=" + manifestId +
                ", price=" + price +
                '}';
    }
}
