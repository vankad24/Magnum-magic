package com.magic.magic;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


@Mod.EventBusSubscriber(modid = MainMagic.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
class MyModEventSubscriber {
    public MyModEventSubscriber() {
        BlockRegister.register();
    }

    @SubscribeEvent
    static void onCommonSetup(FMLCommonSetupEvent event) {

//   /give @p magmagic:lampblock
    }
}

@Mod(MainMagic.MOD_ID)
public class MainMagic {
    public static final String MOD_ID = "magmagic";
    public static final String NAME = "";
    public static final String VERSION = "1.0";

    //@Mod.Instance
//    public static ExampleMod instance;

//    @SidedProxy(clientSide = "com.example.examplemod.CommonProxy",serverSide = "com.example.examplemod.ClientProxy")
//    public static CommonProxy proxy;



}
