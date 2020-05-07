package com.Epic_ModZz.Magically_Magic.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SkyBolt extends EntityThrowable{

	public SkyBolt(World worldIn) {
		super(worldIn);
		
	}
	
	public SkyBolt(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		
	}
	
	public SkyBolt(World worldIn, double x, double y, double z) {
		super(worldIn,x,y,z);
		
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onImpact(RayTraceResult result) {
	     if (result.entityHit != null)
	        {
	            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2.0F);
	            result.entityHit.extinguish();
	        }
	     
	 	if(result.entityHit instanceof EntityLivingBase) {
			EntityLivingBase entity =  (EntityLivingBase)result.entityHit;
			entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 120, 2));
		}
	     
	     
	            this.world.setEntityState(this, (byte)3);
	            this.setDead();
	        }

}








/*

if (result.entityHit != null)
{
	result.entityHit.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.thrower), 2.0F);

}

//if (!this.world.isRemote) {
	/*
	if(result.entityHit instanceof EntityLivingBase) {
		EntityLivingBase entity =  (EntityLivingBase)result.entityHit;
		entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this.thrower), rand.nextFloat());
		entity.addVelocity(this.thrower.motionX, this.thrower.motionY, this.thrower.motionZ);
		entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1200, 2));
		entity.moveForward = 2.0F;	
		System.out.println("HELOO");
	}
	*/
//}
//this.world.setEntityState(this, (byte)3);
//this.setDead();

