package com.magnum.magic.blocks;

import net.minecraft.block.OreBlock;

public class MyOreBlock extends OreBlock {
    public int max_vine;//размер жилы
    public int countInChunk;//количество в чанке
    public int bottomOffset;//расстояние до бедрока
    public int topOffset;//расстояние до поверхности
    public int maxHeight;//максимальная высота спавна

    public MyOreBlock(Properties properties, String name) {
        super(properties);
        setRegistryName(name);
    }

    public void setProperties(int max_vine, int countInChunk, int bottomOffset, int topOffset, int maxHeight){
        this.max_vine = max_vine;
        this.countInChunk = countInChunk;
        this.bottomOffset = bottomOffset;
        this.topOffset = topOffset;
        this.maxHeight = maxHeight;
    }
}
