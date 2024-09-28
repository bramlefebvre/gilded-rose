package com.gildedrose;

public class QualityUpdater {

    void updateQualityNormal(Item item) {
        checkInitialQualityIsNotLessThan0(item);
        checkInitialQualityIsNotMoreThan50(item);
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
        checkInitialQualityIsNotLessThan0(item);
        checkInitialQualityIsNotMoreThan50(item);
        item.sellIn -= 1;
        increaseQuality(item, 1);
    }

    void updateQualityLegendary(Item item) {
        checkQualityLegendaryItemIs80(item);
    }

    void updateQualityConcertTicket(Item item) {
        checkInitialQualityIsNotLessThan0(item);
        checkInitialQualityIsNotMoreThan50(item);
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            int increaseQualityAmount;
            if (item.sellIn >= 10) {
                increaseQualityAmount = 1;
            } else {
                if (item.sellIn < 5) {
                    increaseQualityAmount = 3;
                } else {
                    increaseQualityAmount = 2;
                }
            }
            increaseQuality(item, increaseQualityAmount);
        }
    }

    void updateQualityConjured(Item item) {
        checkInitialQualityIsNotLessThan0(item);
        checkInitialQualityIsNotMoreThan50(item);
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

    private void checkQualityLegendaryItemIs80(Item item) {
        if (item.quality != 80) {
            throw new IllegalArgumentException("Item with name " + item.name + "has a quality not equal to 80, while it is a legendary item");
        }
    }

    private void checkInitialQualityIsNotLessThan0(Item item) {
        if (item.quality < 0) {
            throw new IllegalArgumentException("Item with name " + item.name + "has a quality less than 0");
        }
    }

    private void checkInitialQualityIsNotMoreThan50(Item item) {
        if (item.quality > 50) {
            throw new IllegalArgumentException("Item with name " + item.name + "has a quality more than 50");
        }
    }

}
