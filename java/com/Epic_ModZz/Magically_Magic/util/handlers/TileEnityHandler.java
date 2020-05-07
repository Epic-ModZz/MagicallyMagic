package com.Epic_ModZz.Magically_Magic.util.handlers;

import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityCayalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityMagicSponge;
import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEnityHandler {

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityMagicSponge.class, new ResourceLocation(Reference.MOD_ID + ":magic_sponge"));
		GameRegistry.registerTileEntity(TileEntityCayalistCreator.class, new ResourceLocation(Reference.MOD_ID + ":cayalist_creator"));

	}
}
