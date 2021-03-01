package witchacademia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class WritingDesk extends Block {

    public static final String REGISTRY_NAME = "writing_desk";

    public WritingDesk() {
        super(Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(1.0f)
                .setLightLevel(state -> 14)
        );
        setRegistryName(REGISTRY_NAME);
    }
}
