package com.magic.magic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

import java.util.Locale;

public class LampBlock extends Block implements INonItem {

    public static String name ;
    public LampBlock() {
        super(Block.Properties.create
                (Material.GLASS, MaterialColor.SAND)
                .hardnessAndResistance(0.3F)
                .sound(SoundType.GLASS)
                .lightValue(15));
        name = getClass().getName().toLowerCase(Locale.ROOT);
    }


}
