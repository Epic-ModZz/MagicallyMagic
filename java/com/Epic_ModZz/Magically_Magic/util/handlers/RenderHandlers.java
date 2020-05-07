package com.Epic_ModZz.Magically_Magic.util.handlers;

import com.Epic_ModZz.Magically_Magic.entity.EntityShade;
import com.Epic_ModZz.Magically_Magic.entity.EntitySoul_Begger;
import com.Epic_ModZz.Magically_Magic.entity.render.RenderShade;
import com.Epic_ModZz.Magically_Magic.entity.render.RenderSoul_Begger;
import com.Epic_ModZz.Magically_Magic.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandlers {
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityShade.class, new IRenderFactory<EntityShade>() 
		{

			@Override
			public Render<? super EntityShade> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderShade(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntitySoul_Begger.class, new IRenderFactory<EntitySoul_Begger>() 
		{

			@Override
			public Render<? super EntitySoul_Begger> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderSoul_Begger(manager);
			}
		});
	}
	
	public static void registerCustomMeshesAndStates(){
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.MAGIC_WATER), new ItemMeshDefinition(){
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("magi:magical_solution", "fluid");
			}
		});
		ModelLoader.setCustomStateMapper(ModBlocks.MAGIC_WATER, new StateMapperBase() {
			
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("magi:magical_solution", "fluid");
			}
		});
	}
}
