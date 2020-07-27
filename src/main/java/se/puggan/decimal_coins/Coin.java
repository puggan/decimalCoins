package se.puggan.decimal_coins;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Coin extends Item {
    static Item.Settings CoinProperties() {
        Item.Settings p = (new Item.Settings());
        p = p.group(ItemGroup.MISC);
        p = p.maxCount(100);
        return p;
    }
    public Coin() {
        super(CoinProperties());
    }
}
