package witchacademia.spells;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class SummonBerries implements Spell {

    @Override
    public void doMagic(World worldIn, PlayerEntity playerIn) {
        worldIn.playSound((PlayerEntity)null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_LINGERING_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (new Random().nextFloat() * 0.4F + 0.8F));

        worldIn.addParticle(ParticleTypes.LAVA, false,
                playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 0, 0, 0);

        //Berries! TODO figure out where your facing and spawn them in front, or see if you can add a velocity to the spawn so it gets spat out or something
        ItemEntity itemEntity = new ItemEntity(worldIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), new ItemStack(Items.SWEET_BERRIES));
        worldIn.addEntity(itemEntity);
    }
}
