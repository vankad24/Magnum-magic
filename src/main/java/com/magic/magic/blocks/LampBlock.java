package com.magic.magic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.world.gen.feature.GlowstoneBlobFeature;
import net.minecraft.world.gen.placement.NetherGlowstone;

public class LampBlock extends Block {

    String name =
    public LampBlock(Properties properties) {
        super(Properties.create
                (Material.GLASS, MaterialColor.SAND)
                .hardnessAndResistance(0.3F)
                .sound(SoundType.GLASS)
                .lightValue(15));

    }


}
