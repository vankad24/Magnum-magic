package com.magnum.magic;

import com.magnum.magic.blocks.*;
import com.magnum.magic.items.*;
import com.magnum.magic.world.MagicTree;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(MainMagic.MOD_ID)
public class MainMagic {

    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "magmagic";
    public static final String NAME = "";
    public static final String VERSION = "1.0";

    MyItem dust;
    MagicSaplingBlock sapling;

    public static MagicItemGroup magicItemGroup;


    public MainMagic() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);

        magicItemGroup = new MagicItemGroup("magicGroup");

        //-------------Blocks-------------
        Register.goToRegistration(new LampBlock());
        Register.goToRegistration(new MagicStoneBlock());
        Register.goToRegistration(new MagicPlanksBlock());


        MagicLogBlock log = new MagicLogBlock();
        sapling = new MagicSaplingBlock();
        MagicLeavesBlock leaves = new MagicLeavesBlock();
        MagicTree.createConfig(log,leaves,sapling);

        Register.goToRegistration(log);
        Register.goToRegistration(sapling);
        Register.goToRegistration(leaves);

        Register.goToRegistration(new MagicOreBlock());

        //-------------Items-------------
        Register.goToRegistration(dust = new MagicDustItem());
        Register.goToRegistration(new GoldenStaffItem());
        Register.goToRegistration(new MagicStickItem());
        Register.goToRegistration(new MagicCrystalItem());
        Register.goToRegistration(new FrozenStaffItem());

    }

    @SubscribeEvent
    public void craft(final PlayerEvent.ItemCraftedEvent event){
        MainMagic.LOGGER.debug("Craft");

        ItemStack stack = event.getInventory().getStackInSlot(4);
        MainMagic.LOGGER.debug(stack.getItem().getClass().getSimpleName());
        if (stack.getItem() instanceof Staff){
            int newLevel = stack.getTag().getInt("level")+1;
            if (newLevel==5)newLevel=4;
            MainMagic.LOGGER.debug(newLevel+"");
            Staff.levelUpStaff(event.getCrafting(),newLevel);

        }



    }

    /* The FMLCommonSetupEvent (FML - Forge Mod Loader)
    * (Recipes)
    */
    private void setup(final FMLCommonSetupEvent event){

    }

    /*
     * ClientSetup, this registers things we want on the client side that the
     * server doesn't really care about, like rendering layers and other stuff.
     */
    private void clientSetup(final FMLClientSetupEvent event){
        RenderTypeLookup.setRenderLayer(sapling, RenderType.getCutout());
    }

    public class MagicItemGroup extends ItemGroup{
        public MagicItemGroup(String name) {
            super(name);
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(dust);
        }
    }

}
