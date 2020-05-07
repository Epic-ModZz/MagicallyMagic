package com.Epic_ModZz.Magically_Magic.items.properties;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.init.ModBlocks;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SpruceStaff extends Item implements IHasModel{

	
	
    public SpruceStaff(String string) {
		// TODO Auto-generated constructor stub
		setUnlocalizedName(string);
		setRegistryName(string);
		setCreativeTab(CreativeTabs.BREWING);
		ModItems.ITEMS.add(this);
		maxStackSize = 1;	
		this.setFull3D();
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		
		playerIn.sendMessage(new TextComponentString(""));
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
