package com.gildedrose;

public class Conjured extends Item {
    public Conjured(int sellIn, int quality) {
        super(Item.CONJURED, sellIn, quality);
    }

    @Override
    public void update() {
        super.update();

        quality -= 2;
    }
}
