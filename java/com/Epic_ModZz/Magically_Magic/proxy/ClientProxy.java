package com.Epic_ModZz.Magically_Magic.proxy;

import com.Epic_ModZz.Magically_Magic.entity.SkyBolt;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.Reference;
import com.Epic_ModZz.Magically_Magic.util.handlers.RenderHandlers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename,  String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), id));
	}
	
	@Override
	public void render() {
		RenderingRegistry.registerEntityRenderingHandler(SkyBolt.class, new RenderSnowball<SkyBolt>(Minecraft.getMinecraft().getRenderManager(), ModItems.ITEM_SKY_SWORD, Minecraft.getMinecraft().getRenderItem()));
		
	}
	
	
}
