package com.magnum.magic.items;

import com.magnum.magic.MainMagic;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GoldenStaffItem extends Staff{
    public GoldenStaffItem() {
        super(new Item.Properties(),"golden_staff");
        transformToBlock = Blocks.GOLD_BLOCK;
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


}
