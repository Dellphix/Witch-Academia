package witchacademia;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import witchacademia.blocks.ModBlocks;
import witchacademia.blocks.WritingDesk;
import witchacademia.items.Scroll;
import witchacademia.items.SpellBook;
import witchacademia.items.Wand;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(value = WitchAcademia.MOD_ID)
public class WitchAcademia {
    public static final String MOD_ID = "witchacademia";

    public static ModSetup setup = new ModSetup();

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public WitchAcademia() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        this.setup.init();
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new WritingDesk());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new Scroll());
            event.getRegistry().register(new Wand());
            event.getRegistry().register(new SpellBook());

            //TODO must we call setRegistryName() here and in WritingDesk? I guess this is registering the item version, but still
            event.getRegistry().register(new BlockItem(ModBlocks.WRITING_DESK, properties).setRegistryName("writing_desk"));
        }
    }
}
