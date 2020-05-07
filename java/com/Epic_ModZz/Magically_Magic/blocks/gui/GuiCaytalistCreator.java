package com.Epic_ModZz.Magically_Magic.blocks.gui;

import com.Epic_ModZz.Magically_Magic.blocks.properties.ContainerBlockCaytalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.properties.ContainerMagicSponge;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityCayalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityMagicSponge;
import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiCaytalistCreator extends GuiContainer{

	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MOD_ID + ":textures/gui/caytalist_creator.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityCayalistCreator te;
	
	public GuiCaytalistCreator(InventoryPlayer playerInventory, TileEntityCayalistCreator chestInventory) {
		super(new ContainerBlockCaytalistCreator(playerInventory,chestInventory));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if(TileEntityCayalistCreator.isBurning(te))
		{
			int k = this.getBurnLeftScaled(13);
			this.drawTexturedModalRect(this.guiLeft + 8, this.guiTop + 54 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		
		int l = this.getCookProgressScaled(24);
		this.drawTexturedModalRect(this.guiLeft + 44, this.guiTop + 36, 176, 14, l + 1, 16);
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
		this.fontRenderer.drawString(this.te.getDisplayName().getFormattedText(), 8, 6, 16086784);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize-92, 16086784);
	}
	
	private int getBurnLeftScaled(int pixels)
	{
		int i = this.te.getField(1);
		if(i == 0) i = 200;
		return this.te.getField(0) * pixels / i;
	}
	
	private int getCookProgressScaled(int pixels)
	{
		int i = this.te.getField(2);
		int j = this.te.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
}
