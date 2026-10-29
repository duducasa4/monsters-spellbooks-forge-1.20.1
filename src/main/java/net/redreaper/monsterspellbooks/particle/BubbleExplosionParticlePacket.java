package net.redreaper.monsterspellbooks.particle;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;
import net.redreaper.monsterspellbooks.player.ModClientSpellCastHelper;

public class BubbleExplosionParticlePacket implements net.redreaper.monsterspellbooks.network.ModPacket {
    private final Vec3 pos1;
    private final float radius;

    public BubbleExplosionParticlePacket(Vec3 pos1, float radius) {
        this.pos1 = pos1;
        this.radius = radius;
    }

    public BubbleExplosionParticlePacket(FriendlyByteBuf buf) {
        pos1 = net.redreaper.monsterspellbooks.compat120.Bufs.readVec3(buf);
        radius = buf.readFloat();
    }

    public void write(FriendlyByteBuf buf) {
        net.redreaper.monsterspellbooks.compat120.Bufs.writeVec3(buf, pos1);
        buf.writeFloat(radius);
    }

    public static void handle(BubbleExplosionParticlePacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.setPacketHandled(true);
        context.enqueueWork(() -> {
            ModClientSpellCastHelper.handleClientboundBubbleExplosion(packet.pos1, packet.radius);
        });
    }

}
