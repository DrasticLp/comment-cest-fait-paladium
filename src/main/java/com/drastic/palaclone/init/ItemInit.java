package com.drastic.palaclone.init;

import java.util.ArrayList;
import java.util.List;

import com.drastic.palaclone.objects.items.ItemVoidStone;

import net.minecraft.item.Item;

public class ItemInit
{
    public static List<Item> ITEMS = new ArrayList<Item>();
    
    public static final Item VOIDSTONE = new ItemVoidStone("voidstone");
}
