package net.redreaper.monsterspellbooks.utils;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.serialization.Codec;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.TagParser;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;

import java.util.function.BiConsumer;
import java.util.function.Function;

/** 1.20.1 stand-in for 1.21's StreamCodec (byte-buffer write/read pair), plus a particle Deserializer built from it. */
public final class ModStreamCodec<T> {
    private final BiConsumer<FriendlyByteBuf, T> encoder;
    private final Function<FriendlyByteBuf, T> decoder;

    private ModStreamCodec(BiConsumer<FriendlyByteBuf, T> encoder, Function<FriendlyByteBuf, T> decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    public static <T> ModStreamCodec<T> of(BiConsumer<FriendlyByteBuf, T> encoder, Function<FriendlyByteBuf, T> decoder) {
        return new ModStreamCodec<>(encoder, decoder);
    }

    public void encode(FriendlyByteBuf buf, T value) {
        encoder.accept(buf, value);
    }

    public T decode(FriendlyByteBuf buf) {
        return decoder.apply(buf);
    }

    /** For the /particle command the options are read as SNBT through the codec; over the network through this codec. */
    @SuppressWarnings("deprecation")
    public static <T extends ParticleOptions> ParticleOptions.Deserializer<T> deserializer(ModStreamCodec<T> stream, Codec<T> codec) {
        return new ParticleOptions.Deserializer<>() {
            @Override
            public T fromCommand(ParticleType<T> type, StringReader reader) throws CommandSyntaxException {
                reader.expect(' ');
                var tag = new TagParser(reader).readStruct();
                return codec.parse(NbtOps.INSTANCE, tag).result()
                    .orElseThrow(() -> new SimpleCommandExceptionType(Component.literal("Invalid particle options")).create());
            }

            @Override
            public T fromNetwork(ParticleType<T> type, FriendlyByteBuf buf) {
                return stream.decode(buf);
            }
        };
    }
}
