package com.drastic.palaclone.objects.items.base;

import com.drastic.palaclone.Main;
import com.drastic.palaclone.init.ItemInit;
import com.drastic.palaclone.util.interfaces.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name)
    {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        ItemInit.ITEMS.add(this);
    }
    
    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
