package witchacademia.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import witchacademia.WitchAcademia;
import witchacademia.spells.Fireball;
import witchacademia.spells.SummonBerries;

public class Wand extends Item {

    public Wand() {
        super (new Item.Properties()
                .maxStackSize(1)
                .group(WitchAcademia.setup.itemGroup));
        setRegistryName("wand");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItemOffhand();
        if (stack.getItem() instanceof SpellBook)
        {
            //do selected spell
            new Fireball().doMagic(worldIn, playerIn);
            //new SummonBerries().doMagic(worldIn, playerIn);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
