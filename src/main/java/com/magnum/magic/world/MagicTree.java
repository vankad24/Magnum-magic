package com.magnum.magic.world;

import net.minecraft.block.Block;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class MagicTree extends Tree {
    static TreeFeatureConfig magicTreeConfig;

    public static void createConfig(Block log, Block leaves, SaplingBlock sapling){
        magicTreeConfig = (new TreeFeatureConfig.Builder(
                getProvider(log),
                getProvider(leaves),
                new BlobFoliagePlacer(2,0))
                .baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines()
                .setSapling(sapling)).build();
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(magicTreeConfig);
    }

    static SimpleBlockStateProvider getProvider(Block block){
        return new SimpleBlockStateProvider(block.getDefaultState());
    }
}
