package witchacademia.spells;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class Fireball implements Spell {

    @Override
    public void doMagic(World worldIn, PlayerEntity playerIn) {

        //From GhastEntity in tick().
        Vector3d vector3d = playerIn.getLook(1.0F);

        //TODO Shooting at ourself for now
        double d2 = playerIn.getPosX() - (playerIn.getPosX() + vector3d.x * 4.0D);
        double d3 = playerIn.getPosYHeight(0.5D) - (0.5D + playerIn.getPosYHeight(0.5D));
        double d4 = playerIn.getPosZ() - (playerIn.getPosZ() + vector3d.z * 4.0D);

        FireballEntity fireballentity = new FireballEntity(worldIn, playerIn, d2, d3, d4);
        fireballentity.explosionPower = 1;
        fireballentity.setPosition(playerIn.getPosX() + vector3d.x * 4.0D, playerIn.getPosYHeight(0.5D) + 0.5D, fireballentity.getPosZ() + vector3d.z * 4.0D);
        worldIn.addEntity(fireballentity);
    }
}
