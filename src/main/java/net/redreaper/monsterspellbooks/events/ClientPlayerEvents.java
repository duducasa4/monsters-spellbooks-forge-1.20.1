package net.redreaper.monsterspellbooks.events;

import io.redspace.ironsspellbooks.api.entity.IMagicEntity;
import io.redspace.ironsspellbooks.player.ClientMagicData;
import io.redspace.ironsspellbooks.player.SpinAttackType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.TickEvent;
import net.redreaper.monsterspellbooks.init.ModSpellRegistry;
import net.redreaper.monsterspellbooks.render.ModSpellRenderingHelper;
import net.redreaper.monsterspellbooks.spells.hydro.RiptideDashSpell;
import net.redreaper.monsterspellbooks.spells.necro.WitherNovaSpell;

import java.util.List;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientPlayerEvents {

    @SubscribeEvent
    public static void afterLivingRender(RenderLivingEvent.Post<? extends LivingEntity, ? extends EntityModel<? extends LivingEntity>> event) {
        var livingEntity = event.getEntity();
        if (livingEntity instanceof Player) {
            var syncedData = ClientMagicData.getSyncedSpellData(livingEntity);
            if (syncedData.isCasting()) {
                ModSpellRenderingHelper.renderSpellHelper(syncedData, livingEntity, event.getPoseStack(), event.getMultiBufferSource(), event.getPartialTick());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START && event.player == Minecraft.getInstance().player) {
            var level = Minecraft.getInstance().level;
            if (level != null) {
                List<Entity> spellcasters = level.getEntities((Entity) null, event.player.getBoundingBox().inflate(64), (mob) -> mob instanceof Player || mob instanceof IMagicEntity);
                spellcasters.forEach((entity) -> {
                    LivingEntity livingEntity = (LivingEntity) entity;
                    var spellData = ClientMagicData.getSyncedSpellData(livingEntity);
                    if (spellData.getCastingSpellId().equals(ModSpellRegistry.WITHER_NOVA.get().getSpellId())) {
                            WitherNovaSpell.ambientParticles(livingEntity, spellData);
                    }

                    if (livingEntity.isAutoSpinAttack() && spellData.getSpinAttackType() == SpinAttackType.RIPTIDE) {
                        RiptideDashSpell.ambientParticles(level, livingEntity);
                    }
                }
                );
            }
        }
    }
}
