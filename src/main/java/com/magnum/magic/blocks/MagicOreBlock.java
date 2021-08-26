package com.magnum.magic.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class MagicOreBlock extends MyOreBlock {
    public MagicOreBlock() {
        super(Properties.create(Material.ROCK, MaterialColor.STONE)
                        .hardnessAndResistance(1.5F, 6.0F),
                "magic_ore");
        setProperties(4,10,5,30,100);
    }

    @Override
    protected int getExperience(Random rand) {
        return MathHelper.nextInt(rand, 3, 7);
    }
}
