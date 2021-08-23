package com.magnum.magic;

import com.magnum.magic.blocks.MyBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = MainMagic.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Register {
    private static ArrayList<Item> items = new ArrayList<>();
    private static ArrayList<Block> blocks = new ArrayList<>();

    public static void goToRegistration(Item item){
        items.add(item);
    }

    public static void goToRegistration(MyBlock block, ItemGroup group){
        blocks.add(block);
        goToRegistration(new BlockItem(block,new Item.Properties().group(group)).setRegistryName(block.getRegistryName()));
    }


    @SubscribeEvent
    public static void registerItem(final RegistryEvent.Register<Item> event){
        event.getRegistry().registerAll(items.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void registerBlock(final RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(blocks.toArray(new Block[0]));
    }
}
