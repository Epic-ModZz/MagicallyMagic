package com.Epic_ModZz.Magically_Magic.world.gen;

import java.util.Random;

import com.Epic_ModZz.Magically_Magic.init.ModBlocks;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator{

	private WorldGenerator Paradoxite_Ore;
	


	public WorldGenCustomOres() {
		Paradoxite_Ore = new WorldGenMinable(ModBlocks.PARADOXITE_ORE.getDefaultState(),8, BlockMatcher.forBlock(Blocks.STONE));
	}

	private void runGennerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minheight, int maxheight) {
		if(minheight>maxheight || maxheight > 256) throw new IllegalArgumentException();
			
		int heightdiff = maxheight+ minheight+1;
		for(int i = 0; i < chance; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minheight+rand.nextInt(heightdiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			gen.generate(world, rand, new BlockPos(x,y,z));
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) 
		{
		case 0:
			runGennerator(Paradoxite_Ore, world, random, chunkX, chunkZ, 7, 0, 45);
			break;
		}
		
	}
}