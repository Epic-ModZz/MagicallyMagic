package com.Epic_ModZz.Magically_Magic.blocks.tileentity;

import com.Epic_ModZz.Magically_Magic.blocks.properties.ContainerMagicSponge;
import com.Epic_ModZz.Magically_Magic.util.Reference;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;

public class TileEntityMagicSponge extends TileEntityLockableLoot implements ITickable{

	private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>withSize(72, ItemStack.EMPTY);
	public int numPlayersUsing, tickSinceSync;
	
	
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 72;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		for(ItemStack stack : this.chestContents) {
			if(!stack.isEmpty()) return false;
				
			}
		return true;
		}
	

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.hasCustomName() ?  this.customName : "container.magic_sponge";
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		this.chestContents = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
		
		if(!this.checkLootAndRead(compound)) ItemStackHelper.loadAllItems(compound, chestContents);
		if(compound.hasKey("CustomName", 8))this.customName = compound.getString("CustomName");
	}
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		if(!this.checkLootAndWrite(compound)) ItemStackHelper.saveAllItems(compound, chestContents);
		if(compound.hasKey("CustomName")) compound.setString("CustomName", this.customName);
		
		return compound;
	}
	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return new ContainerMagicSponge(playerInventory, this,playerIn);
	}
	
	public String getGuiId() {
		return Reference.MOD_ID + ":magic_sponge";
	}
	
	@Override
	protected NonNullList<ItemStack> getItems() {
		// TODO Auto-generated method stub
		return this.chestContents;
	}
	
	
	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		super.openInventory(player);
		++this.numPlayersUsing;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayersUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}
	
	
	@Override
	public void closeInventory(EntityPlayer player) {
		--this.numPlayersUsing;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayersUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}


	@Override
	public String getGuiID() {
		// TODO Auto-generated method stub
		return Reference.MOD_ID + ": magicsponge";
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}


	
	