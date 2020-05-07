package com.Epic_ModZz.Magically_Magic.items.properties;

import java.util.HashMap;
import java.util.Map;

import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiSpellBook<NextPageButton> extends GuiScreen{
	private final int bookImageHeight = 192;
	private final int bookImageWidth = 192;
	private int currPage = 0;
	private static final int bookTabnum = 4;
    private static ResourceLocation[] bookPageTextures = 
            new ResourceLocation[bookTabnum*4];
      private static String[] stringPageText = new String[bookTabnum];
      private GuiButton buttonDone;
      private NextPageButton buttonNextPage;
      private NextPageButton buttonPreviousPage;
      
	public GuiSpellBook() {
		bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID+"");
	}
	public static final Map<String,String> notes = new HashMap<>();
	

	@Override
	public final void initGui() {
		super.initGui();
	}
}
