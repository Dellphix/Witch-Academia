package witchacademia.setup;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import witchacademia.WitchAcademia;
import witchacademia.blocks.FairyLight;
import witchacademia.blocks.WritingDesk;

public class BlockRegistry {

    @ObjectHolder(WitchAcademia.MOD_ID + ":writing_desk")
    public static WritingDesk WRITING_DESK;

    @ObjectHolder(WitchAcademia.MOD_ID + ":fairy_light")
    public static FairyLight FAIRY_LIGHT;


    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new WritingDesk());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(WitchAcademia.setup.itemGroup);

            event.getRegistry().register(new BlockItem(BlockRegistry.WRITING_DESK, properties).setRegistryName(WritingDesk.REGISTRY_NAME));
        }
    }
}
