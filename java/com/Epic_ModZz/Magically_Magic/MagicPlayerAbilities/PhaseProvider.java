package com.Epic_ModZz.Magically_Magic.MagicPlayerAbilities;

import com.Epic_ModZz.Magically_Magic.PlayerInfo.PhaseInfo;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PhaseProvider implements ICapabilitySerializable<NBTBase>{

	 @CapabilityInject(PhaseInfo.class)
	 public static final Capability<PhaseInfo> PHASE = null;
	
	private PhaseInfo instance = PHASE.getDefaultInstance(); 
	 
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PHASE;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		 return capability == PHASE ? PHASE.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PHASE.getStorage().writeNBT(PHASE, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PHASE.getStorage().readNBT(PHASE, this.instance, null, nbt);
		
	}

}
