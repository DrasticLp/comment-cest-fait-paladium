package com.drastic.palaclone.util.handlers;

import com.drastic.palaclone.objects.items.ItemVoidStone;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemPickupEvent;

@EventBusSubscriber
public class EventHandler
{
    @SubscribeEvent
    public static void onItemPickup(EntityItemPickupEvent e)
    {
        if(e.getItem().getItem().getItem() == Item.getItemFromBlock(Blocks.COBBLESTONE))
        {
            EntityPlayer p = e.getEntityPlayer();

            boolean hasItem = false;

            for(int i = 0; i < 35; i++)
            {
                ItemStack s = p.inventory.getStackInSlot(i);
                
                if(s.getItem() instanceof ItemVoidStone)
                {
                    ItemVoidStone voidStone = (ItemVoidStone)s.getItem();

                    if(voidStone.isActive())
                        hasItem = true;
                }
            }

            ItemStack s1 = p.getHeldItem(EnumHand.OFF_HAND);

            if(s1.getItem() instanceof ItemVoidStone)
            {

                ItemVoidStone voidStone = (ItemVoidStone)s1.getItem();

                if(voidStone.isActive())
                    hasItem = true;

            }

            if(hasItem)
            {
                e.setCanceled(true);
                e.getItem().setDead();
            }
        }
    }
}
