package com.Epic_ModZz.Magically_Magic.world.gen;

import java.util.List;

import com.Epic_ModZz.Magically_Magic.entity.EntityShade;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.network.play.server.SPacketCombatEvent.Event;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

	

public class ShadowsInNether {
	
	public static List<String> allowedBlocks;
	
	  public void init() {
		    Biome.SpawnListEntry ShadeEntry = new Biome.SpawnListEntry(EntityShade.class, 4, 1, 5);
		    BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER).forEach(biome -> biome.getSpawnableList(EnumCreatureType.MONSTER).add(ShadeEntry));
	  }
	  
	  
	  
	  @SubscribeEvent
	  public void onSpawn(LivingSpawnEvent.CheckSpawn event) {
		  
		  
		  System.out.println("SHADE SPOAWn");
		  
		  
		  /*
		   * 
		   * 
		   * 
	  if(event.getEntityLiving() instanceof EntityShade && (event.getEntityLiving()).world instanceof WorldServer) {
		  
		  
	  }
	  		EntityShade Shade = (EntityShade)event.getEntityLiving();
	  		WorldServer world = (WorldServer)Shade.getDisplayName();
	  		BlockPos pos = Shade.getPosition();
	        Block block = (Block) world.getBlockState(pos.up((int)(Math.random()*10)));

	        ResourceLocation res = block.getRegistryName();
	        
	        boolean allowedBlock = allowedBlocks.contains(res.toString());
	        
	  }
	  */}
}

