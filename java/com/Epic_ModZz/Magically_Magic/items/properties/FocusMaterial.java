package com.Epic_ModZz.Magically_Magic.items.properties;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.init.ModBlocks;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class FocusMaterial extends Item implements IHasModel {

	Block itemglobal = null;
    public FocusMaterial(String string, int max, String Product_Id) {
		setUnlocalizedName(string);
		setRegistryName(string);
		setCreativeTab(CreativeTabs.BREWING);
		ModItems.ITEMS.add(this);
		maxStackSize = max;
		
		if(Product_Id == "sponge") {
			itemglobal = ModBlocks.MAGIC_WATER;
		}
    }
	
	@Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        World world = entityItem.world;
        IBlockState state = world.getBlockState(new BlockPos(MathHelper.floor(entityItem.posX), MathHelper.floor(entityItem.posY-1), MathHelper.floor(entityItem.posZ)));
        if (((state.getBlock() == ModBlocks.MAGIC_WATER && entityItem.getItem().getItem() == ModItems.ENCRYPTED_SPELLBOOK))) {
            ItemStack stack = entityItem.getItem();
            if (!world.isRemote) {
                while (stack.getCount() > 0) {
                        world.spawnEntity(new EntityItem(world, entityItem.posX, entityItem.posY, entityItem.posZ, new ItemStack(itemglobal)));
                        world.playSound(null, entityItem.posX, entityItem.posY, entityItem.posZ, SoundEvents.BLOCK_END_GATEWAY_SPAWN, entityItem.getSoundCategory(), 0.8F, 0.8F + entityItem.world.rand.nextFloat() * 0.4F);
                        stack.shrink(1);
                }
            }
        }
        return super.onEntityItemUpdate(entityItem);
    }    
    
    
	
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}

}
