package com.drastic.palaclone.objects.items;

import com.drastic.palaclone.objects.items.base.ItemBase;

import net.minecraft.creativetab.CreativeTabs;

public class ItemParticle extends ItemBase
{

    public ItemParticle(String name)
    {
        super(name);
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }

}
