package com.magnum.magic.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class MagicOreBlock extends MyBlock{
    public MagicOreBlock() {
        super(Properties.create(Material.ROCK, MaterialColor.STONE)
                        .hardnessAndResistance(1.5F, 6.0F),
                "magic_ore");
    }
}
