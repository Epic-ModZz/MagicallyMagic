package com.Epic_ModZz.Magically_Magic.util.handlers;

import org.w3c.dom.css.Counter;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.entity.EntityShade;
import com.Epic_ModZz.Magically_Magic.init.CapabilityInit;
import com.Epic_ModZz.Magically_Magic.init.EntityInit;
import com.Epic_ModZz.Magically_Magic.init.FluidInit;
import com.Epic_ModZz.Magically_Magic.init.ModBlocks;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;
import com.Epic_ModZz.Magically_Magic.util.Reference;
import com.Epic_ModZz.Magically_Magic.world.gen.WorldGenCustomOres;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		TileEnityHandler.registerTileEntities();
	} 
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			} 
		}
		
	}
	
	public static void preInitRegistries() {
		System.out.print("Testing Error");
		FluidInit.registerFluids();
		EntityInit.registerEntities();
		RenderHandlers.registerCustomMeshesAndStates();
		RenderHandlers.registerEntityRenders();
		

	}
	
	public static void initRegistries() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		Main.proxy.render();
		Biome.SpawnListEntry ShadeEntry = new Biome.SpawnListEntry(EntityShade.class, 4, 1, 5);
	    BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).forEach(biome -> biome.getSpawnableList(EnumCreatureType.MONSTER).add(ShadeEntry));
	}
	
	public static void otherRegistries() {
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
		CapabilityInit.init();
		}
	
	
}
 