package net.redreaper.monsterspellbooks.item.curios;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

public record MessageCurioKey(int playerId, int typ)
        implements net.redreaper.monsterspellbooks.network.ModPacket {



    public MessageCurioKey(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.playerId);
        buf.writeInt(this.typ);
    }


    public static void handle(MessageCurioKey message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.setPacketHandled(true);
        if (!context.getDirection().getReceptionSide().isServer()) {
            return;
        }

        context.enqueueWork(() -> {
            Player player = context.getSender();

            if (player == null) {
                return;
            }

            CuriosApi.getCuriosInventory(player).ifPresent(handler -> {

                for (var stacksHandler : handler.getCurios().values()) {

                    var stacks = stacksHandler.getStacks();

                    for (int i = 0; i < stacks.getSlots(); i++) {

                        ItemStack stack = stacks.getStackInSlot(i);

                        if (stack.isEmpty()) {
                            continue;
                        }

                        if (stack.getItem() instanceof KeybindCurio curio) {
                            curio.onKeyPacket(player, stack, message.typ);
                        }
                    }
                }
            });
        });
    }
}