package com.drastic.palaclone.init;

import java.util.ArrayList;
import java.util.List;

import com.drastic.palaclone.objects.blocks.BlockCobbleBreaker;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit
{
    public static List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block COBBLE_BREAKER = new BlockCobbleBreaker("cobblebreaker", Material.ROCK);
}
