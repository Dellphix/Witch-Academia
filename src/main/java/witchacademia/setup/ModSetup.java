package witchacademia.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import witchacademia.network.Networking;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("witchacademia") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistry.SCROLL);
        }
    };

    public void init() {
        Networking.registerMessages();
    }
}
