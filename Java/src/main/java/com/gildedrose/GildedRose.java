package com.gildedrose;

import java.util.*;

class GildedRose {
    Item[] items;

    private final QualityUpdater qualityUpdater = new QualityUpdater();

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

}
