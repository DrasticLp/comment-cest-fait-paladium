package com.drastic.palaclone.objects.tileentities;

import java.util.Random;

import com.drastic.palaclone.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityCobbleBreaker extends TileEntity implements ITickable
{
    public ItemStackHandler handler = new ItemStackHandler(8);
    private String customName;

    private int cookTime = 0, totalCookTime = 200;

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
    }

    public Block getBlock()
    {
        return world.getBlockState(this.pos).getBlock();
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return (T)this.handler;
        return super.getCapability(capability, facing);
    }

    public boolean hasCustomName()
    {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentTranslation("container.cobblebreaker");
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        this.handler.deserializeNBT(compound.getCompoundTag("Inventoy"));
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("TotalCookTime");

        if(compound.hasKey("CustomName", 8))
            this.setCustomName(compound.getString("CustomName"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("TotalCookTime", (short)this.totalCookTime);
        compound.setTag("Inventory", this.handler.serializeNBT());

        if(this.hasCustomName())
            compound.setString("CustomName", this.customName);

        return compound;
    }

    @Override
    public void update()
    {
        ItemStack input = this.handler.getStackInSlot(0);

        if(this.cookTime > 0)
        {

            if(this.canSmelt())
            {
                this.cookTime++;

                if(this.cookTime == this.totalCookTime)
                {
                    input.shrink(1);

                    Random r = new Random();

                    boolean shouldOutput = r.nextInt(3) == 0;

                    if(shouldOutput)
                    {
                        int output = r.nextInt(7);
                        
                        output++;
                        
                        if(this.handler.getStackInSlot(output).getCount() != 64)
                        {
                            this.addItemStackFromId(output);
                        }
                    }
                    this.cookTime = 0;
                    return;
                }
            }
            else
                this.cookTime = 0;
        }
        else
        {
            if(this.canSmelt())
                this.cookTime++;
        }
    }

    public boolean isUsableByPlayer(EntityPlayer p)
    {
        return this.world.getTileEntity(this.pos) != this ? false : p.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    private void addItemStackFromId(int id)
    {
        switch(id)
        {
            case 1:
                if(!this.handler.getStackInSlot(id).isEmpty())
                {
                    if(this.handler.getStackInSlot(id).getItem() == ItemInit.PARTICLE_IRON)
                        this.handler.getStackInSlot(id).setCount(this.handler.getStackInSlot(id).getCount() + 1);
                }
                else
                    this.handler.setStackInSlot(id, new ItemStack(ItemInit.PARTICLE_IRON));
                break;
            case 2:
                if(!this.handler.getStackInSlot(id).isEmpty())
                {
                    if(this.handler.getStackInSlot(id).getItem() == ItemInit.PARTICLE_GOLD)
                        this.handler.getStackInSlot(id).setCount(this.handler.getStackInSlot(id).getCount() + 1);
                }
                else
                    this.handler.setStackInSlot(id, new ItemStack(ItemInit.PARTICLE_GOLD));
                break;
            case 3:
                if(!this.handler.getStackInSlot(id).isEmpty())
                {
                    if(this.handler.getStackInSlot(id).getItem() == ItemInit.PARTICLE_DIAMOND)
                        this.handler.getStackInSlot(id).setCount(this.handler.getStackInSlot(id).getCount() + 1);
                }
                else
                    this.handler.setStackInSlot(id, new ItemStack(ItemInit.PARTICLE_DIAMOND));
                break;
            case 4:
                if(!this.handler.getStackInSlot(id).isEmpty())
                {
                    if(this.handler.getStackInSlot(id).getItem() == ItemInit.PARTICLE_AMETHYST)
                        this.handler.getStackInSlot(id).setCount(this.handler.getStackInSlot(id).getCount() + 1);
                }
                else
                    this.handler.setStackInSlot(id, new ItemStack(ItemInit.PARTICLE_AMETHYST));
                break;
            case 5:
                if(!this.handler.getStackInSlot(id).isEmpty())
                {
                    if(this.handler.getStackInSlot(id).getItem() == ItemInit.PARTICLE_TITANE)
                        this.handler.getStackInSlot(id).setCount(this.handler.getStackInSlot(id).getCount() + 1);
                }
                else
                    this.handler.setStackInSlot(id, new ItemStack(ItemInit.PARTICLE_TITANE));
                break;
            case 6:
                if(!this.handler.getStackInSlot(id).isEmpty())
                {
                    if(this.handler.getStackInSlot(id).getItem() == ItemInit.PARTICLE_PALADIUM)
                        this.handler.getStackInSlot(id).setCount(this.handler.getStackInSlot(id).getCount() + 1);
                }
                else
                    this.handler.setStackInSlot(id, new ItemStack(ItemInit.PARTICLE_PALADIUM));
                break;
            case 7:
                if(!this.handler.getStackInSlot(id).isEmpty())
                {
                    if(this.handler.getStackInSlot(id).getItem() == Items.FLINT)
                        this.handler.getStackInSlot(id).setCount(this.handler.getStackInSlot(id).getCount() + 1);
                }
                else
                    this.handler.setStackInSlot(id, new ItemStack(Items.FLINT));
                break;
        }

    }

    private boolean canSmelt()
    {
        if(!this.handler.getStackInSlot(0).isEmpty() && this.handler.getStackInSlot(0).getItem() == Item.getItemFromBlock(Blocks.COBBLESTONE))
        {
            int fulledStacks = 0;

            if(this.handler.getStackInSlot(1).getCount() == 64)
                fulledStacks++;
            if(this.handler.getStackInSlot(2).getCount() == 64)
                fulledStacks++;
            if(this.handler.getStackInSlot(3).getCount() == 64)
                fulledStacks++;
            if(this.handler.getStackInSlot(4).getCount() == 64)
                fulledStacks++;
            if(this.handler.getStackInSlot(5).getCount() == 64)
                fulledStacks++;
            if(this.handler.getStackInSlot(6).getCount() == 64)
                fulledStacks++;
            if(this.handler.getStackInSlot(7).getCount() == 64)
                fulledStacks++;

            if(fulledStacks < 7)
                return true;
        }
        return false;
    }

    public int getField(int id)
    {
        switch(id)
        {
            case 0:
                return this.cookTime;
            case 1:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch(id)
        {
            case 0:
                this.cookTime = value;
                break;
            case 1:
                this.totalCookTime = value;
        }
    }
}
