package com.magnum.magic.items;

import com.magnum.magic.MainMagic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Iterator;

public class FrozenStaffItem extends Staff{
    public FrozenStaffItem() {
        super(new Properties(),"frozen_staff");
        transformToBlock = Blocks.SNOW_BLOCK;
    }



    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        ItemStack stack = context.getItem();
        BlockPos pos = context.getPos();
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();

        MainMagic.LOGGER.debug(pos.getX()+" "+pos.getY()+" "+pos.getZ());




        player.getCooldownTracker().setCooldown(this, 20);

        CompoundNBT tag = stack.getTag();
        int level = tag.getInt("level");
        if (isClient(world)){
            player.sendMessage(new StringTextComponent("Magic "+level+" level!"));
        }
//        new Thread(()->makeMagic(Blocks.GOLD_BLOCK,world,pos,player,level-1)).start();
        makeMagic(world,pos,player,level);

//        EnderPearlItem
//        FlintAndSteelItem
        //зачарования:
        //пылесборник, радиус, магическая острота
        return ActionResultType.SUCCESS;
    }


    @Override
    void makeMagic(World world, BlockPos centerBlock, PlayerEntity player, int staffLevel) {
        new Thread(()->{
            HashSet<BlockPos> validBlocks = new HashSet<>();
            validBlocks.add(centerBlock);
            for (int i = 0; i < staffLevel; i++) {
                Iterator<BlockPos> iterator = validBlocks.iterator();
                HashSet<BlockPos> temp = new HashSet<>();
                boolean playSound = false;
                while (iterator.hasNext()){
                    BlockPos pos = iterator.next();
                    BlockState state = world.getBlockState(pos);
                    if (state.getBlock()!= transformToBlock) {
                        playSound = true;
                        if (state.getBlock()==Blocks.GRASS_BLOCK && canSetSnow(world.getBlockState(pos.up())))world.setBlockState(pos.up(), Blocks.SNOW.getDefaultState());
                        else if (state.getMaterial()==Material.WATER)world.setBlockState(pos, Blocks.ICE.getDefaultState());
                        else if (state.getMaterial()==Material.LAVA)world.setBlockState(pos, Blocks.STONE.getDefaultState());
                        else if (state.getBlock()!=Blocks.ICE)world.setBlockState(pos, transformToBlock.getDefaultState());
                        for (int y = -1; y <= 1; y++) {
                            for (int x = -1; x <= 1; x++) {
                                for (int z = -1; z <= 1; z++) {
                                    addIfValid(temp,pos.add(x,y,z),world);
                                }
                            }
                        }
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

    @Override
    boolean isNotSolid(World world, BlockPos pos){
        Material material = world.getBlockState(pos).getMaterial();
        return material == Material.AIR;
    }

    boolean canSetSnow(BlockState state){
        return state.getMaterial()== Material.AIR||state.getBlock() instanceof IGrowable;
    }
}
