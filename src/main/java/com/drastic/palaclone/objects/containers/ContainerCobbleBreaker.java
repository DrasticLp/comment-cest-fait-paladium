package com.drastic.palaclone.objects.containers;

import com.drastic.palaclone.init.BlockInit;
import com.drastic.palaclone.objects.blocks.BlockCobbleBreaker;
import com.drastic.palaclone.objects.tileentities.TileEntityCobbleBreaker;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerCobbleBreaker extends Container
{
    private final TileEntityCobbleBreaker tileentity;
    private int cookTime, totalCookTime;

    public ContainerCobbleBreaker(InventoryPlayer player, TileEntityCobbleBreaker tileentity)
    {
        this.tileentity = tileentity;
        IItemHandler handler = this.tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        this.addSlotToContainer(new SlotItemHandler(handler, 0, 22, 36));
        this.addSlotToContainer(new SlotItemHandler(handler, 1, 76, 37));
        this.addSlotToContainer(new SlotItemHandler(handler, 2, 97, 37));
        this.addSlotToContainer(new SlotItemHandler(handler, 3, 118, 37));
        this.addSlotToContainer(new SlotItemHandler(handler, 4, 139, 37));
        this.addSlotToContainer(new SlotItemHandler(handler, 5, 86, 57));
        this.addSlotToContainer(new SlotItemHandler(handler, 6, 107, 57));
        this.addSlotToContainer(new SlotItemHandler(handler, 7, 128, 57));

        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 9; x++)
            {
                this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for(int x = 0; x < 9; x++)
        {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
        }
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); i++)
        {
            IContainerListener listener = (IContainerListener)this.listeners.get(i);

            if(this.cookTime != this.tileentity.getField(0))
                listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
            if(this.totalCookTime != this.tileentity.getField(1))
                listener.sendWindowProperty(this, 1, this.tileentity.getField(1));
        }

        if(this.tileentity.getBlock() == BlockInit.COBBLE_BREAKER)
        {
            ((BlockCobbleBreaker)this.tileentity.getBlock()).stack0 = this.inventorySlots.get(0).getStack();
            ((BlockCobbleBreaker)this.tileentity.getBlock()).stack1 = this.inventorySlots.get(1).getStack();
            ((BlockCobbleBreaker)this.tileentity.getBlock()).stack2 = this.inventorySlots.get(2).getStack();
            ((BlockCobbleBreaker)this.tileentity.getBlock()).stack3 = this.inventorySlots.get(3).getStack();
            ((BlockCobbleBreaker)this.tileentity.getBlock()).stack4 = this.inventorySlots.get(4).getStack();
            ((BlockCobbleBreaker)this.tileentity.getBlock()).stack5 = this.inventorySlots.get(5).getStack();
            ((BlockCobbleBreaker)this.tileentity.getBlock()).stack6 = this.inventorySlots.get(6).getStack();
            ((BlockCobbleBreaker)this.tileentity.getBlock()).stack7 = this.inventorySlots.get(7).getStack();
        }

        this.cookTime = this.tileentity.getField(0);
        this.totalCookTime = this.tileentity.getField(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tileentity.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.tileentity.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        return stack;
    }
}
