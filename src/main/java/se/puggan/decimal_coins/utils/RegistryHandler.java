package se.puggan.decimal_coins.utils;

import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import se.puggan.decimal_coins.items.Coin;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, se.puggan.decimal_coins.DecimalCoins.MOD_ID);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
    }

    @OnlyIn(Dist.DEDICATED_SERVER)
    public static void initServerOnly() {
    }

    @OnlyIn(Dist.CLIENT)
    public static void initClientOnly() {
    }

    public static final RegistryObject<Item> ITEM_COIN_1 = ITEMS.register("coin_1", Coin::new);
    public static final RegistryObject<Item> ITEM_COIN_5 = ITEMS.register("coin_5", Coin::new);
    public static final RegistryObject<Item> ITEM_COIN_10 = ITEMS.register("coin_10", Coin::new);
    public static final RegistryObject<Item> ITEM_COIN_20 = ITEMS.register("coin_20", Coin::new);
    public static final RegistryObject<Item> ITEM_COIN_100 = ITEMS.register("coin_100", Coin::new);
}
