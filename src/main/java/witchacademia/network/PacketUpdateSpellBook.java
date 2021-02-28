package witchacademia.network;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import witchacademia.gui.SpellBookScreen;
import witchacademia.items.SpellBook;

import java.util.function.Supplier;

public class PacketUpdateSpellBook {
    String spell;

    public PacketUpdateSpellBook(String spell){
        this.spell = spell;
    }

    //Decoder
    public PacketUpdateSpellBook(PacketBuffer buf) {
        this.spell = buf.readString();
    }

    //Encoder
    public void toBytes(PacketBuffer buf) {
        buf.writeString(this.spell);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(()-> {
            if(ctx.get().getSender() != null) {
                PlayerEntity player = ctx.get().getSender();
                ItemStack stack = player.getHeldItemMainhand();
                if (stack.getItem() instanceof SpellBook) {
                    SpellBook book = (SpellBook) stack.getItem();
                    book.setActiveSpell(this.spell);
                    System.out.println(this.spell);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
