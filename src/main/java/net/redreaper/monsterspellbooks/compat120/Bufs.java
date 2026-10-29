package net.redreaper.monsterspellbooks.compat120;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.phys.Vec3;

/** 1.21's FriendlyByteBuf.writeVec3/readVec3. */
public final class Bufs {
    private Bufs() {
    }

    public static void writeVec3(FriendlyByteBuf buf, Vec3 v) {
        buf.writeDouble(v.x);
        buf.writeDouble(v.y);
        buf.writeDouble(v.z);
    }

    public static Vec3 readVec3(FriendlyByteBuf buf) {
        return new Vec3(buf.readDouble(), buf.readDouble(), buf.readDouble());
    }
}
