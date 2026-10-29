package net.redreaper.monsterspellbooks.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.item.armor.custom.MessageArmorKey;
import net.redreaper.monsterspellbooks.item.curios.MessageCurioKey;
import net.redreaper.monsterspellbooks.particle.*;

/**
 * 1.20.1 networking: one SimpleChannel for this mod's packets. The send methods mirror the 1.21 PacketDistributor
 * calls the mod was written with; a packet of Iron's (not a {@link ModPacket}) is passed on to Iron's own
 * 1.20.1 PacketDistributor.
 */
public final class ModNetwork {
    private static final String VERSION = "1";
    private static SimpleChannel CHANNEL;
    private static int id = 0;

    private ModNetwork() {
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(MonstersSpellbooks.MOD_ID, "main"))
            .networkProtocolVersion(() -> VERSION)
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();
        CHANNEL = net;
        net.messageBuilder(ElectricExplosionParticlesPacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(ElectricExplosionParticlesPacket::new).encoder(ElectricExplosionParticlesPacket::write)
            .consumerMainThread(ElectricExplosionParticlesPacket::handle).add();
        net.messageBuilder(SoulExplosionParticlePacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(SoulExplosionParticlePacket::new).encoder(SoulExplosionParticlePacket::write)
            .consumerMainThread(SoulExplosionParticlePacket::handle).add();
        net.messageBuilder(EnderExplosionParticlePacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(EnderExplosionParticlePacket::new).encoder(EnderExplosionParticlePacket::write)
            .consumerMainThread(EnderExplosionParticlePacket::handle).add();
        net.messageBuilder(PoisonExplosionParticlePacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(PoisonExplosionParticlePacket::new).encoder(PoisonExplosionParticlePacket::write)
            .consumerMainThread(PoisonExplosionParticlePacket::handle).add();
        net.messageBuilder(ThunderStepParticlePacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(ThunderStepParticlePacket::new).encoder(ThunderStepParticlePacket::write)
            .consumerMainThread(ThunderStepParticlePacket::handle).add();
        net.messageBuilder(SoulRiverParticlePacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(SoulRiverParticlePacket::new).encoder(SoulRiverParticlePacket::write)
            .consumerMainThread(SoulRiverParticlePacket::handle).add();
        net.messageBuilder(BubbleExplosionParticlePacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
            .decoder(BubbleExplosionParticlePacket::new).encoder(BubbleExplosionParticlePacket::write)
            .consumerMainThread(BubbleExplosionParticlePacket::handle).add();
        net.messageBuilder(MessageCurioKey.class, id++, NetworkDirection.PLAY_TO_SERVER)
            .decoder(MessageCurioKey::new).encoder(MessageCurioKey::write)
            .consumerMainThread(MessageCurioKey::handle).add();
        net.messageBuilder(MessageArmorKey.class, id++, NetworkDirection.PLAY_TO_SERVER)
            .decoder(MessageArmorKey::new).encoder(MessageArmorKey::write)
            .consumerMainThread(MessageArmorKey::handle).add();
    }

    public static void sendToServer(Object msg, Object... ignored) {
        if (msg instanceof ModPacket) {
            CHANNEL.sendToServer(msg);
        } else {
            io.redspace.ironsspellbooks.setup.PacketDistributor.sendToServer(msg);
        }
    }

    public static void sendToPlayer(ServerPlayer player, Object msg, Object... ignored) {
        if (msg instanceof ModPacket) {
            CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), msg);
        } else {
            io.redspace.ironsspellbooks.setup.PacketDistributor.sendToPlayer(player, msg);
        }
    }

    public static void sendToAllPlayers(Object msg, Object... ignored) {
        if (msg instanceof ModPacket) {
            CHANNEL.send(PacketDistributor.ALL.noArg(), msg);
        } else {
            io.redspace.ironsspellbooks.setup.PacketDistributor.sendToAllPlayers(msg);
        }
    }

    public static void sendToPlayersTrackingEntity(Entity entity, Object msg, Object... ignored) {
        if (msg instanceof ModPacket) {
            CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), msg);
        } else {
            io.redspace.ironsspellbooks.setup.PacketDistributor.sendToPlayersTrackingEntity(entity, msg);
        }
    }

    public static void sendToPlayersTrackingEntityAndSelf(Entity entity, Object msg, Object... ignored) {
        if (msg instanceof ModPacket) {
            CHANNEL.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), msg);
        } else {
            io.redspace.ironsspellbooks.setup.PacketDistributor.sendToPlayersTrackingEntityAndSelf(entity, msg);
        }
    }
}
