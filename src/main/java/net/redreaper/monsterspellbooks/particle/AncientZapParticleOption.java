package net.redreaper.monsterspellbooks.particle;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.redreaper.monsterspellbooks.utils.ModStreamCodec;
import net.minecraft.world.phys.Vec3;
import net.redreaper.monsterspellbooks.init.ModParticleTypes;

import java.util.stream.IntStream;

public class AncientZapParticleOption implements ParticleOptions {
    public static ModStreamCodec<AncientZapParticleOption> STREAM_CODEC = ModStreamCodec.of(
            (buf, option) -> {
                buf.writeInt((int) option.destination.x * 10);
                buf.writeInt((int) option.destination.y * 10);
                buf.writeInt((int) option.destination.z * 10);
            },
            (buf) -> {
                return new AncientZapParticleOption(buf.readInt() / 10f, buf.readInt() / 10f, buf.readInt() / 10f);
            }
    );

    public static MapCodec<AncientZapParticleOption> MAP_CODEC = RecordCodecBuilder.mapCodec(object ->
            object.group(
                    Codec.INT_STREAM.fieldOf("destination").forGetter((option) -> IntStream.of((int) option.destination.x * 10, (int) option.destination.y * 10, (int) option.destination.z * 10))
            ).apply(object, (stream) -> {
                        var array = stream.toArray();
                        return new AncientZapParticleOption(new Vec3(array[0] / 10f, array[1] / 10f, array[2] / 10f));
                    }
            ));

    private final Vec3 destination;

    public AncientZapParticleOption(Vec3 destination) {
        this.destination = destination;
    }

    public AncientZapParticleOption(float x, float y, float z) {
        this(new Vec3(x, y, z));
    }

    public ParticleType<AncientZapParticleOption> getType() {
        return ModParticleTypes.ANCIENT_ZAP_PARTICLE.get();
    }

    public Vec3 getDestination() {
        return this.destination;
    }


    @SuppressWarnings("deprecation")
    public static final ParticleOptions.Deserializer<AncientZapParticleOption> DESERIALIZER = ModStreamCodec.deserializer(STREAM_CODEC, MAP_CODEC.codec());

    @Override
    public void writeToNetwork(FriendlyByteBuf buf) {
        STREAM_CODEC.encode(buf, this);
    }

    @Override
    public String writeToString() {
        return String.valueOf(BuiltInRegistries.PARTICLE_TYPE.getKey(this.getType()));
    }
}
