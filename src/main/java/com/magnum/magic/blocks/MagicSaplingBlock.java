package com.magnum.magic.blocks;

import com.magnum.magic.world.MagicTree;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MagicSaplingBlock extends SaplingBlock {
    public MagicSaplingBlock() {
        super(new MagicTree(), Properties.create(Material.PLANTS)
                .doesNotBlockMovement()
                .tickRandomly()
                .hardnessAndResistance(0f)
                .sound(SoundType.PLANT));
        setRegistryName("magic_sapling");
    }
}
