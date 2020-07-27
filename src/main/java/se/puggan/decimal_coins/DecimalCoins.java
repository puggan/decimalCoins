package se.puggan.decimal_coins;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("decimal_coins")
public class DecimalCoins {
    // Directly reference a log4j logger.
    //public static final Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "decimal_coins";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, se.puggan.decimal_coins.DecimalCoins.MOD_ID);

    public DecimalCoins() {
        int[] values = {1, 5, 10, 20, 100};

        for(int value : values) {
            ITEMS.register("coin_" + value, Coin::new);
        }

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
    }
}
