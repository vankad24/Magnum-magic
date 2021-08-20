package com.magic.magic;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


@Mod.EventBusSubscriber(modid = MainMagic.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
class MyModEventSubscriber {
    @SubscribeEvent
    static void onCommonSetup(FMLCommonSetupEvent event) {


    }
}

@Mod(MainMagic.MOD_ID)
public class MainMagic {
    public static final String MOD_ID = "magmagic";
    public static final String NAME = "";
    public static final String VERSION = "1.0";

    //@Mod.Instance
    public static ExampleMod instance;

    @SidedProxy(clientSide = "com.example.examplemod.CommonProxy",serverSide = "com.example.examplemod.ClientProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("\u001B[32m" + "[Starting Test Mod PRE-INITIALIZATION]" + "\u001B[0m");
        BlocksRegister.register();
//        GameRegistry.addShapedRecipe(new ResourceLocation("po_2"), new ResourceLocation("po_2"),new ItemStack(BlocksRegister.LAMP, 1), new Object [ ] {
//                "A  ", "A  ", "B  ", 'A', Blocks.STONE, 'B', Blocks.TORCH});
        registerRecipe("lamp");
        MinecraftForge.EVENT_BUS.register(new Sounds());

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("\u001B[32m" + "[Starting Test Mod INITIALIZATION]" + "\u001B[0m");


    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("\u001B[32m" + "[Starting Test Mod POST-INITIALIZATION]" + "\u001B[0m");
        Minecraft.getMinecraft()
                .effectRenderer
                .registerParticle(EnumParticleTypes.END_ROD.getParticleID(),new MyParticles());
    }



}
