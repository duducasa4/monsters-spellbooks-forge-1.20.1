package net.redreaper.monsterspellbooks.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(()
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(
            Codec.STRING.fieldOf("loot_table").forGetter(m -> m.lootTable)).apply(inst, AddItemModifier::new)));
    private final String lootTable;

    protected AddItemModifier(LootItemCondition[] conditionsIn, String item) {
        super(conditionsIn);
        this.lootTable = item;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        ResourceLocation resourcePath = new ResourceLocation(lootTable);
        var addedLootTable = lootContext.getLevel().getServer().getLootData().getLootTable(resourcePath);

        addedLootTable.getRandomItemsRaw(lootContext, generatedLoot::add);

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
