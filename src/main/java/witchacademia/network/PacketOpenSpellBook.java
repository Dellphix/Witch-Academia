package witchacademia.network;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import witchacademia.gui.SpellBookScreen;

import java.util.function.Supplier;

public class PacketOpenSpellBook {
    public CompoundNBT tag;

    public PacketOpenSpellBook(CompoundNBT tag){
        this.tag = tag;
    }

    //Decoder
    public PacketOpenSpellBook(PacketBuffer buf) {
        this.tag = buf.readCompoundTag();
    }

    //Encoder
    public void toBytes(PacketBuffer buf) {
        buf.writeCompoundTag(this.tag);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> SpellBookScreen.open(this.tag));
        ctx.get().setPacketHandled(true);
    }
}
