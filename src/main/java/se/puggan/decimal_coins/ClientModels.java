package se.puggan.decimal_coins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.GenericEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientModels {
    private static String lastMode = ServerConfig.ARABIC;

    static {
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, ClientModels::changeModels);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientModels::configLoaded);
    }

    static public void changeModels(RegistryEvent.Register<Item> event) {
        String[] modes = {"blank", "roman"};
        for(RegistryObject<Item> e : DecimalCoins.ITEMS.getEntries()) {
            for(String m : modes) {
                ResourceLocation location = new ResourceLocation(DecimalCoins.MOD_ID, e.getId().getPath() + "_" + m);
                ModelLoader.addSpecialModel(new ModelResourceLocation(location, "inventory"));
            }
        }
    }

    static public void setModelTheme(String mode) {
        if(lastMode.equals(mode)) {
            return;
        }

        ItemModelMesher itemModelMesher = Minecraft.getInstance().getItemRenderer().getItemModelMesher();

        for(RegistryObject<Item> e : DecimalCoins.ITEMS.getEntries()) {
            if(mode.equals("blank") || mode.equals("roman")) {
                ResourceLocation modelLocation = new ResourceLocation(DecimalCoins.MOD_ID, e.getId().getPath() + "_" + mode);
                itemModelMesher.register(e.get(), new ModelResourceLocation(modelLocation, "inventory"));
            } else {
                itemModelMesher.register(e.get(), new ModelResourceLocation(e.getId(), "inventory"));
            }
        }
    }

    static public void configLoaded(ModConfig.ModConfigEvent event) {
        setModelTheme(ServerConfig.modeConfig.get());
    }
}
