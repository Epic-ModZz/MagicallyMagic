package com.Epic_ModZz.Magically_Magic.blocks;

import java.util.Random;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityCayalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityMagicSponge;
import com.Epic_ModZz.Magically_Magic.init.ModBlocks;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;
import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCaytalistCreator extends Block implements IHasModel, ITileEntityProvider{

	public static final PropertyBool ACTIVE = PropertyBool.create("active");
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public BlockCaytalistCreator(String name,Material materialin) {
		super(materialin);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setSoundType(SoundType.STONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE,false));
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote) {
			playerIn.openGui(Main.instance, Reference.GUI_ENERGIES_IMBUER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
		

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");


	}	
	
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,ItemStack stack) {
	
		worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityCayalistCreator();
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.CAYTALIST_CREATOR);
		
	}
	
	@Override
	public ItemStack getItem(World worldin, BlockPos pos, IBlockState state) {
		return new ItemStack(ModBlocks.CAYTALIST_CREATOR);
		
	}
	
	
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if(!worldIn.isRemote) {
			IBlockState north = worldIn.getBlockState(pos.north());
			IBlockState south = worldIn.getBlockState(pos.south());
			IBlockState east = worldIn.getBlockState(pos.east());
			IBlockState west = worldIn.getBlockState(pos.west());
			EnumFacing face =  (EnumFacing)state.getValue(FACING);
			
			
			if(face == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) face = EnumFacing.SOUTH; 
			if(face == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) face = EnumFacing.NORTH; 
			if(face == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) face = EnumFacing.SOUTH; 
			if(face == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) face = EnumFacing.NORTH; 			
			worldIn.setBlockState(pos,state.withProperty(FACING, face),2);
			
			
			
		}
	}
	
	
	public static void setState(boolean active, World worldin,BlockPos pos) {
		IBlockState state = worldin.getBlockState(pos);
		TileEntity tileentity = worldin.getTileEntity(pos);
		
		if(active) worldin.setBlockState(pos, ModBlocks.CAYTALIST_CREATOR.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, true), 3);
		else worldin.setBlockState(pos, ModBlocks.CAYTALIST_CREATOR.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(ACTIVE, false), 3);
		
		if(tileentity != null) {
			tileentity.validate();
			worldin.setTileEntity(pos, tileentity);
		}
	}
	
@Override
public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
		float hitZ, int meta, EntityLivingBase placer) {
	// TODO Auto-generated method stub
	return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(ACTIVE, false);
	}

@Override
public EnumBlockRenderType getRenderType(IBlockState state) {
	// TODO Auto-generated method stub
	return EnumBlockRenderType.MODEL;
	}

@Override
protected BlockStateContainer createBlockState() {
	return new BlockStateContainer(this, new IProperty[] {ACTIVE,FACING});
	
}

@Override
public int getMetaFromState(IBlockState state) 
{
	return ((EnumFacing)state.getValue(FACING)).getIndex();
	
}	


@Override
public IBlockState withRotation(IBlockState state, Rotation rot) {
	// TODO Auto-generated method stub
	return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
}



@Override
public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
	// TODO Auto-generated method stub
	return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
}


@Override
public IBlockState getStateFromMeta(int meta) {
	EnumFacing facing = EnumFacing.getFront(meta);
	if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
	return this.getDefaultState().withProperty(FACING, facing);
	
}



/*
 * onblockplacedby code
 * 	if(stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if(tileentity instanceof TileEntityMagicSponge) {
				((TileEntityMagicSponge)tileentity).setCustomName(stack.getDisplayName());
			}
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
 */

}

