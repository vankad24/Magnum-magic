package com.magnum.magic.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class MagicDustItem  extends MyItem{

    public MagicDustItem(ItemGroup group) {
        super(new Item.Properties().group(group), "magic_dust_item");
    }
}
