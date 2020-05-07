package com.Epic_ModZz.Magically_Magic.blocks.tileentity;

import com.Epic_ModZz.Magically_Magic.blocks.BlockCaytalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.recipies.CaytalistCreatorRecipies;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityCayalistCreator extends TileEntity implements ITickable{

	private ItemStack Smelting = ItemStack.EMPTY;
	private ItemStackHandler handler = new ItemStackHandler(4);
	public String customName;
	
	private int fuelTime;
	private int currentfuelTime;
	private int createTime;
	private int totalCreateTime;
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
		else return false;
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.handler;
		return super.getCapability(capability, facing);
	}
	
	public boolean hasCustomName() 
	{
		return this.customName != null && !this.customName.isEmpty();
	}
	
	public void setCustomName(String customName) 
	{
		this.customName = customName;
	}
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentTranslation("container.sintering_furnace");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.fuelTime = compound.getInteger("BurnTime");
		this.createTime = compound.getInteger("CookTime");
		this.fuelTime = compound.getInteger("CookTimeTotal");
		this.currentfuelTime = getItemBurnTime((ItemStack)this.handler.getStackInSlot(2));
		
		if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		compound.setInteger("BurnTime", (short)this.fuelTime);
		compound.setInteger("CookTime", (short)this.createTime);
		compound.setInteger("CookTimeTotal", (short)this.fuelTime);
		compound.setTag("Inventory", this.handler.serializeNBT());
		
		if(this.hasCustomName()) compound.setString("CustomName", this.customName);
		return compound;
	}
	
	public boolean isBurning() 
	{
		return this.fuelTime > 0;
	}
	
	@SideOnly(Side.CLIENT)
	public static boolean isBurning(TileEntityCayalistCreator te) 
	{
		return te.getField(0) > 0;
	}
	
	public void update() 
	{	
		if(this.isBurning())
		{
			--this.fuelTime;
			BlockCaytalistCreator.setState(true, world, pos);
		}
		
		ItemStack[] inputs = new ItemStack[] {handler.getStackInSlot(0), handler.getStackInSlot(1)};
		ItemStack fuel = this.handler.getStackInSlot(2);
		
		if(this.isBurning() || !fuel.isEmpty() && !this.handler.getStackInSlot(0).isEmpty() || this.handler.getStackInSlot(1).isEmpty())
		{
			if(!this.isBurning() && this.canSmelt())
			{
				this.fuelTime = getItemBurnTime(fuel);
				this.currentfuelTime = fuelTime;
				
				if(this.isBurning() && !fuel.isEmpty())
				{
					Item item = fuel.getItem();
					fuel.shrink(1);
					
					if(fuel.isEmpty())
					{
						ItemStack item1 = item.getContainerItem(fuel);
						this.handler.setStackInSlot(2, item1);
					}
				}
			}
		}
		
		if(this.isBurning() && this.canSmelt() && createTime > 0)
		{
			createTime++;
			if(createTime == fuelTime)
			{
				if(handler.getStackInSlot(3).getCount() > 0)
				{
					handler.getStackInSlot(3).grow(1);
				}
				else
				{
					handler.insertItem(3, Smelting, false);
				}
				
				Smelting = ItemStack.EMPTY;
				createTime = 0;
				return;
			}
		}
		else
		{
			if(this.canSmelt() && this.isBurning())
			{
				ItemStack output = CaytalistCreatorRecipies.getInstance().getCaytalistResult(inputs[0], inputs[1]);
				if(!output.isEmpty())
				{
					Smelting = output;
					createTime++;
					inputs[0].shrink(1);
					inputs[1].shrink(1);
					handler.setStackInSlot(0, inputs[0]);
					handler.setStackInSlot(1, inputs[1]);
				}
			}
		}
	}
	
	private boolean canSmelt() 
	{
		if(((ItemStack)this.handler.getStackInSlot(0)).isEmpty() || ((ItemStack)this.handler.getStackInSlot(1)).isEmpty()) return false;
		else 
		{
			ItemStack result = CaytalistCreatorRecipies.getInstance().getCaytalistResult((ItemStack)this.handler.getStackInSlot(0), (ItemStack)this.handler.getStackInSlot(1));	
			if(result.isEmpty()) return false;
			else
			{
				ItemStack output = (ItemStack)this.handler.getStackInSlot(3);
				if(output.isEmpty()) return true;
				if(!output.isItemEqual(result)) return false;
				int res = output.getCount() + result.getCount();
				return res <= 64 && res <= output.getMaxStackSize();
			}
		}
	}
	
	public static int getItemBurnTime(ItemStack fuel) 
	{
		if(fuel.isEmpty()) return 0;
		else 
		{
			Item item = fuel.getItem();

			if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR) 
			{
				Block block = Block.getBlockFromItem(item);

				if (block == Blocks.STONE) return 125;
			}
			return GameRegistry.getFuelValue(fuel);
		}
	}
		
	public static boolean isItemFuel(ItemStack fuel)
	{
		return getItemBurnTime(fuel) > 0;
	}
	
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public int getField(int id) 
	{
		switch(id) 
		{
		case 0:
			return this.fuelTime;
		case 1:
			return this.currentfuelTime;
		case 2:
			return this.createTime;
		case 3:
			return this.fuelTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) 
	{
		switch(id) 
		{
		case 0:
			this.fuelTime = value;
			break;
		case 1:
			this.currentfuelTime = value;
			break;
		case 2:
			this.createTime = value;
			break;
		case 3:
			this.fuelTime = value;
		}
	}
}
