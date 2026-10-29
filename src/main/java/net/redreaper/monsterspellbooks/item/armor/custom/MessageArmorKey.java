package net.redreaper.monsterspellbooks.item.armor.custom;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.redreaper.monsterspellbooks.MonstersSpellbooks;

public record MessageArmorKey (int equipmentSlot, int playerId, int typ) implements net.redreaper.monsterspellbooks.network.ModPacket {

    public MessageArmorKey(FriendlyByteBuf buf) {
        this(buf.readInt(), buf.readInt(), buf.readInt());
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.equipmentSlot());
        buf.writeInt(this.playerId());
        buf.writeInt(this.typ());
    }

    public static void handle(MessageArmorKey message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.setPacketHandled(true);
        if (context.getDirection().getReceptionSide().isServer()) {
            context.enqueueWork(() -> {
                Player player = context.getSender();
                EquipmentSlot equipmentSlot1 = EquipmentSlot.values()[Mth.clamp(message.equipmentSlot, 0, EquipmentSlot.values().length - 1)];
                ItemStack stack = player.getItemBySlot(equipmentSlot1);
                Item patt0$temp = stack.getItem();
                if (patt0$temp instanceof KeybindArmor armor) {
                    armor.onKeyPacket(player, stack, message.typ);
                }
            });
        }
    }

    public int equipmentSlot() {
        return this.equipmentSlot;
    }

    public int playerId() {
        return this.playerId;
    }

    public int typ() {
        return this.typ;
    }
}
