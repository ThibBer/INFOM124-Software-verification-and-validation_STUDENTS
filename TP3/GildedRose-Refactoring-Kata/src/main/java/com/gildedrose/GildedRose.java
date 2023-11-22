package com.gildedrose;

class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        String agedBrie = "Aged Brie";
        String backstage = "Backstage passes to a TAFKAL80ETC concert";
        String sulfuras = "Sulfuras, Hand of Ragnaros";

        for (int i = 0; i < items.length; i++) {
            String name = items[i].getName();

            if (!name.equals(agedBrie) && !name.equals(backstage) && items[i].getQuality() > 0 && !name.equals(sulfuras)) {
                items[i].setQuality(items[i].getQuality() - 1);
            } else if (items[i].getQuality() < 50) {
                items[i].setQuality(items[i].getQuality() + 1);

                if (name.equals(backstage)) {
                    if (items[i].getSellIn() < 11) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }

                    if (items[i].getSellIn() < 6) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }

            if (!name.equals(sulfuras)) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (!name.equals(agedBrie)) {
                    if (items[i].getQuality() > 0 && !name.equals(backstage) && !name.equals(sulfuras)) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    } else {
                        items[i].setQuality(0);
                    }
                } else if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);
                }
            }
        }
    }
}
