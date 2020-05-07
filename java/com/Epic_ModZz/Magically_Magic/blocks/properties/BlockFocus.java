package com.Epic_ModZz.Magically_Magic.blocks.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityMagicSponge;
import com.Epic_ModZz.Magically_Magic.init.FluidInit;
import com.Epic_ModZz.Magically_Magic.init.ModBlocks;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;

import it.unimi.dsi.fastutil.ints.IntStack;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.WorldCapabilityData;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;


public class BlockFocus extends Block implements IHasModel{
	
	
    private Item item = null; 
	public static AxisAlignedBB BASIC_FOCUS_AABB = new AxisAlignedBB(0D, 0, 0D, 1D, 0.375D, 1D);
	
	
	
	public BlockFocus(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		setSoundType(SoundType.METAL);
		setHardness(25);
		setResistance(3000);
		setHarvestLevel("pickaxe", 0);
		setLightLevel(0F);
		}

	

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BASIC_FOCUS_AABB;
	}
	ItemStack Magic_orb = new ItemStack(ModItems.ORB_OF_CHANNELING);
	ItemStack glass = new ItemStack(Blocks.GLASS);
	ItemStack fireworkstar = new ItemStack(Items.FIREWORK_CHARGE);
	ItemStack Caytalist = new ItemStack(ModItems.CAYTALIST);
	ItemStack DiamondSword = new ItemStack(Items.DIAMOND_SWORD);
	ItemStack MSword1 = new ItemStack(ModItems.ITEM_SKY_SWORD);
	ItemStack Purifiedes = new ItemStack(ModItems.PURIFIED_MAGIC_ESSENSE);

