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
        if (stack.getItem() instanceof SpellBook) {
            //do selected spell
            if (stack.hasTag() && stack.getTag() != null) {
                switch (SpellBook.getActiveSpell(stack.getTag())) {
                    case Fireball.SPELL_KEY:
                        new Fireball().doMagic(worldIn, playerIn);
                        break;
                    case SummonBerries.SPELL_KEY:
                        new SummonBerries().doMagic(worldIn, playerIn);
                        break;
                    default:
                        System.out.println("Spell not found");
                        break;
                }
            }
            else {
                System.out.println("No spell selected");
            }

        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
