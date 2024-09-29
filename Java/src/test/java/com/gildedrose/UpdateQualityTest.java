package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UpdateQualityTest {

    private final QualityUpdater qualityUpdater = new QualityUpdater();

    @Test
    void testNormalNegativeQuality() {
        Item itemNegativeQuality = new Item("name", 5, -1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityNormal(itemNegativeQuality));
    }

    @Test
    void testNormalQuality51() {
        Item itemQuality51 = new Item("name", 5, 51);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityNormal(itemQuality51));
    }

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
    void testAgingNegativeQuality() {
        Item itemNegativeQuality = new Item("name", 5, -1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityAging(itemNegativeQuality));
    }

    @Test
    void testAgingQuality51() {
        Item itemQuality51 = new Item("name", 5, 51);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityAging(itemQuality51));
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
    void testLegendaryValid() {
        Item legendaryItem = new Item("name", 5, 80);
        qualityUpdater.updateQualityLegendary(legendaryItem);
        assertEquals(5, legendaryItem.sellIn);
        assertEquals(80, legendaryItem.quality);
    }

    @Test
    void testLegendaryInvalid() {
        Item legendaryItem = new Item("name", 5, 79);
        assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityLegendary(legendaryItem));
    }

    @Test
    void testConcertTicketNegativeQuality() {
        Item itemNegativeQuality = new Item("name", 5, -1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityConcertTicket(itemNegativeQuality));
    }

    @Test
    void testConcertTicketQuality51() {
        Item itemQuality51 = new Item("name", 5, 51);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityConcertTicket(itemQuality51));
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
    void testConjuredNegativeQuality() {
        Item itemNegativeQuality = new Item("name", 5, -1);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityConjured(itemNegativeQuality));
    }

    @Test
    void testConjuredQuality51() {
        Item itemQuality51 = new Item("name", 5, 51);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> qualityUpdater.updateQualityConjured(itemQuality51));
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


}
