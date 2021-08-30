package com.magnum.magic.items;

import com.magnum.magic.MainMagic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Staff extends MyItem{
    public Staff(Properties properties, String name) {
        super(properties.maxStackSize(1), name);
    }

    Block transformToBlock;
    HashMap<Block, Block> blockHashMap;


    public static void levelUpStaff(ItemStack stack, int level){
        CompoundNBT tag = new CompoundNBT();
        stack.setTag(tag);
        tag.putInt("level",level);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!stack.hasTag()) {
            MainMagic.LOGGER.debug("new nbt");
            CompoundNBT tag = new CompoundNBT();
            stack.setTag(tag);
            tag.putInt("level",1);
        }
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        MainMagic.LOGGER.debug("create ");
        if (!stack.hasTag()) {
            MainMagic.LOGGER.debug("new nbt");
            CompoundNBT tag = new CompoundNBT();
            stack.setTag(tag);
            tag.putInt("level",1);

        }
//        ShulkerBoxBlock
//        SaplingBlock
        super.onCreated(stack, worldIn, playerIn);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (stack.hasTag()) {
            if (Screen.hasShiftDown()) {
                tooltip.add(new TranslationTextComponent("level")
                        .appendText(" "+ stack.getTag().getInt("level")).applyTextStyle(TextFormatting.DARK_PURPLE));
            } else tooltip.add(getShiftInfoTextComponent(TextFormatting.BLUE));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    void makeMagic(World world, BlockPos centerBlock, PlayerEntity player, int staffLevel){
        new Thread(()->{
            HashSet<BlockPos> validBlocks = new HashSet<>();
            validBlocks.add(centerBlock);
            for (int i = 0; i < staffLevel; i++) {
                Iterator<BlockPos> iterator = validBlocks.iterator();
                HashSet<BlockPos> temp = new HashSet<>();
                boolean playSound = false;
                while (iterator.hasNext()){
                    BlockPos pos = iterator.next();
                    if (world.getBlockState(pos).getBlock()!= transformToBlock) {
                        playSound = true;
                        world.setBlockState(pos, transformToBlock.getDefaultState());
                        for (int y = -1; y <= 1; y++) {
                            for (int x = -1; x <= 1; x++) {
                                for (int z = -1; z <= 1; z++) {
                                    addIfValid(temp,pos.add(x,y,z),world);
                                }
                            }
                        }
                       /* addIfValid(temp,pos.south(),centerBlock,staffLevel,world);
                        addIfValid(temp,pos.north(),centerBlock,staffLevel,world);
                        addIfValid(temp,pos.west(),centerBlock,staffLevel,world);
                        addIfValid(temp,pos.east(),centerBlock,staffLevel,world);
                        addIfValid(temp,pos.up(),centerBlock,staffLevel,world);
                        addIfValid(temp,pos.down(),centerBlock,staffLevel,world);*/

                    }
                    validBlocks = temp;
                }
                if (playSound)world.playSound(player, centerBlock, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 1F);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();

    }

    void addIfValid(HashSet<BlockPos> set, BlockPos pos, World world){
        if (!set.contains(pos)&&!isNotSolid(world,pos)){
            if (isNotSolid(world,pos.south())|| isNotSolid(world,pos.north())||
                    isNotSolid(world,pos.west())|| isNotSolid(world,pos.east())||
                    isNotSolid(world,pos.up()) || isNotSolid(world,pos.down()))set.add(pos);
        }
    }

    boolean isNotSolid(World world, BlockPos pos){
        Material material = world.getBlockState(pos).getMaterial();
        return material == Material.AIR||material==Material.WATER||material==Material.LAVA;
    }

    boolean isAir(World world, BlockPos pos){
        return world.getBlockState(pos).getMaterial() == Material.AIR;
    }


    void makeMagicOld(Block to, World world, BlockPos centerBlock, PlayerEntity player, int staffLevel){
//        MainMagic.LOGGER.debug();
//        BoneMealItem

        int diameter = staffLevel * 2 + 1;
        BlockPos pos;
        for (int y = 0; y < diameter; y++) {
            for (int z = 0; z < diameter; z++) {
                for (int x = 0; x < diameter; x++) {
                    pos = new BlockPos(centerBlock.getX()-staffLevel+x,
                            centerBlock.getY()-staffLevel+y,
                            centerBlock.getZ()-staffLevel+z);
                    if (getDistance(centerBlock, pos) <= staffLevel) transformBlock(to, world, pos);
                }
            }
            world.playSound(player, centerBlock, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 1F);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    int getDistance(BlockPos pos1,BlockPos pos2){
        return Math.abs(pos1.getX()-pos2.getX())+
                Math.abs(pos1.getY()-pos2.getY())+
                Math.abs(pos1.getZ()-pos2.getZ());
    }

    void transformBlock(Block to, World world, BlockPos pos){
        BlockState state = world.getBlockState(pos);
        if (state.getMaterial()!= Material.AIR && state.getBlock()!=to){
            world.setBlockState(pos,to.getDefaultState(),11);
        }
    }


}
