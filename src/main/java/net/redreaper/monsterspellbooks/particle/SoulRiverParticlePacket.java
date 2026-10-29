package net.redreaper.monsterspellbooks.particle;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.player.ModClientSpellCastHelper;

public class SoulRiverParticlePacket implements net.redreaper.monsterspellbooks.network.ModPacket {
    private final Vec3 pos1;
    private final Vec3 pos2;

    public SoulRiverParticlePacket(Vec3 pos1, Vec3 pos2) {
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    public SoulRiverParticlePacket(FriendlyByteBuf buf) {
        pos1 = net.redreaper.monsterspellbooks.compat120.Bufs.readVec3(buf);
        pos2 = net.redreaper.monsterspellbooks.compat120.Bufs.readVec3(buf);
    }

    public void write(FriendlyByteBuf buf) {
        net.redreaper.monsterspellbooks.compat120.Bufs.writeVec3(buf, pos1);
        net.redreaper.monsterspellbooks.compat120.Bufs.writeVec3(buf, pos2);
    }

    public static void handle(SoulRiverParticlePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.setPacketHandled(true);
        context.enqueueWork(() -> {
            ModClientSpellCastHelper.handleClientboundSoulRiverParticles(packet.pos1, packet.pos2);
        });
    }

}

