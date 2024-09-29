package com.gildedrose;

import java.util.*;

class GildedRose {
    Item[] items;

    private QualityUpdater qualityUpdater = new QualityUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static final Map<String, Category> nameCategoryMap;

    static {
        Map<String, Category> map = new HashMap<>();
        map.put("Aged Brie", Category.AGING);
        map.put("Sulfuras, Hand of Ragnaros", Category.LEGENDARY);
        map.put("Backstage passes to a TAFKAL80ETC concert", Category.CONCERT_TICKET);
        map.put("Conjured Mana Cake", Category.CONJURED);
        nameCategoryMap = Collections.unmodifiableMap(map);
    }

    public void updateQuality() {
        List<ItemWithCategory> itemsWithCategories = getItemsWithCategories();
        itemsWithCategories.forEach(this::updateQuality);
    }

    private void updateQuality(ItemWithCategory itemWithCategory) {
        Category category = itemWithCategory.getCategory();
        Item item = itemWithCategory.getItem();
        category.updateQuality(qualityUpdater, item);
    }

    private List<ItemWithCategory> getItemsWithCategories() {
        List<ItemWithCategory> itemsWithCategories = new ArrayList<>();
        for (Item item : items) {
            Category category = nameCategoryMap.getOrDefault(item.name, Category.NORMAL);
            ItemWithCategory itemWithCategory = new ItemWithCategory(item, category);
            itemsWithCategories.add(itemWithCategory);
        }
        return itemsWithCategories;
    }

    private void updateQuality1() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }


}
