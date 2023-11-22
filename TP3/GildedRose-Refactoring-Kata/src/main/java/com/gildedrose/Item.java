package com.gildedrose;

public class Item {
    public static final String sulfuras = "Sulfuras";
    public static final String conjured = "Conjured";
    public static final String agedBrie = "Aged Brie";
    public static final String backstagePasses = "Backstage passes";

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = name.equals(sulfuras) ? quality : 80;
    }
    public String toString() {
        return name + ", " + sellIn + ", " + quality;
    }

    public void update(){
        if(name.equals(sulfuras)){
            return;
        }

        if(sellIn > 0){
            sellIn--;
        }

        if((sellIn < 0 || name.equals(conjured)) && quality >= 2){
            quality -= 2;
        }

        if(name.equals(agedBrie) && quality < 50){
            quality++;
            return;
        }

        if(name.equals(backstagePasses)){
            if(sellIn < 0){
                quality = 0;
                return;
            }

            if(quality < 50){
                if(sellIn <= 5){
                    quality += 3;
                    return;
                }

                if(sellIn <= 10){
                    quality += 2;
                }
            }
        }
    }
}
