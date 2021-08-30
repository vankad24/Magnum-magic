package com.magnum.magic.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class MagicOreBlock extends MyOreBlock {
    public MagicOreBlock() {
        super(Properties.create(Material.ROCK, MaterialColor.STONE)
                        .hardnessAndResistance(3.0F, 3.0F)
                        .harvestTool(ToolType.PICKAXE)
                        .harvestLevel(2),
                "magic_ore");
        setProperties(4,10,5,0,16);
    }

    @Override
    protected int getExperience(Random rand) {
        return MathHelper.nextInt(rand, 3, 7);
    }
}
