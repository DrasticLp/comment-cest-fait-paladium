package com.drastic.palaclone.util.handlers;

import com.drastic.palaclone.objects.tileentities.TileEntityCobbleBreaker;
import com.drastic.palaclone.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityCobbleBreaker.class, new ResourceLocation(Reference.MODID + ":cobblebreaker"));
    }
}
