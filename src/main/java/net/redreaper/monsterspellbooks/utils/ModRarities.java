package net.redreaper.monsterspellbooks.utils;

import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Rarity;

import java.util.function.UnaryOperator;

public class ModRarities {
    public static final EnumProxy ILLAGER_RARITY_PROXY = new EnumProxy("MONSTERSPELLBOOKS_ILLAGER",
        (UnaryOperator<Style>) ((style) -> style.withColor(8497057))
    );

    public static final EnumProxy PRISMARINE_RARITY_PROXY = new EnumProxy("MONSTERSPELLBOOKS_PRISMARINE",
            (UnaryOperator<Style>) ((style) -> style.withColor(6664847))
    );

    public static final EnumProxy SOUL_RARITY_PROXY = new EnumProxy("MONSTERSPELLBOOKS_SOUL",
            (UnaryOperator<Style>) ((style) -> style.withColor(316109))
    );

    public static final EnumProxy DWARVEN_RARITY_PROXY = new EnumProxy("MONSTERSPELLBOOKS_DWARVEN",
            (UnaryOperator<Style>) ((style) -> style.withColor(16501864))
    );

    public static final EnumProxy BRIMSTONE_RARITY_PROXY = new EnumProxy("MONSTERSPELLBOOKS_BRIMSTONE",
            (UnaryOperator<Style>) ((style) -> style.withColor(16746085))
    );

    public static final EnumProxy SANGUINITE_RARITY_PROXY = new EnumProxy("MONSTERSPELLBOOKS_SANGUINITE",
            (UnaryOperator<Style>) ((style) -> style.withColor(16716189))
    );

    public static final EnumProxy WIND_RARITY_PROXY = new EnumProxy("MONSTERSPELLBOOKS_WIND",
            (UnaryOperator<Style>) ((style) -> style.withColor(11904458))
    );


    /** 1.20.1: Forge's Rarity.create stands in for NeoForge's enum extension. */
    public static final class EnumProxy {
        private final String name;
        private final UnaryOperator<Style> style;
        private Rarity value;

        EnumProxy(String name, UnaryOperator<Style> style) {
            this.name = name;
            this.style = style;
        }

        public synchronized Rarity getValue() {
            if (value == null) {
                value = Rarity.create(name, style);
            }
            return value;
        }
    }
}
