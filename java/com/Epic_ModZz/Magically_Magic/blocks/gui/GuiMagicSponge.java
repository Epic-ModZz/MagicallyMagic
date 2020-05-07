package com.Epic_ModZz.Magically_Magic.blocks.gui;

import com.Epic_ModZz.Magically_Magic.blocks.properties.ContainerMagicSponge;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityMagicSponge;
import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiMagicSponge extends GuiContainer{

	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MOD_ID + ":textures/gui/magic_spongegui.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityMagicSponge te;
	
	public GuiMagicSponge(InventoryPlayer playerInventory, TileEntityMagicSponge chestInventory, EntityPlayer player) {
		super(new ContainerMagicSponge(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 179;
		this.ySize = 256;
	
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);		
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
		this.fontRenderer.drawString(this.te.getDisplayName().getFormattedText(), 8, 6, 16086784);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize-92, 16086784);
	}
	

}
