package com.Epic_ModZz.Magically_Magic.util.handlers;



import javax.annotation.Resource;

import com.Epic_ModZz.Magically_Magic.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	public static final ResourceLocation SHADE = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "shade"));

}
