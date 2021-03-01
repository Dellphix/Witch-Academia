package witchacademia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FairyLight extends Block {

    public FairyLight(Properties properties) {
        super(Properties.create(Material.MISCELLANEOUS)
                .sound(SoundType.SHROOMLIGHT)
                .doesNotBlockMovement()
                .notSolid()
                .variableOpacity()
                .hardnessAndResistance(0f, 0f)
                .setLightLevel(state -> 14)
        );
        setRegistryName("fairy_light");
    }
}
