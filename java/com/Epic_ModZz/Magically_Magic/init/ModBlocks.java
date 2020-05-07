package com.Epic_ModZz.Magically_Magic.init;

import java.util.ArrayList;
import java.util.List;

import com.Epic_ModZz.Magically_Magic.blocks.BlockBase;
import com.Epic_ModZz.Magically_Magic.blocks.BlockCaytalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.BlockContainerMagicSponge;
import com.Epic_ModZz.Magically_Magic.blocks.BlockFluid;
import com.Epic_ModZz.Magically_Magic.blocks.BlockNoOre;
import com.Epic_ModZz.Magically_Magic.blocks.properties.BlockFocus;
import com.Epic_ModZz.Magically_Magic.items.ItemBase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();


	public static final Block PARADOXITE_ORE = new BlockBase("Paradoxite_Ore",Material.IRON);
	public static final Block MAGIC_BLOCK = new BlockBase("Magic_Essense_Block",Material.IRON);
	public static final Block SMOOTH_MAGIC_BLOCK = new BlockNoOre("Smooth_Essense_Block",Material.IRON);
	public static final Block MAGIC_WATER = new BlockFluid("magical_solution",FluidInit.MAGIC_WATER,Material.WATER);

	public static final Block MAGIC_CHANNELING_FOCUS = new BlockFocus("Basic_Focus_Block",Material.IRON);
	public static final Block CAYTALIST_CREATOR = new BlockCaytalistCreator("Block_Energies_distributer", Material.ROCK);
	public static final Block Magic_Sponge = new BlockContainerMagicSponge("Block_Sponge", Material.SPONGE);

}
