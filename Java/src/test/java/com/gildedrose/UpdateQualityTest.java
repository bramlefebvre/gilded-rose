package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateQualityTest {

    private final QualityUpdater qualityUpdater = new QualityUpdater();

    @Test
    void testNormalPositiveSellIn() {
        Item itemPositiveSellIn = new Item("name", 10, 10);
        qualityUpdater.updateQualityNormal(itemPositiveSellIn);
        assertEquals(9, itemPositiveSellIn.sellIn);
        assertEquals(9, itemPositiveSellIn.quality);
    }

    @Test
    void testNormalSellIn0() {
        Item itemSellIn0 = new Item("name", 0, 10);
        qualityUpdater.updateQualityNormal(itemSellIn0);
        assertEquals(-1, itemSellIn0.sellIn);
        assertEquals(8, itemSellIn0.quality);
    }

    @Test
    void testNormalQualityTo0() {
        Item itemPositiveSellIn = new Item("name", 0, 1);
        qualityUpdater.updateQualityNormal(itemPositiveSellIn);
        assertEquals(-1, itemPositiveSellIn.sellIn);
        assertEquals(0, itemPositiveSellIn.quality);
    }

    @Test
    void testAgingPositiveSellIn() {
        Item itemPositiveSellIn = new Item("name", 10, 10);
        qualityUpdater.updateQualityAging(itemPositiveSellIn);
        assertEquals(9, itemPositiveSellIn.sellIn);
        assertEquals(11, itemPositiveSellIn.quality);
    }

    @Test
    void testAgingSellIn0() {
        Item itemSellIn0 = new Item("name", 0, 10);
        qualityUpdater.updateQualityAging(itemSellIn0);
        assertEquals(-1, itemSellIn0.sellIn);
        assertEquals(12, itemSellIn0.quality);
    }

    @Test
    void testAgingQualityTo50() {
        Item itemSellIn0 = new Item("name", 0, 49);
        qualityUpdater.updateQualityAging(itemSellIn0);
        assertEquals(-1, itemSellIn0.sellIn);
        assertEquals(50, itemSellIn0.quality);
    }

    @Test
    void testLegendary() {
        Item legendaryItem = new Item("name", 5, 80);
        qualityUpdater.updateQualityLegendary(legendaryItem);
        assertEquals(5, legendaryItem.sellIn);
        assertEquals(80, legendaryItem.quality);
    }

    @Test
    void testConcertTicketSellIn11() {
        Item item = new Item("name",11, 10);
        qualityUpdater.updateQualityConcertTicket(item);
        assertEquals(10, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    void testConcertTicketSellIn10() {
        Item item = new Item("name",10, 10);
        qualityUpdater.updateQualityConcertTicket(item);
        assertEquals(9, item.sellIn);
        assertEquals(12, item.quality);
    }

    @Test
    void testConcertTicketSellIn6() {
        Item item = new Item("name",6, 10);
        qualityUpdater.updateQualityConcertTicket(item);
        assertEquals(5, item.sellIn);
        assertEquals(12, item.quality);
    }

    @Test
    void testConcertTicketSellIn5() {
        Item item = new Item("name",5, 10);
        qualityUpdater.updateQualityConcertTicket(item);
        assertEquals(4, item.sellIn);
        assertEquals(13, item.quality);
    }

    @Test
    void testConcertTicketSellIn0() {
        Item item = new Item("name",0, 10);
        qualityUpdater.updateQualityConcertTicket(item);
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void testConcertTicketQualityTo50() {
        Item item = new Item("name",6, 49);
        qualityUpdater.updateQualityConcertTicket(item);
        assertEquals(5, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void testConjuredPositiveSellIn() {
        Item itemPositiveSellIn = new Item("name", 10, 10);
        qualityUpdater.updateQualityConjured(itemPositiveSellIn);
        assertEquals(9, itemPositiveSellIn.sellIn);
        assertEquals(8, itemPositiveSellIn.quality);
    }

    @Test
    void testConjuredSellIn0() {
        Item itemSellIn0 = new Item("name", 0, 10);
        qualityUpdater.updateQualityConjured(itemSellIn0);
        assertEquals(-1, itemSellIn0.sellIn);
        assertEquals(6, itemSellIn0.quality);
    }

    @Test
    void testConjuredQualityTo0() {
        Item itemSellIn0 = new Item("name", 0, 3);
        qualityUpdater.updateQualityConjured(itemSellIn0);
        assertEquals(-1, itemSellIn0.sellIn);
        assertEquals(0, itemSellIn0.quality);
    }


}
