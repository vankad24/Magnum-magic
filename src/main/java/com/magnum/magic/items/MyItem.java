package com.magnum.magic.items;

import com.magnum.magic.MainMagic;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class MyItem extends Item {

    String getClassName(){
        return getClass().getSimpleName().toLowerCase().replace("item","_item");
    }

    public MyItem(Properties properties, String name) {
        super(properties.group(MainMagic.magicItemGroup));
        setRegistryName(name);
    }
    public MyItem(Properties properties) {
        super(properties.group(MainMagic.magicItemGroup));
        setRegistryName(getClassName());
    }

    public boolean isClient(World world){
        return world.isRemote;
    }

    ITextComponent getShiftInfoTextComponent(TextFormatting... format){
        ITextComponent component = new TranslationTextComponent("shift.info");
        for (int i = 0; i < format.length; i++)
            component.applyTextStyle(format[i]);
        return component;
    }
}
