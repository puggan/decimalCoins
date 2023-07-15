package se.puggan.decimal_coins;

import net.minecraft.item.Item;

public class Coin extends Item {
    static Item.Settings CoinProperties() {
        Item.Settings p = (new Item.Settings());
        p = p.maxCount(50);
        return p;
    }
    public Coin() {
        super(CoinProperties());
    }
}
