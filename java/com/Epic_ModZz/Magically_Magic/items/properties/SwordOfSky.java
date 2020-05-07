package com.Epic_ModZz.Magically_Magic.items.properties;

import com.Epic_ModZz.Magically_Magic.Main;
import com.Epic_ModZz.Magically_Magic.entity.SkyBolt;
import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.Epic_ModZz.Magically_Magic.util.IHasModel;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SwordOfSky extends ItemBow implements IHasModel{

	private float attackDamage;
    private final Item.ToolMaterial material;
	
	
	public SwordOfSky(String name, Item.ToolMaterial material)
	{
        this.material = material;
        this.attackDamage = material.getAttackDamage();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BREWING);
		maxStackSize = 1;
		ModItems.ITEMS.add(this);
		this.setFull3D();
        this.attackDamage = 3.0F;
	}
	
	
    protected boolean isArrow(ItemStack stack)
    {
        return true;
    }
	

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}	

@Override
public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

	ItemStack stack = playerIn.getHeldItem(handIn);
	Vec3d look = playerIn.getLookVec();
    SkyBolt SkyBolt = new  SkyBolt(worldIn, playerIn);
    SkyBolt.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);    
	worldIn.spawnEntity(SkyBolt);
	worldIn.playSound(null, playerIn.getPosition(), SoundEvents.ENTITY_FIREWORK_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F);
	if(playerIn.capabilities.isCreativeMode) {
			
	}else {
		playerIn.getHeldItem(handIn).damageItem(1, playerIn);
	}
	return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}	


	public float getAttackDamage()
	{
		
	    return this.material.getAttackDamage();
	}

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
	
}

 
