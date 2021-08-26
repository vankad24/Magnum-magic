package com.magnum.magic.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.List;

public class LampBlock extends MyBlock{


    public LampBlock() {
        super(Properties.create((new Material.Builder(MaterialColor.OBSIDIAN)).build(),
                        MaterialColor.OBSIDIAN)
                .sound(SoundType.SNOW)
                .lightValue(15)
                .harvestTool(ToolType.SHOVEL)
                .hardnessAndResistance(0.5f));
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(Screen.hasShiftDown()) tooltip.add(getInfoTextComponent(TextFormatting.DARK_PURPLE));
        else tooltip.add(getShiftInfoTextComponent(TextFormatting.BLUE,TextFormatting.ITALIC));
        super.addInformation(stack, worldIn, tooltip, flagIn);
//        new StringTextComponent()
        //Screen.hasShiftDown()
        //InputMappings.isKeyDown
        //чекнуть самый низ файла, там все клавиши
    }
}
