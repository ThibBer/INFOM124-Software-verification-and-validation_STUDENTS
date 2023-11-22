package com.gildedrose;

public class BackstagePasses extends Item {

    public BackstagePasses(int sellIn, int quality) {
        super(Item.BACKSTAGE_PASSES, sellIn, quality);
    }

    @Override
    public void update() {
        super.update();

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
