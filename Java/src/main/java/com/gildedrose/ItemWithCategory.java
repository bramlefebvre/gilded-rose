package com.gildedrose;

public class ItemWithCategory {

    private final Item item;
    private final Category category;

    public ItemWithCategory(Item item, Category category) {
        this.item = item;
        this.category = category;
    }

    public Item getItem() {
        return item;
    }

    public Category getCategory() {
        return category;
    }
}
