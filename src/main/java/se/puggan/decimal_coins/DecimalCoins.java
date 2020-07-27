package se.puggan.decimal_coins;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DecimalCoins implements ModInitializer {
    // Directly reference a log4j logger.
    //public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "decimal_coins";

    public DecimalCoins() {
    }

    @Override
    public void onInitialize() {
        int[] values = {1, 5, 10, 20, 100};

        for(int value : values) {
            Identifier id = new Identifier(MOD_ID, "coin_" + value);
            Registry.register(Registry.ITEM, id, new Coin());
        }
    }
}
