package com.magnum.magic;

import com.magnum.magic.blocks.LampBlock;
import com.magnum.magic.blocks.MagicOreBlock;
import com.magnum.magic.blocks.MagicStoneBlock;
import com.magnum.magic.items.MagicDustItem;
import com.magnum.magic.items.MyItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(MainMagic.MOD_ID)
public class MainMagic {

    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "magmagic";
    public static final String NAME = "";
    public static final String VERSION = "1.0";

    MyItem dust;
    MagicItemGroup magicItemGroup = new MagicItemGroup("magicGroup");



    public MainMagic() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        //Blocks
        Register.goToRegistration(new LampBlock(), magicItemGroup);
        Register.goToRegistration(new MagicStoneBlock(), magicItemGroup);
        Register.goToRegistration(new MagicOreBlock(),magicItemGroup);


        //Items
        Register.goToRegistration(dust = new MagicDustItem(magicItemGroup));


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
