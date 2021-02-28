package witchacademia.network;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import witchacademia.WitchAcademia;

public class Networking {

    private static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(WitchAcademia.MOD_ID, "witchacademia"),
            () -> "1.0",
            s -> true,
            s -> true);

    private static int id = 0;

    private static int nextID() {
        return id++;
    }

    public static void registerMessages() {
        System.out.println("Registering packets");

        INSTANCE.registerMessage(nextID(),
                PacketOpenSpellBook.class,
                PacketOpenSpellBook::toBytes,//Encoder
                PacketOpenSpellBook::new,//Decoder
                PacketOpenSpellBook::handle);//consumer
        INSTANCE.registerMessage(nextID(),
                PacketUpdateSpellBook.class,
                PacketUpdateSpellBook::toBytes,//Encoder
                PacketUpdateSpellBook::new,//Decoder
                PacketUpdateSpellBook::handle);//consumer
    }

    public static void sendToClient(Object packet, ServerPlayerEntity player) {
        INSTANCE.sendTo(packet, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }
}

