package com.drastic.palaclone.objects.items;

import com.drastic.palaclone.objects.items.base.ItemBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemVoidStone extends ItemBase
{
    private boolean active = false;
    
    public ItemVoidStone(String name)
    {
        super(name);
        this.setCreativeTab(CreativeTabs.MISC);
    }
    
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public boolean isActive() 
    {
        return this.active;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if(!worldIn.isRemote)
        {
            this.setActive(!this.active);
            
            if(this.isActive())
            {
                playerIn.sendMessage(new TextComponentString("§aVous venez d'activer votre VoidStone"));
            }
            else
            {
                playerIn.sendMessage(new TextComponentString("§cVous venez de désactiver votre VoidStone"));   
            }
        }
        
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
