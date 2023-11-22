package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super(Item.AGED_BRIE, sellIn, quality);
    }

    @Override
    public void update() {
        super.update();

        if(quality < 50){
            quality++;
        }
    }
}
