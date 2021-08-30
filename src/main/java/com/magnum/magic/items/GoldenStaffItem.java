package com.magnum.magic.items;

import com.magnum.magic.MainMagic;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class GoldenStaffItem extends Staff{
    public GoldenStaffItem() {
        super(new Item.Properties(),"golden_staff");

    }



    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        ItemStack stack = context.getItem();
        BlockPos pos = context.getPos();
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();

        MainMagic.LOGGER.debug(pos.getX()+" "+pos.getY()+" "+pos.getZ());




        world.playSound(player, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 1F);
        player.getCooldownTracker().setCooldown(this, 20);

        CompoundNBT tag = stack.getTag();
        int level = tag.getInt("level");
        if (isClient(world)){
            player.sendMessage(new StringTextComponent("Magic "+level+" level!"));
        }
        makeMagic(Blocks.GOLD_BLOCK,world,pos,level-1);

//        EnderPearlItem
//        FlintAndSteelItem
        //зачарования:
        //пылесборник, радиус, магическая острота
        return ActionResultType.SUCCESS;
    }


}
