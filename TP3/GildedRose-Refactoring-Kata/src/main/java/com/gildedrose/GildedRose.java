package com.gildedrose;

class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        String agedBrie = "Aged Brie";
        String backstage = "Backstage passes to a TAFKAL80ETC concert";
        String sulfuras = "Sulfuras, Hand of Ragnaros";

        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals(agedBrie) && !items[i].name.equals(backstage) && items[i].quality > 0 && !items[i].name.equals(sulfuras)) {
                items[i].quality--;
            } else if (items[i].quality < 50) {
                items[i].quality++;

                if (items[i].name.equals(backstage)) {
                    if (items[i].sellIn < 11) {
                        items[i].quality++;
                    }

                    if (items[i].sellIn < 6) {
                        items[i].quality++;
                    }
                }
            }

            if (!items[i].name.equals(sulfuras)) {
                items[i].sellIn--;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(agedBrie)) {
                    if (items[i].quality > 0 && !items[i].name.equals(backstage) && !items[i].name.equals(sulfuras)) {
                        items[i].quality = items[i].quality - 1;
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
            }
        }
    }
}
