package com.Epic_ModZz.Magically_Magic.util.handlers;

import com.Epic_ModZz.Magically_Magic.MagicPlayerAbilities.PhaseProvider;
import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {

	public static final ResourceLocation PHASE = new ResourceLocation(Reference.MOD_ID, "phase");
	
	
	 @SubscribeEvent
	 public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	 {
		 
	 if (!(event.getObject() instanceof EntityPlayer)) return;

	 	event.addCapability(PHASE, new PhaseProvider());
	 }
	 
	 
	
}
