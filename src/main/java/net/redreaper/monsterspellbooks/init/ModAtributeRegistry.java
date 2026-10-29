package net.redreaper.monsterspellbooks.init;

import io.redspace.ironsspellbooks.api.attribute.MagicRangedAttribute;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

@Mod.EventBusSubscriber(modid = MonstersSpellbooks.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModAtributeRegistry {
    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, MonstersSpellbooks.MOD_ID);

    // NECRO
    public static final RegistryObject<Attribute> NECRO_MAGIC_RESIST = registerResistanceAttribute("necro");
    public static final RegistryObject<Attribute> NECRO_MAGIC_POWER = registerPowerAttribute("necro");
    //AERO
    public static final RegistryObject<Attribute> AERO_MAGIC_RESIST = registerResistanceAttribute("aero");
    public static final RegistryObject<Attribute> AERO_MAGIC_POWER = registerPowerAttribute("aero");

    public static void register(IEventBus eventBus)
    {
        ATTRIBUTES.register(eventBus);
    }

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent event)
    {
        event.getTypes().forEach(entityType ->
                ATTRIBUTES.getEntries().forEach(
                        attributeDeferredHolder -> event.add(entityType, attributeDeferredHolder.get()
                        )));
    }

    // ;_;
    private static RegistryObject<Attribute> registerResistanceAttribute(String id)
    {
        return ATTRIBUTES.register(id + "_magic_resist", () ->
                (new MagicRangedAttribute("attribute.monsterspellbooks." + id + "_magic_resist",
                        1.0D, -100, 100).setSyncable(true)));
    }

    private static RegistryObject<Attribute> registerPowerAttribute(String id)
    {
        return ATTRIBUTES.register(id + "_spell_power", () ->
                (new MagicRangedAttribute("attribute.monsterspellbooks." + id + "_spell_power",
                        1.0D, -100, 100).setSyncable(true)));
    }

    private static RegistryObject<Attribute> registerAttribute(String id)
    {
        return ATTRIBUTES.register(id, () ->
                (new MagicRangedAttribute("attribute.aces_spell_utils." + id,
                        1.0D, -100, 100).setSyncable(true)));
    }
}