@Override
public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

	if(!playerIn.isSneaking()) {
		if(worldIn.getBlockState(pos.down(1)) == ModBlocks.Magic_Sponge.getDefaultState()) {	

            List<EntityItem> entities = worldIn.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX()+1,pos.getY() + 1, pos.getZ()+1));
            for (EntityItem entity : entities) {
                TileEntityMagicSponge tileentity = (TileEntityMagicSponge)worldIn.getTileEntity(pos.down());

                if(entity.getItem().getItem() == glass.getItem()) {
                	

                	
                    Item Magma_cream = tileentity.getStackInSlot(0).getItem();
                    Item Magic_Caytalist = tileentity.getStackInSlot(1).getItem();
                    ItemStack stack = entity.getItem();
                    
                    
                    //System.out.println(Magma_cream.getItemById(Magma_cream.getIdFromItem(Magma_cream)) + "!=" + Items.MAGMA_CREAM.getItemById(Items.MAGMA_CREAM.getIdFromItem(Items.MAGMA_CREAM)));

                    if(Magma_cream.getItemById(Magma_cream.getIdFromItem(Magma_cream)) == Items.MAGMA_CREAM.getItemById(Items.MAGMA_CREAM.getIdFromItem(Items.MAGMA_CREAM)) 
                    &&  Magic_Caytalist.getItemById(Magic_Caytalist.getIdFromItem(Magic_Caytalist))== ModItems.CAYTALIST.getItemById(ModItems.CAYTALIST.getIdFromItem(ModItems.CAYTALIST))) {
	                	if(!worldIn.isRemote) {
	                        while (stack.getCount() > 0) {
	                        	EntityItem item = new EntityItem(worldIn, pos.getX()+0.5F, pos.getY()+0.5F, pos.getZ()+0.5F, Magic_orb);
	                			worldIn.spawnEntity(item);
	                    		stack.shrink(1);
	                    		tileentity.removeStackFromSlot(0);
	                    		tileentity.removeStackFromSlot(1);
	                    		worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_FIREWORK_LAUNCH, entity.getSoundCategory(), 0.8F, 0.8F + entity.world.rand.nextFloat() * 0.4F);
                        		}
                        	}
                        }
                	}
                
                if(entity.getItem().getItem() == fireworkstar.getItem()) {
                	
                	
                    Item Magic_Dust = tileentity.getStackInSlot(0).getItem();
                    Item Redstone = tileentity.getStackInSlot(1).getItem();
                    Item Magic_Dust2 = tileentity.getStackInSlot(3).getItem();
                    Item Sugar = tileentity.getStackInSlot(2).getItem();
                    ItemStack stack = entity.getItem();
                	
                    if(Magic_Dust.getItemById(Magic_Dust.getIdFromItem(Magic_Dust)) == ModItems.MAGIC_ESSENSE.getItemById(ModItems.MAGIC_ESSENSE.getIdFromItem(ModItems.MAGIC_ESSENSE)) 
                    && Redstone.getItemById(Redstone.getIdFromItem(Redstone)) == Items.REDSTONE.getItemById(Items.REDSTONE.getIdFromItem(Items.REDSTONE))
                    && Sugar.getItemById(Sugar.getIdFromItem(Sugar)) == Items.SUGAR.getItemById(Items.SUGAR.getIdFromItem(Items.SUGAR))	
                    && Magic_Dust2.getItemById(Magic_Dust2.getIdFromItem(Magic_Dust2)) == ModItems.MAGIC_ESSENSE.getItemById(ModItems.MAGIC_ESSENSE.getIdFromItem(ModItems.MAGIC_ESSENSE))) {
	                	if(!worldIn.isRemote) {
	                        while (stack.getCount() > 0) {
	                        	EntityItem item = new EntityItem(worldIn, pos.getX()+0.5F, pos.getY()+0.5F, pos.getZ()+0.5F, Caytalist);
	                			worldIn.spawnEntity(item);
	                    		stack.shrink(1);
	                    		tileentity.removeStackFromSlot(0);
	                    		tileentity.removeStackFromSlot(1);
	                    		tileentity.removeStackFromSlot(2);
	                    		tileentity.removeStackFromSlot(3);
	                    		worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_FIREWORK_LAUNCH, entity.getSoundCategory(), 0.8F, 0.8F + entity.world.rand.nextFloat() * 0.4F);
                        		}
                        	}
                        }
                	}
                
                if(entity.getItem().getItem() == DiamondSword.getItem()) {
                	

                	
                    Item Air = tileentity.getStackInSlot(0).getItem();
                    Item Magic_Caytalist = tileentity.getStackInSlot(1).getItem();
                    Item Water = tileentity.getStackInSlot(2).getItem();
                    Item Water2 = tileentity.getStackInSlot(3).getItem();               
                    ItemStack stack = entity.getItem();
                    
                    if(Air.getItemById(Air.getIdFromItem(Air)) == ModItems.CAYTALIST_AIR.getItemById(ModItems.CAYTALIST_AIR.getIdFromItem(ModItems.CAYTALIST_AIR)) 
                    &&  Magic_Caytalist.getItemById(Magic_Caytalist.getIdFromItem(Magic_Caytalist))== ModItems.CAYTALIST.getItemById(ModItems.CAYTALIST.getIdFromItem(ModItems.CAYTALIST))
                    && Water.getItemById(Water.getIdFromItem(Water))== ModItems.CAYTALIST_WATER.getItemById(ModItems.CAYTALIST_WATER.getIdFromItem(ModItems.CAYTALIST_WATER))
                    && Water2.getItemById(Water2.getIdFromItem(Water2))== ModItems.CAYTALIST_WATER.getItemById(ModItems.CAYTALIST_WATER.getIdFromItem(ModItems.CAYTALIST_WATER))) {
	                	if(!worldIn.isRemote) {
	                        while (stack.getCount() > 0) {
	                        	EntityItem item = new EntityItem(worldIn, pos.getX()+0.5F, pos.getY()+0.5F, pos.getZ()+0.5F, MSword1);
	                			worldIn.spawnEntity(item);
	                    		stack.shrink(1);
	                    		tileentity.removeStackFromSlot(0);
	                    		tileentity.removeStackFromSlot(1);
	                    		tileentity.removeStackFromSlot(2);
	                    		tileentity.removeStackFromSlot(3);
	                    		worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_FIREWORK_LAUNCH, entity.getSoundCategory(), 0.8F, 0.8F + entity.world.rand.nextFloat() * 0.4F);
                        		}
                        	}
                        }
                	}                
                } 
        	}
		}
	return enableStats;
	}
}


//				EntityItem item = new EntityItem(worldIn, pos.getX()+0.5F, pos.getY(), pos.getZ()+0.5F, glass2);
//				item.setNoPickupDelay();
//	            playerIn.inventory.decrStackSize(playerIn.inventory.getSlotFor(glass2), 1);
//				worldIn.spawnEntity(item);
//ItemStack glass2 = new ItemStack(glass);

	
