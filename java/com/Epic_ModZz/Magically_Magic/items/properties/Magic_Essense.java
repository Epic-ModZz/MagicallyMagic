package com.Epic_ModZz.Magically_Magic.items.properties;

import java.util.Timer;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.init.ModBlocks;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;

import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class Magic_Essense extends Item implements IHasModel{
	
    public Magic_Essense(String string) {
		// TODO Auto-generated constructor stub
		setUnlocalizedName(string);
		setRegistryName(string);
		setCreativeTab(CreativeTabs.BREWING);
		ModItems.ITEMS.add(this);
		maxStackSize = 1;
		
    }
    

	@Override
    public boolean onEntityItemUpdate(EntityItem entityItem) {
        World world = entityItem.world;
        IBlockState state = world.getBlockState(new BlockPos(MathHelper.floor(entityItem.posX), MathHelper.floor(entityItem.posY), MathHelper.floor(entityItem.posZ)));
        if (((state.getBlock() == ModBlocks.MAGIC_WATER && entityItem.getItem().getItem() == ModItems.ENCRYPTED_SPELLBOOK))) {
            ItemStack stack = entityItem.getItem();
            if (!world.isRemote) {
                while (stack.getCount() > 0) {
                		world.createExplosion(null, entityItem.posX, entityItem.posY, entityItem.posZ, 5, true);
                        world.spawnEntity(new EntityItem(world, entityItem.posX, entityItem.posY, entityItem.posZ, new ItemStack(ModItems.AWAKENED_SPELLBOOK)));
                        world.playSound(null, entityItem.posX, entityItem.posY, entityItem.posZ, SoundEvents.BLOCK_END_GATEWAY_SPAWN, entityItem.getSoundCategory(), 0.8F, 0.8F + entityItem.world.rand.nextFloat() * 0.4F);
                        stack.shrink(1);
                }
            }
        }
        return super.onEntityItemUpdate(entityItem);
    }



	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		playerIn.sendMessage(new TextComponentString("The book is binded with powerful magic maybe if you exposed the book to more magic, you might be able to open it"));
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
