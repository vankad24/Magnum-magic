package com.magnum.magic.blocks;

import net.minecraft.block.Block;

public class MyBlock extends Block {

    public MyBlock(Properties properties, String name) {
        super(properties);
        setRegistryName(name);
    }
    public MyBlock(Properties properties) {
        super(properties);
        setRegistryName(getClass().getSimpleName().toLowerCase());

    }
}
