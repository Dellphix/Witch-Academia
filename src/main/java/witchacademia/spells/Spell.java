package witchacademia.spells;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface Spell {

    public static final String SPELL_KEY = "";
    public static final String NAME = "";

    public void doMagic(World worldIn, PlayerEntity playerIn);
}
