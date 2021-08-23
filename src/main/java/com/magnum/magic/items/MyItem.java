package com.magnum.magic.items;

import net.minecraft.item.Item;

public class MyItem extends Item {

    public MyItem(Properties properties, String name) {
        super(properties);
        setRegistryName(name);
    }
    public MyItem(Properties properties) {
        super(properties);
        setRegistryName(getClass().getSimpleName().toLowerCase());
    }
}
