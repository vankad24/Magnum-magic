package com.magic.magic;


import com.magic.magic.blocks.LampBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = MainMagic.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TutBlocks
{
    private static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MainMagic.MOD_ID);

    public static final RegistryObject<Block> IDEAL = BLOCKS.register("ideal",  LampBlock::new);

    public static void register()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();
        TutBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .filter(block -> !(block instanceof INonItem))
                .forEach(block -> {
                    final Item.Properties prop = new Item.Properties();
                    final BlockItem blockItem = new BlockItem(block, prop);
                    blockItem.setRegistryName(block.getRegistryName());
                    registry.register(blockItem);
                });
    }
}