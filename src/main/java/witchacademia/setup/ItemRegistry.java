package witchacademia.setup;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import witchacademia.WitchAcademia;
import witchacademia.items.Scroll;
import witchacademia.items.SpellBook;
import witchacademia.items.Wand;

public class ItemRegistry {

    @ObjectHolder(WitchAcademia.MOD_ID + ":scroll")
    public static Scroll SCROLL;

    @ObjectHolder(WitchAcademia.MOD_ID + ":wand")
    public static Wand WAND;

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(WitchAcademia.setup.itemGroup);

            event.getRegistry().register(new Scroll());
            event.getRegistry().register(new Wand());
            event.getRegistry().register(new SpellBook());

        }
    }
}