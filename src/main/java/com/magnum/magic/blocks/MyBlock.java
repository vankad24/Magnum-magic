package com.magnum.magic.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class MyBlock extends Block {

    String getClassName(){
        return getClass().getSimpleName().toLowerCase().replace("block","_block");
    }

    public MyBlock(Properties properties, String name) {
        super(properties);
        setRegistryName(name);
    }
    public MyBlock(Properties properties) {
        super(properties);
        setRegistryName(getClassName());
    }

    ITextComponent getInfoTextComponent(TextFormatting... format){
        ITextComponent component = new TranslationTextComponent(getTranslationKey()+".info");
        for (int i = 0; i < format.length; i++)
            component.applyTextStyle(format[i]);
        return component;
    }

    ITextComponent getShiftInfoTextComponent(TextFormatting... format){
        ITextComponent component = new TranslationTextComponent("shift.info");
        for (int i = 0; i < format.length; i++)
            component.applyTextStyle(format[i]);
        return component;
    }

}
