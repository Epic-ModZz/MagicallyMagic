package com.Epic_ModZz.Magically_Magic.init;

import com.Epic_ModZz.Magically_Magic.PlayerInfo.PhaseInfo;
import com.Epic_ModZz.Magically_Magic.util.handlers.CapabilityHandler;
import com.Epic_ModZz.Magically_Magic.util.handlers.EventHandler;
import com.Epic_ModZz.Magically_Magic.util.handlers.PhaseHandler;
import com.Epic_ModZz.Magically_Magic.util.handlers.PhaseManager;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityInit {
	
	public static void init () {
	
	CapabilityManager.INSTANCE.register(PhaseInfo.class, new PhaseManager(), PhaseHandler.class);

    MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
}
