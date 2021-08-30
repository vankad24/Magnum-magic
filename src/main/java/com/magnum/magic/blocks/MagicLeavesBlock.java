package com.magnum.magic.blocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;

public class MagicLeavesBlock extends LeavesBlock {
    public MagicLeavesBlock() {
        super(Properties.from(Blocks.OAK_LEAVES)/*Properties.create(Material.LEAVES)
                .hardnessAndResistance(0.2F)
                .tickRandomly()
                .sound(SoundType.PLANT)
                .notSolid()*/);
        setRegistryName("magic_leaves");
    }
}
