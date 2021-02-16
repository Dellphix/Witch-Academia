package witchacademia.items;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import witchacademia.WitchAcademia;

public class Scroll extends Item {

    public Scroll() {
        super (new Item.Properties()
                .maxStackSize(1)
                .group(WitchAcademia.setup.itemGroup));
        setRegistryName("scroll");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //Berries! TODO figure out where your facing and spawn them in front, or see if you can add a velocity to the spawn so it gets spat out or something
        ItemEntity itemEntity = new ItemEntity(worldIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), new ItemStack(Items.SWEET_BERRIES));
        worldIn.addEntity(itemEntity);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
