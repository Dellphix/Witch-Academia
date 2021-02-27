package witchacademia.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;
import vazkii.patchouli.api.PatchouliAPI;
import witchacademia.WitchAcademia;
import witchacademia.gui.SpellBookScreen;
import witchacademia.network.Networking;
import witchacademia.network.PacketOpenSpellBook;

public class SpellBook extends Item {

    public SpellBook() {
        super (new Item.Properties()
                .maxStackSize(1)
                .group(WitchAcademia.setup.itemGroup));
        setRegistryName("spellbook");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (handIn == Hand.MAIN_HAND && playerIn instanceof ServerPlayerEntity) {
            System.out.println("Open book");
            //PatchouliAPI.instance.openBookGUI((ServerPlayerEntity) playerIn, Registry.ITEM.getKey(this));

            ItemStack stack = playerIn.getHeldItem(handIn);
            ServerPlayerEntity player = (ServerPlayerEntity) playerIn;
            Networking.sendToClient(new PacketOpenSpellBook(stack.getTag()), player);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
