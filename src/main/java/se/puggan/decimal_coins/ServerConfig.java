package se.puggan.decimal_coins;

import java.util.Set;
import java.util.TreeSet;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ServerConfig {
    public static final ServerConfig INSTANCE;
    public static final ForgeConfigSpec SPEC;
    public static final String ARABIC = "arabic";
    public static final String BLANK = "blank";
    public static final String ROMAN = "roman";
    public static final Set<String> modes = new TreeSet<>();
    public static ConfigValue<String> modeConfig;

    static {
        modes.add(ARABIC);
        modes.add(BLANK);
        modes.add(ROMAN);
        Pair<ServerConfig,ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        INSTANCE = specPair.getLeft();
        SPEC = specPair.getRight();
    }

    public String getMode() {
        return modeConfig.get();
    }

    public boolean validMode(Object mode) {
        return mode instanceof String && modes.contains(mode);
    }

    public boolean validMode(String mode) {
        return mode != null && modes.contains(mode);
    }

    public ServerConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Coin model modes: " + String.join(", ", modes));
        modeConfig = builder.define("coin_model", ARABIC, this::validMode);
    }
}
