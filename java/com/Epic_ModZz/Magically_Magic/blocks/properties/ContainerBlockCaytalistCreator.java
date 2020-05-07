package com.Epic_ModZz.Magically_Magic.blocks.properties;

import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityCayalistCreator;
import com.Epic_ModZz.Magically_Magic.blocks.tileentity.TileEntityMagicSponge;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBlockCaytalistCreator extends Container{
	private final TileEntityCayalistCreator chestInventory;
	private int createTime, totalCreateTime, fuelTime, currentfuelTime;




	public ContainerBlockCaytalistCreator(InventoryPlayer player, TileEntityCayalistCreator chestInventory2) {
		this.chestInventory = chestInventory2;
		IItemHandler handler = chestInventory.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);		

		this.addSlotToContainer(new SlotItemHandler(handler, 0, 26, 11));
		this.addSlotToContainer(new SlotItemHandler(handler, 1, 26, 59));
		this.addSlotToContainer(new SlotItemHandler(handler, 2, 7, 35));
		this.addSlotToContainer(new SlotItemHandler(handler, 3, 81, 36));
		
		for(int y = 0; y < 3; y++)
		{
			for(int x = 0; x < 9; x++)
			{
				this.addSlotToContainer(new Slot(player, x + y*9 + 9, 8 + x*18, 84 + y*18));
			}
		}
		
		for(int x = 0; x < 9; x++)
		{
			this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) 
	{
		this.chestInventory.setField(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return this.chestInventory.isUsableByPlayer(playerIn);
	}
	
	
	
	@Override
	public void detectAndSendChanges() 
	{
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.listeners.size(); ++i) 
		{
			IContainerListener listener = (IContainerListener)this.listeners.get(i);
			
			if(this.createTime != this.chestInventory.getField(2)) listener.sendWindowProperty(this, 2, this.chestInventory.getField(2));
			if(this.fuelTime != this.chestInventory.getField(0)) listener.sendWindowProperty(this, 0, this.chestInventory.getField(0));
			if(this.currentfuelTime != this.chestInventory.getField(1)) listener.sendWindowProperty(this, 1, this.chestInventory.getField(1));
			if(this.totalCreateTime != this.chestInventory.getField(3)) listener.sendWindowProperty(this, 3, this.chestInventory.getField(3));
		}
		
		this.createTime = this.chestInventory.getField(2);
		this.fuelTime = this.chestInventory.getField(0);
		this.currentfuelTime = this.chestInventory.getField(1);
		this.totalCreateTime = this.chestInventory.getField(3);
	}

}
