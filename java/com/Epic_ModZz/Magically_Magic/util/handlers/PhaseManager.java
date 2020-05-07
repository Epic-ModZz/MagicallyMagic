package com.Epic_ModZz.Magically_Magic.util.handlers;

import com.Epic_ModZz.Magically_Magic.PlayerInfo.PhaseInfo;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class PhaseManager implements IStorage<PhaseInfo>{


	//CapabilityManager.INSTANCE.register(PhaseInfo.class, new PhaseManager(), PhaseHandler.class);
	
	
	@Override
	public NBTBase writeNBT(Capability<PhaseInfo> capability, PhaseInfo instance, EnumFacing side) {
		return new NBTTagFloat(instance.convertfloat());
	}

	@Override
	public void readNBT(Capability<PhaseInfo> capability, PhaseInfo instance, EnumFacing side, NBTBase nbt) {
		instance.set(((NBTPrimitive) nbt).getFloat());	
	}
}

