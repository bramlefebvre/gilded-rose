package com.gildedrose;

public class QualityUpdater {



    void updateQualityNormal(Item item) {
        item.sellIn -= 1;
        int reduceQualityAmount;
        if (item.sellIn < 0) {
            reduceQualityAmount = 2;
        } else {
            reduceQualityAmount = 1;
        }
        reduceQuality(item, reduceQualityAmount);
    }

    void updateQualityAging(Item item) {
        item.sellIn -= 1;
        int increaseQualityAmount;
        if (item.sellIn < 0) {
            increaseQualityAmount = 2;
        } else {
            increaseQualityAmount = 1;
        }
        increaseQuality(item, increaseQualityAmount);
    }

    void updateQualityLegendary(Item item) {
        // do nothing
    }

    void updateQualityConcertTicket(Item item) {
        if (item.sellIn < 1) {
            item.quality = 0;
        } else {
            int increaseQualityAmount;
            if (item.sellIn >= 11) {
                increaseQualityAmount = 1;
            } else {
                if (item.sellIn < 6) {
                    increaseQualityAmount = 3;
                } else {
                    increaseQualityAmount = 2;
                }
            }
            increaseQuality(item, increaseQualityAmount);
        }
        item.sellIn -= 1;
    }

    void updateQualityConjured(Item item) {
        item.sellIn -= 1;
        int reduceQualityAmount;
        if (item.sellIn < 0) {
            reduceQualityAmount = 4;
        } else {
            reduceQualityAmount = 2;
        }
        reduceQuality(item, reduceQualityAmount);
    }

    private void reduceQuality(Item item, int reductionAmount) {
        int newQuality = item.quality - reductionAmount;
        if (newQuality < 0) {
            newQuality = 0;
        }
        item.quality = newQuality;
    }

    private void increaseQuality(Item item, int increaseAmount) {
        int newQuality = item.quality + increaseAmount;
        if (newQuality > 50) {
            newQuality = 50;
        }
        item.quality = newQuality;
    }

}
