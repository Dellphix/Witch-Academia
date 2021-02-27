package witchacademia;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import witchacademia.items.ModItems;
import witchacademia.network.Networking;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("witchacademia") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.SCROLL);
        }
    };

    public void init() {
        Networking.registerMessages();
    }
}
