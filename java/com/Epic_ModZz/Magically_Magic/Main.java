package com.Epic_ModZz.Magically_Magic;

import com.Epic_ModZz.Magically_Magic.PlayerInfo.PhaseInfo;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityMagicSponge;
import com.Epic_ModZz.Magically_Magic.entity.EntityShade;
import com.Epic_ModZz.Magically_Magic.init.EntityInit;
import com.Epic_ModZz.Magically_Magic.proxy.CommonProxy;
import com.Epic_ModZz.Magically_Magic.util.Reference;
import com.Epic_ModZz.Magically_Magic.util.handlers.PhaseHandler;
import com.Epic_ModZz.Magically_Magic.util.handlers.PhaseManager;
import com.Epic_ModZz.Magically_Magic.util.handlers.RegistryHandler;
import com.Epic_ModZz.Magically_Magic.util.handlers.RenderHandlers;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	static { FluidRegistry.enableUniversalBucket(); }
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		RenderHandlers.registerEntityRenders();	
		RegistryHandler.preInitRegistries();
		RegistryHandler.otherRegistries();
		
		
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event) 
	{
		RegistryHandler.initRegistries();
		
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		
	}	

}


