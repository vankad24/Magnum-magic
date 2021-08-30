package com.magnum.magic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class MagicLogBlock extends LogBlock {
    public MagicLogBlock() {
        super(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN)
                .hardnessAndResistance(2.0F)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE));
        setRegistryName("magic_log");
    }
}
