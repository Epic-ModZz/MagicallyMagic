package com.Epic_ModZz.Magically_Magic.items.properties;

import java.util.List;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.entity.EntityShade;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class IllusionistsOrb extends Item implements IHasModel{

	public IllusionistsOrb(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BREWING);
		ModItems.ITEMS.add(this);
		maxStackSize = 1;

	}
	

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
@Override
public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
	// TODO Auto-generated method stub
	
    List<EntityPlayer> entities = worldIn.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ(), playerIn.getPosition().getX()+10, playerIn.getPosition().getY()+10, playerIn.getPosition().getZ()+10));
    for (EntityPlayer entity : entities) {
    	if(CastIllusion(entity, playerIn) && !entity.capabilities.isCreativeMode) {
    		
    		break;
    	}
    }
	return super.onItemRightClick(worldIn, playerIn, handIn);
}


private boolean CastIllusion(EntityPlayer player, EntityPlayer caster){

	
        Vec3d vec3d = caster.getLook(1.0F).normalize();
        Vec3d vec3d1 = new Vec3d(player.posX - caster.posX, player.getEntityBoundingBox().minY + (double)player.getEyeHeight() - (caster.posY + (double)caster.getEyeHeight()), player.posZ - caster.posZ);
        double d0 = vec3d1.lengthVector();
        vec3d1 = vec3d1.normalize();
        double d1 = vec3d.dotProduct(vec3d1);
        return d1 > 1.0D - 0.025D / d0 ? caster.canEntityBeSeen(player) : false;
    
}



}
