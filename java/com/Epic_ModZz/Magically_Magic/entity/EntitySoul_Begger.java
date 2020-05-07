package com.Epic_ModZz.Magically_Magic.entity;

import java.util.Set;

import javax.annotation.Nullable;

import com.Epic_ModZz.Magically_Magic.init.ModItems;
import com.google.common.collect.Sets;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntitySoul_Begger extends EntityPig {
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(ModItems.MAGIC_ESSENSE);

	public EntitySoul_Begger(World worldIn) {
		super(worldIn);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.BLOCK_NOTE_BELL;

	}
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.BLOCK_NOTE_CHIME;

	}
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_GHAST_WARN;

	}	
    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableList.EMPTY;
    }

    
    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 10D));
        this.tasks.addTask(2, new EntityAITempt(this, 2.5D, false, TEMPTATION_ITEMS));
       //this.tasks.addTask(3, new EntityAIAvoidEntity(null, EntityPlayer.class, 10F, 2D, 3.5D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    
    @Override
    public void onStruckByLightning(EntityLightningBolt lightningBolt) {
		
	}
    
}