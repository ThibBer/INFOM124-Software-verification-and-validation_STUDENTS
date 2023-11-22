package com.gildedrose;

public class Item {
    public static final String SULFURAS = "Sulfuras";
    public static final String CONJURED = "Conjured";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes";

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update(){
        if(sellIn > 0){
            sellIn--;
        }

        if(sellIn <= 0){
            quality = Math.max(0, quality - 2);
        }
    }

    public String toString() {
        return name + ", " + sellIn + ", " + quality;
    }
}
