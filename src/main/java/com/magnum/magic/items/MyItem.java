package com.magnum.magic.items;

import net.minecraft.item.Item;

public class MyItem extends Item {

    String getClassName(){
        return getClass().getSimpleName().toLowerCase().replace("block","_block");
    }

    public MyItem(Properties properties, String name) {
        super(properties);
        setRegistryName(name);
    }
    public MyItem(Properties properties) {
        super(properties);
        setRegistryName(getClassName());
    }
}
