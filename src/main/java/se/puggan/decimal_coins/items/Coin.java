package se.puggan.decimal_coins.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Coin extends Item {
    static Properties CoinProperties() {
        Properties p = (new Properties());
        p = p.group(ItemGroup.MISC);
        p = p.maxStackSize(100);
        return p;
    }
    public Coin() {
        super(CoinProperties());
    }
}
