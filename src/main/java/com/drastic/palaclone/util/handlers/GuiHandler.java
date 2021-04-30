package com.drastic.palaclone.util.handlers;

import com.drastic.palaclone.objects.containers.ContainerCobbleBreaker;
import com.drastic.palaclone.objects.guis.GuiCobbleBreaker;
import com.drastic.palaclone.objects.tileentities.TileEntityCobbleBreaker;
import com.drastic.palaclone.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.COBBLE_BREAKER)
            return new ContainerCobbleBreaker(player.inventory, (TileEntityCobbleBreaker)world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.COBBLE_BREAKER)
            return new GuiCobbleBreaker(player.inventory, (TileEntityCobbleBreaker)world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }
}
