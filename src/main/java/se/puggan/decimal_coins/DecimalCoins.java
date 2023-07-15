package se.puggan.decimal_coins;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class DecimalCoins implements ModInitializer {
    public static String MOD_ID = "decimal_coins";

    @Override
    public void onInitialize() {
        int[] values = {1, 5, 10, 20, 100};

        for(int value : values) {
            Identifier id = new Identifier(MOD_ID, "coin_" + value);
            Coin coin = new Coin();
            Registry.register(Registries.ITEM, id, coin);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
                content.add(coin);
            });
        }
    }
}
