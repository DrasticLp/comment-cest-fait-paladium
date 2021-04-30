package com.drastic.palaclone.init;

import java.util.ArrayList;
import java.util.List;

import com.drastic.palaclone.objects.items.ItemParticle;
import com.drastic.palaclone.objects.items.ItemVoidStone;
import com.drastic.palaclone.objects.items.base.ItemBase;

import net.minecraft.item.Item;

public class ItemInit
{
    public static List<Item> ITEMS = new ArrayList<Item>();
    
    public static final Item VOIDSTONE = new ItemVoidStone("voidstone");

    public static final Item PARTICLE_IRON = new ItemParticle("iron_particle");
    public static final Item PARTICLE_GOLD = new ItemParticle("gold_particle");
    public static final Item PARTICLE_DIAMOND = new ItemParticle("diamond_particle");
    public static final Item PARTICLE_AMETHYST = new ItemParticle("amethyst_particle");
    public static final Item PARTICLE_TITANE = new ItemParticle("titane_particle");
    public static final Item PARTICLE_PALADIUM = new ItemParticle("paladium_particle");
}
