package com.Epic_ModZz.Magically_Magic.util.handlers;

import com.Epic_ModZz.Magically_Magic.MagicPlayerAbilities.PhaseProvider;
import com.Epic_ModZz.Magically_Magic.PlayerInfo.PhaseInfo;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventHandler {
	@SubscribeEvent
	 public void onPlayerLogsIn(PlayerLoggedInEvent event)
	 {
	 EntityPlayer player = event.player;
	 PhaseInfo State = player.getCapability(PhaseProvider.PHASE, null);
	 String curent = "hi";
	 
	 if(State.get()) {
		 curent = "true";
	 }else {
		 curent = "false";
	 }
	 
	 

	 }
	
	
	@SubscribeEvent
	public void OnDrawBlockHighlight(DrawBlockHighlightEvent event) {
		 EntityPlayer player = event.getPlayer();
		 PhaseInfo State = player.getCapability(PhaseProvider.PHASE, null);
		 if(State.get()) {
			 event.setCanceled(true);
		 }else {
			 
		 }
	}


	@SubscribeEvent
	public void OnLivingUpdate(LivingUpdateEvent event) {
		 Entity entity = event.getEntity();	
		if (entity.world.isRemote && (entity instanceof EntityPlayer)) {
			EntityPlayer player = (EntityPlayer) entity;
		 	PhaseInfo State = player.getCapability(PhaseProvider.PHASE, null);
		 	if(State.get()) {
		 		player.noClip = true;
		 		player.capabilities.isFlying = true;
		 		
		 	}
		}
	}
	
	
	

}
/*
		 		player.setEntityBoundingBox(player.getEntityBoundingBox());
		 		 String message = String.format(player.getEntityBoundingBox().toString());
		 		 player.sendMessage(new TextComponentString(message));
*/