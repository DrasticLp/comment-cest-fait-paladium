package com.drastic.palaclone.objects.guis;

import com.drastic.palaclone.objects.containers.ContainerCobbleBreaker;
import com.drastic.palaclone.objects.tileentities.TileEntityCobbleBreaker;
import com.drastic.palaclone.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCobbleBreaker extends GuiContainer
{
    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/cobblebreaker.png");
    private final InventoryPlayer player;
    private final TileEntityCobbleBreaker tileentity;

    public GuiCobbleBreaker(InventoryPlayer player, TileEntityCobbleBreaker tileentity)
    {
        super(new ContainerCobbleBreaker(player, tileentity));
        this.player = player;
        this.tileentity = tileentity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
    {
        String tileName = this.tileentity.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) + 3, 8, 4210752);
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 122, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        
        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(this.guiLeft + 44, this.guiTop + 36, 176, 14, l + 1, 16);
    }
    
    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileentity.getField(0);
        int j = this.tileentity.getField(1);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
