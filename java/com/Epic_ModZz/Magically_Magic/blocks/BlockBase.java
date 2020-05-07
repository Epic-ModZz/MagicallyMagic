package com.Epic_ModZz.Magically_Magic.blocks;

import java.util.Random;
import java.util.Set;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.init.ModBlocks;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;

import ibxm.Player;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

public class BlockBase extends Block implements IHasModel{
	//blockstate list


	public BlockBase(String name,Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		if(name == "Magic_Essense_Block") {
			setSoundType(SoundType.SNOW);
			setHardness(1);
			setResistance(4);
			setHarvestLevel("shovel", 0);
			setLightLevel(0F);
		}
		if(name == "Paradoxite_Ore" || name == "Smooth_Essense_Block") {
			setSoundType(SoundType.STONE);
			setHardness(3);
			setResistance(15);
			setHarvestLevel("pickaxe", 2);
			setLightLevel(3.0F);
		}
	}


	@Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
    {
		IBlockState para = ModBlocks.PARADOXITE_ORE.getDefaultState();
		IBlockState magic = ModBlocks.MAGIC_BLOCK.getDefaultState();
		if (para == state) {
			dropXpOnBlockBreak(worldIn, pos, 5);
		}
    }
	@Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
		IBlockState para = ModBlocks.PARADOXITE_ORE.getDefaultState();
		IBlockState magic = ModBlocks.MAGIC_BLOCK.getDefaultState();
		if (state == para) {
			return  (int) (5 +(1.5 * fortune));               
		}
		if (state == magic) {
			return  4;               
		}
    return 1;
	}	
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");


	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		IBlockState para = ModBlocks.PARADOXITE_ORE.getDefaultState();
		IBlockState magic = ModBlocks.MAGIC_BLOCK.getDefaultState();
		IBlockState smooth = ModBlocks.SMOOTH_MAGIC_BLOCK.getDefaultState();
		if(state == para) {

		return ModItems.MAGIC_ESSENSE;
		}
		if(state == magic) {
		return ModItems.MAGIC_ESSENSE;
		}		
		return null;
	}	
}






/*
		for(int x = -5; x < 6; x++) {
			for(int z = -3; z < 4; z++) {
				for(int y = -5; y < 21; y++) {
					boolean flag = y ==17 || y < 8 && y > 4;
					boolean flag1 = y == 16 || y == 18 || y ==8 || y == 4;
					if(z == -3 || z == 3) {
						if(x > -5 && x < 5) {
							System.out.print(para);
							worldIn.setBlockState(pos.add(x, y, z), state);
						}
					}
				}
			}
		}
*/