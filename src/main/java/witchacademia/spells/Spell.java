package witchacademia.spells;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface Spell {

    public static final String spellKey = "";
    public static final String name = "";

    public void doMagic(World worldIn, PlayerEntity playerIn);
}
