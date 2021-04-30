package com.drastic.palaclone.objects.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.drastic.palaclone.Main;
import com.drastic.palaclone.init.BlockInit;
import com.drastic.palaclone.objects.blocks.base.BlockBase;
import com.drastic.palaclone.objects.tileentities.TileEntityCobbleBreaker;
import com.drastic.palaclone.util.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCobbleBreaker extends BlockBase
{
    public ItemStack stack0 = new ItemStack(Blocks.AIR), stack1 = new ItemStack(Blocks.AIR), stack2 = new ItemStack(Blocks.AIR), stack3 = new ItemStack(Blocks.AIR), stack4 = new ItemStack(Blocks.AIR), stack5 = new ItemStack(Blocks.AIR), stack6 = new ItemStack(Blocks.AIR), stack7 = new ItemStack(Blocks.AIR);

    public BlockCobbleBreaker(String name, Material material)
    {
        super(name, material);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(BlockInit.COBBLE_BREAKER);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        this.stack0 = new ItemStack(Blocks.AIR);
        this.stack1 = new ItemStack(Blocks.AIR);
        this.stack2 = new ItemStack(Blocks.AIR);
        this.stack3 = new ItemStack(Blocks.AIR);
        this.stack4 = new ItemStack(Blocks.AIR);
        this.stack5 = new ItemStack(Blocks.AIR);
        this.stack6 = new ItemStack(Blocks.AIR);
        this.stack7 = new ItemStack(Blocks.AIR);
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        List<ItemStack> list = new ArrayList<ItemStack>();
        list.add(this.stack0);
        list.add(this.stack1);
        list.add(this.stack2);
        list.add(this.stack3);
        list.add(this.stack4);
        list.add(this.stack5);
        list.add(this.stack6);
        list.add(this.stack7);
        list.add(new ItemStack(BlockInit.COBBLE_BREAKER));
        return list;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote)
        {
            playerIn.openGui(Main.instance, Reference.COBBLE_BREAKER, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public boolean hasTileEntity()
    {
        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityCobbleBreaker();
    }
}
