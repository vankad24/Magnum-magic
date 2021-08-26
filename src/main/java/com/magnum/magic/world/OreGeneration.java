package com.magnum.magic.world;

import com.magnum.magic.blocks.MyOreBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {

    public static void setupOreGeneration(MyOreBlock block){
        for(Biome biome: ForgeRegistries.BIOMES){
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                            block.getDefaultState(),block.max_vine )).withPlacement(
                            Placement.COUNT_RANGE.configure(new CountRangeConfig(block.countInChunk,block.bottomOffset,block.topOffset, block.maxHeight))));
        }
    }

}
