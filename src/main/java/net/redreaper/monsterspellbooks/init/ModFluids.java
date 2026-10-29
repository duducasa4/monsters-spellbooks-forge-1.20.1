package net.redreaper.monsterspellbooks.init;

import io.redspace.ironsspellbooks.fluids.NoopFluid;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

import java.util.function.Supplier;

public class ModFluids {
    private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, MonstersSpellbooks.MOD_ID);
    private static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MonstersSpellbooks.MOD_ID);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }


    public static final RegistryObject<FluidType> RAW_SANGUINITE_TYPE = FLUID_TYPES.register("raw_sanguinite", () -> new FluidType(FluidType.Properties.create()) {
        @Override
        public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions> consumer) {
            consumer.accept(new io.redspace.ironsspellbooks.fluids.SimpleClientFluidType(MonstersSpellbooks.id("block/raw_sanguinite")));
        }
    });
    public static final RegistryObject<FluidType> PUTRESCENCE_TYPE = FLUID_TYPES.register("putrescence", () -> new FluidType(FluidType.Properties.create()) {
        @Override
        public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions> consumer) {
            consumer.accept(new io.redspace.ironsspellbooks.fluids.SimpleClientFluidType(MonstersSpellbooks.id("block/putrescence")));
        }
    });
    public static final RegistryObject<FluidType> ECTOPLASM_TYPE = FLUID_TYPES.register("ectoplasm", () -> new FluidType(FluidType.Properties.create()) {
        @Override
        public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions> consumer) {
            consumer.accept(new io.redspace.ironsspellbooks.fluids.SimpleClientFluidType(MonstersSpellbooks.id("block/ectoplasm")));
        }
    });
    public static final RegistryObject<FluidType> VOID_FLUID_TYPE = FLUID_TYPES.register("void_fluid", () -> new FluidType(FluidType.Properties.create()) {
        @Override
        public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions> consumer) {
            consumer.accept(new io.redspace.ironsspellbooks.fluids.SimpleClientFluidType(MonstersSpellbooks.id("block/void_fluid")));
        }
    });

    public static final RegistryObject<net.minecraft.world.level.material.Fluid> RAW_SANGUINITE = registerNoop("raw_sanguinite", RAW_SANGUINITE_TYPE);
    public static final RegistryObject<net.minecraft.world.level.material.Fluid> PUTRESCENCE = registerNoop("putrescence", PUTRESCENCE_TYPE);
    public static final RegistryObject<net.minecraft.world.level.material.Fluid> ECTOPLASM = registerNoop("ectoplasm", ECTOPLASM_TYPE);
    public static final RegistryObject<net.minecraft.world.level.material.Fluid> VOID_FLUID = registerNoop("void_fluid", VOID_FLUID_TYPE);



    private static RegistryObject<net.minecraft.world.level.material.Fluid> registerNoop(String name, Supplier<FluidType> fluidType) {
        RegistryObject<net.minecraft.world.level.material.Fluid> holder = RegistryObject.create(MonstersSpellbooks.id(name), ForgeRegistries.FLUIDS);
        ForgeFlowingFluid.Properties properties = new ForgeFlowingFluid.Properties(fluidType, holder, holder).bucket(() -> Items.AIR);
        FLUIDS.register(name, () -> new NoopFluid(properties));
        return holder;
    }

}
