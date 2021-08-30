package com.magnum.magic.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class MagicPlanksBlock extends MyBlock{

    public MagicPlanksBlock() {
        super(Properties.create(Material.WOOD, MaterialColor.WOOD)
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.WOOD)
                .harvestTool(ToolType.AXE), "magic_planks");

    }
}
