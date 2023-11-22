package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void nameTest() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void defaultSellInUpdate(){
        int sellIn = 10;
        Item[] items = new Item[] { new Item("foo", sellIn, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    @Test
    void superSulfuras(){
        Item item = new Sulfuras(10);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(item, app.items[0]);
    }

    @Test
    void conjuredItem(){
        int quality = 5;
        Item item = new Conjured(10, quality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(quality - 2, app.items[0].quality);
    }

    @Test
    void agedBrieItem(){
        int quality = 5;
        Item sulfurasItem = new AgedBrie(10, quality);
        Item[] items = new Item[] { sulfurasItem };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(quality - 2, app.items[0].quality);
    }
}
