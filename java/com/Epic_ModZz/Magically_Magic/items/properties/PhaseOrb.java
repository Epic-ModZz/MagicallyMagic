package com.Epic_ModZz.Magically_Magic.items.properties;

import java.util.List;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.MagicPlayerAbilities.PhaseProvider;
import com.Epic_ModZz.Magically_Magic.PlayerInfo.PhaseInfo;
import com.Epic_ModZz.Magically_Magic.entity.EntityShade;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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
import net.minecraftforge.fml.common.Mod.EventHandler;

public class PhaseOrb extends Item implements IHasModel{

	public PhaseOrb(String name)
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
	
	//int noclipcount = 0;
	//int multi;
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		PhaseInfo State = playerIn.getCapability(PhaseProvider.PHASE, null);
		State.phase();
		if(playerIn.capabilities.isFlying) {
			playerIn.capabilities.isFlying = false;
			playerIn.capabilities.allowFlying = false;
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}


}




/*
private boolean CastIllusion(EntityLiving entity, EntityPlayer caster){

	
    Vec3d vec3d = caster.getLook(1.0F).normalize();
    Vec3d vec3d1 = new Vec3d(entity.posX - caster.posX, entity.getEntityBoundingBox().minY + (double)entity.getEyeHeight() - (caster.posY + (double)caster.getEyeHeight()), entity.posZ - caster.posZ);
    double d0 = vec3d1.lengthVector();
    vec3d1 = vec3d1.normalize();
    double d1 = vec3d.dotProduct(vec3d1);
    return d1 > 1.0D - 0.025D / d0 ? caster.canEntityBeSeen(entity) : false;

}

}



if(playerIn.isSneaking()) {
    List<EntityLiving> entities = worldIn.getEntitiesWithinAABB(EntityLiving.class, new AxisAlignedBB(playerIn.getPosition().getX()-5, playerIn.getPosition().getY()-10, playerIn.getPosition().getZ()-5, playerIn.getPosition().getX()+5, playerIn.getPosition().getY()+10, playerIn.getPosition().getZ()+5));
    for (EntityLiving entity : entities) {
    	if(!entity.getIsInvulnerable() && CastIllusion(entity, playerIn)) {
        	if(entity.noClip == true) {
        		entity.noClip = false;
        	}else {
        		entity.noClip = true;
        	}
    		break;
    	}
    }
}else {
	if(Math.random() >= .5) {
		multi = -1;
	}
	if(Math.random() <= .5) {
		multi = 1;
	}
	if(noclipcount == 0 || noclipcount == 1) {
		playerIn.setEntityBoundingBox(playerIn.getEntityBoundingBox().contract(playerIn.getEntityBoundingBox().maxX, playerIn.getEntityBoundingBox().maxY, playerIn.getEntityBoundingBox().maxZ));
		//playerIn.attemptTeleport(playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
		noclipcount++;
	}
	if(noclipcount != 0 || noclipcount != 1){
		playerIn.setEntityBoundingBox(playerIn.getEntityBoundingBox().expand(playerIn.getEntityBoundingBox().minX, playerIn.getEntityBoundingBox().minY, playerIn.getEntityBoundingBox().minZ));    		
		noclipcount = 0;
	}
	
}
*/